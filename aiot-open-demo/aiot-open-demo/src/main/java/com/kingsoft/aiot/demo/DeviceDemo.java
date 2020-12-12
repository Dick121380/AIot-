package com.kingsoft.aiot.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Validator;
import com.kingsoft.aiot.enums.PropertyEnums;
import com.kingsoft.aiot.util.HttpUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.kingsoft.aiot.constant.UrlConstant.*;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.demo.DeviceDemo
 * @description   设备 物模型 demo
 * @date 2020-04-13 19:40
 *function：查询控制设备，控制、查询、重命名时需要更改deviceId，deviceId可以通过获取设备列表中得到即deviceParentNodePage（）函数
 * */
public class DeviceDemo {

    /**
     * 获取用户下所有设备  已分页
     * 参数：account为展箱的controlId
     */
    public static void deviceParentNodePage(){
        String params = "account="+account+"&pageNumber=1&pageSize=100";
        HttpUtils.send(DEVICE_PARENT_NODE_PAGE,"GET",params,null);
    }

    public void SetDeviceId(){

    }

    /**
     * 设备重命名，
     * 参数：deviceId为设备ID，来自设备列表中deviceID
     * deviceName：要改为的名字，更改设备新的名字即可修改设备名称
     */
    public static void deviceUpdateName(String newname,String deviceId){//原来只能改小爱的
        // old Name : Aqara墙壁插座（ZigBee版）
        // deviceName为新的名字，输入新的名称即可
        String deviceName = newname;
        // 设备列表获取

        String params = "deviceName="+deviceName+"&deviceId="+deviceId;
        HttpUtils.send(DEVICE_UPDATE_NAME,"GET",params,null);
    }

    /**
     * 获取多键开关信息，暂用不上
     */
    public static void deviceMultiButtonInfo(){
        // 设备ID 标识
        String deviceId = "1253248253042937858";
        String params = "deviceId="+deviceId;
        HttpUtils.send(DEVICE_MULTI_BUTTON_INFO,"GET",params,null);
    }

    /**
     * 设置多键开关的按键名
     */
    public static void deviceMultiButtonRename(){
        // 设备名称
        String deviceName = "床头灯/卧室";
        // 设备列表获取
        String deviceId = "1253248253042937858";
        String params = "deviceName="+deviceName+"&deviceId="+deviceId;
        HttpUtils.send(DEVICE_MULTI_BUTTON_RENAME,"GET",params,null);

    }

    /**
     * 设备解绑
     */
    public static void deviceUnbind(){
        // 设备ID 标识
        String deviceId = "1328669474726871042";
        String params = "deviceId="+deviceId;
        HttpUtils.send(DEVICE_UNBIND,"GET",params,null);
    }

    /**
     * 操作设备属性
     */
    public static void deviceUpdateProperty(){
        String params = "";
        Map<String, Object> body = new HashMap<String, Object>(16);
        //很离谱的一段代码
        body.put("deviceId", "1335910002456485889");  // deviceId : 从 deviceParentNodePage() 接口获取
        body.put("propertyCode","fan_level");// 属性Code Value  从 metaTypeProductModel() 接口获取
        body.put("value","2");
        HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",params,body);
    }

    /**
     * 获取物模型
     */
    public static void metaTypeProductModel(){
        // 模型Code  从 deviceParentNodePage() 接口获取
        String productCode = "lumi.airrtc.tcpecn02";
        String params = "productCode="+productCode;
        HttpUtils.send(META_TYPE_PRODUCT_MODEL,"GET",params,null);
    }


    /**
     * 查询设备属性列表
     */
    public static void deviceQueryPropertyList(){
        // deviceId : 从 deviceParentNodePage() 接口获取
        // 属性Code Value  从 metaTypeProductModel() 接口获取  对应设备ID
        Map<String, Object> body = new HashMap<String, Object>(16);
        String arr[] ={"temperature","humidity","pressure"};//propertyCode
        body.put("deviceId", "1335878483779325953");
        body.put("propertyCode", Arrays.asList(arr));
//        body.put("propertyCode", Arrays.asList(PropertyEnums.QINGPING_CHARGING_STATE.getPropertyCode()))
        HttpUtils.send(DEVICE_QUERY_PROPERTY_LIST,"POST",null,body);
    }

    /**
     * 查询产品列表
     */
    public static void metaTypeProductList(){
        HttpUtils.send(META_TYPE_PRODUCT_LIST,"GET",null,null);
    }


    public static void deviceInfo(){
        String deviceId = "1335878483779325953";
        String param = "deviceId="+deviceId;
        HttpUtils.send(DEVICE_INFO,"GET",param,null);
    }


}
