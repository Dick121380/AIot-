package com.kingsoft.aiot.util;

import cn.hutool.core.lang.Console;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.kingsoft.aiot.constant.UrlConstant.*;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.util.HttpUtils
 * @description
 * @date 2020-04-13 14:22
 */
public class HttpUtils {

    /**
     * 1.	Http Method, 大写。例如 GET, POST。加换行符 \n
     * 2.	URI请求路径，域名之后参数之前部分。加换行符 \n
     * 3.	规范化的 query params，如无参数，使用空字符串。加换行符 \n
     * 4.	请求中body（如无参数，使用空字符串）。加换行符 \n
     * 5.	请求当前时间戳，13位。加换行符 \n。
     * 6.	加盐
     */
    public static double AskTemperature(String url,String method, String param, Map body){
        if (!"GET".equals(method) && !"POST".equals(method)){
            Console.log("请求方式错误 Http Method, 大写。例如 GET, POST。");
            return -100;
        }
        if (Objects.isNull(param)){
            param = "";
        }
        if (MapUtil.isEmpty(body)){
            body = new HashMap();
        }
        // param key 升序
        param = paramOrder(param);
        // 获取加密盐
        int salt = (appKey + appSecret).hashCode();
        //Console.log("...................salt:");
        //Console.log(salt);
        // 获取当前时间戳
        String timeStamp = String.valueOf(System.currentTimeMillis());
        //Console.log("timetamp:"+timeStamp);
        // 加密 获取签名  加换行符 \n
        String bodyJson = JSON.toJSONString(body);
        String tobeSigned = method + "\n"
                + url + "\n"
                + param + "\n"
                + ("GET".equals(method) ? "": bodyJson) + "\n"
                + timeStamp + "\n"
                + salt;
        // 计算签名 需替换 空字符串
        tobeSigned = "GET".equals(method) ? tobeSigned.replaceAll(" ", ""): tobeSigned;
        //Console.log("待签名参数 ======================== \n{}",tobeSigned);
        //Console.log("=================================");

        // 进行Md5加密取大写。Md5(待加密字符串). toUpperCase()
        String sign = MD5Util.MD5(tobeSigned).toUpperCase();
        //Console.log("md5:"+sign);
        HttpRequest request1;
        if ("GET".equals(method)){
            request1 = HttpUtil.createGet(path + url);
            request1.form(paramOrderToMap(param));
            request1.header("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        } else {
            request1 = HttpUtil.createPost(path + url);
            request1.header("Content-Type","application/json;charset=UTF-8")
                    .body(bodyJson);
        }
        request1.header("appKey", appKey)
//                .header("appSecret", appSecret)
                .header("timestamp", timeStamp)
                .header("signature", sign);
        HttpResponse execute = request1.execute();
        //Console.log("request path :{}",request.getUrl());
        //Console.log("request ========================= \n{}",request);
        //System.out.println(request);//这是我自己添加的一行
        String result = execute.body();
        //Console.print("request result ========================= \n{}",result);
        //System.out.println(result);
        int index=result.indexOf("value");//从result（一大串）中提取出我们想要的关键数字，此处找value即可
        int numStartIndex=result.indexOf("\"",index+6);//限制条件
        int numEndIndex=result.indexOf("\"",numStartIndex+1);
        String num=result.substring(numStartIndex+1,numEndIndex);
        double value=Double.parseDouble(num);
        //System.out.println(value);
        //System.out.print("第一个双引号在"+numStartIndex+"出现，相对位置为"+delta);
        //System.out.println("\nvalue的v新的限制为"+index);
        //String num;
        //result.
        return value;
    }

    public static String send(String url,String method, String param, Map body){
        if (!"GET".equals(method) && !"POST".equals(method)){
            Console.log("请求方式错误 Http Method, 大写。例如 GET, POST。");
            return "";
        }
        if (Objects.isNull(param)){
            param = "";
        }
        if (MapUtil.isEmpty(body)){
            body = new HashMap();
        }
        // param key 升序
        param = paramOrder(param);
        // 获取加密盐
        int salt = (appKey + appSecret).hashCode();
        Console.log("...................salt:");
        Console.log(salt);
        // 获取当前时间戳
        String timeStamp = String.valueOf(System.currentTimeMillis());
        Console.log("timetamp:"+timeStamp);
        // 加密 获取签名  加换行符 \n
        String bodyJson = JSON.toJSONString(body);
        String tobeSigned = method + "\n"
                + url + "\n"
                + param + "\n"
                + ("GET".equals(method) ? "": bodyJson) + "\n"
                + timeStamp + "\n"
                + salt;
        // 计算签名 需替换 空字符串
        tobeSigned = "GET".equals(method) ? tobeSigned.replaceAll(" ", ""): tobeSigned;
        Console.log("待签名参数 ======================== \n{}",tobeSigned);
        Console.log("=================================");

        // 进行Md5加密取大写。Md5(待加密字符串). toUpperCase()
        String sign = MD5Util.MD5(tobeSigned).toUpperCase();
        Console.log("md5:"+sign);
        HttpRequest request;
        if ("GET".equals(method)){
            request = HttpUtil.createGet(path + url);
            request.form(paramOrderToMap(param));
            request.header("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
        } else {
            request = HttpUtil.createPost(path + url);
            request.header("Content-Type","application/json;charset=UTF-8")
                    .body(bodyJson);
        }
        request.header("appKey", appKey)
//                .header("appSecret", appSecret)
                .header("timestamp", timeStamp)
                .header("signature", sign);
        HttpResponse execute = request.execute();
        Console.log("request path :{}",request.getUrl());
        Console.log("request ========================= \n{}",request);
        String result = execute.body();
        Console.print("request result ========================= \n{}",result);
        return result;
    }




    private static Map paramOrderToMap(String param){
        if (StrUtil.isBlank(param)){
            return new HashMap();
        }
        List<String> params = Arrays.asList(param.split("&"));
        HashMap<String,String> paramMap = new HashMap<>();
        params.stream().forEach(item->{
            paramMap.put(item.split("=")[0],item.split("=")[1]);
        });

        // map 根据key 排序返回 新map
        HashMap<String,String> paramMapNew = paramMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        return paramMapNew;
    }

    private static String paramOrder(String param){
        if (StrUtil.isBlank(param)){
            return "";
        }
        List<String> params = Arrays.asList(param.split("&"));
        HashMap<String,String> paramMap = new HashMap<>();
        params.stream().forEach(item->{
            paramMap.put(item.split("=")[0],item.split("=")[1]);
        });

        // map 根据key 排序返回 新map
        HashMap<String,String> paramMapNew = paramMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        String requestParam = paramMapNew.keySet().stream().map(k -> (k + "=" + paramMapNew.get(k)))
                .reduce((p, kv) -> p + "&" + kv).get();
        return requestParam;
    }
}
