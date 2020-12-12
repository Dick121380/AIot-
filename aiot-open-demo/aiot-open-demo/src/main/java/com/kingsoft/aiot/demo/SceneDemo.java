package com.kingsoft.aiot.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.kingsoft.aiot.pojo.CreateSceneParam;
import com.kingsoft.aiot.util.HttpUtils;

import java.util.Arrays;
import java.util.HashMap;

import static com.kingsoft.aiot.constant.UrlConstant.*;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.demo.SceneDemo
 * @description  场景DEMO
 * @date 2020-04-21 15:39
 */
public class SceneDemo {

    /**
     * automatic： true 自动场景   false 手动场景 没有触发条件，可以用小爱调用
     */
    public static void createScene(){
        String data = "{\n" +
                "    \"sceneName\":\"门磁打开温控器到指定温度\",\n" +
                "    \"automatic\":true,\n" +
                "    \"action\":[\n" +
                "        {\n" +
                "            \"deviceId\":\"1335878483779325953\",\n" +
                "             \"command\":\"lumi.airrtc.tcpecn02.set_power\",\n" +
                "                \"keyName\":\"关\",\n" +
                "                \"model\":\"lumi.airrtc.tcpecn02\",\n" +
                "                \"saId\":1850,\n" +
                "                \"trId\":201,\n" +
                "                \"type\":0,\n" +
                "                \"value\":[\n" +
                "                    \"off\"\n" +
                "                ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"express\":1,\n" +
                "    \"launch\":[\n" +
                "        {\n" +
                "            \"deviceId\":\"1335881684167495681\",\n" +
                "            \"command\":\"event.lumi.sensor_magnet.aq2.open\",\n" +
                "            \"enable\":true,\n" +
                "            \"keyName\":\"打开\",\n" +
                "            \"model\":\"lumi.sensor_magnet.aq2\",\n" +
                "            \"scId\":272,\n" +
                "            \"trId\":107,\n" +
                "            \"value\":\"\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"timeSpan\":{\n" +
                "        \"endMin\":59,\n" +
                "        \"beginHour\":0,\n" +
                "        \"beginMin\":0,\n" +
                "        \"endHour\":23,\n" +
                "        \"weekDay\":[\n" +
                "            0,\n" +
                "            1,\n" +
                "            2,\n" +
                "            3,\n" +
                "            4,\n" +
                "            5,\n" +
                "            6\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        HashMap body = JSONUtil.toBean(JSONUtil.toJsonStr(data), HashMap.class);
        Console.log(JSONUtil.toJsonStr(body));
        HttpUtils.send(SCENE_CREATE,"POST",null,body);
    }

    //获取设备支持的场景模版，里面很多参数是新建场景时用到的————————获取设备支持场景参数
    public static void getSceneTemplateInfo(){
        String deviceId = "1335881684167495681";
        String param = "deviceId="+deviceId;
        HttpUtils.send(SCENE_GET_TEMPLATE_INFO,"GET",param,null);
    }

    //  usId  取值创建 场景返回data——————————获取场景信息（deviceId、usId）
    public static void getSceneInfo(){
        String deviceId = "1335878483779325953";
        String usId = "2741587130";
        String param = "deviceId="+deviceId+"&usId="+usId;
        HttpUtils.send(SCENE_GET_INFO,"GET",param,null);
    }

    //  usId  取值创建 场景返回data————————执行场景   2731139977
    public static void startScene(){
        String deviceId = "1328536407863336962";
        String usId = "2756021203";
        String param = "deviceId="+deviceId+"&usId="+usId;
        HttpUtils.send(SCENE_START,"GET",param,null);
    }

    //通过deviceID获取其已创建的场景——————————获取已建场景列表（deviceId）
    public static void getDeviceScene(){
        String deivceId="1332305096959377409";
        String param = "deviceId="+deivceId;
        HttpUtils.send(SCENE_LIST_DEVICE,"GET",param,null);
    }

    //删除场景——————————删除场景（deviceId）
    public static void DeleteScene(){
        String deviceId = "1330767102494519297";
        String usId = "2770994019";
        String param = "deviceId="+deviceId+"&usId="+usId;
        HttpUtils.send(SCENE_DELETE,"GET",param,null);
    }

}
