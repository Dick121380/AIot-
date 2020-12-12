package com.kingsoft.aiot.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kingsoft.aiot.enums.PropertyEnums;
import com.kingsoft.aiot.pojo.GetDeviceByParentNodeVO;
import com.kingsoft.aiot.util.HttpUtils;

import java.util.*;

import static com.kingsoft.aiot.constant.UrlConstant.*;

/**
 * @Author: kangzhifeng
 * @Description:
 * @Date: Create in 11:50 2020/5/27
 */
public class DeliveryMain {

    private static List<String> account = Lists.newArrayList("1353562500");

    private static long thread_sleep = 5000l;

    public static void main(String[] args) {

        String params = "account=" + account.get(0) + "&pageNumber=1&pageSize=100";
        String deviceList = HttpUtils.send(DEVICE_PARENT_NODE_PAGE, "GET", params, null);
        JSONObject jsonObject = JSONUtil.parseObj(deviceList);
        HashMap<String, String> model_deviceId = Maps.newHashMap();
        List<GetDeviceByParentNodeVO> devices = jsonObject.getJSONObject("data").getJSONArray("data").toList(GetDeviceByParentNodeVO.class);
        devices.stream().forEach(device -> {
            if (device.getStatus() == 0){
                return;
            }
            // 控制设备
            updateProperty(device);

            // 设备标识  物模型
            model_deviceId.put(device.getProductCode(),device.getDeviceId());

        });

        // 场景
        // TODO 有人移动开D1右键
        String scene1 = "{\"sceneName\":\"有人移动开D1右键\",\"automatic\":true,\"action\":[{\"deviceId\":\"1259807721394290690\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"开右键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2894,\"trId\":201,\"type\":0,\"value\":[\"channel_1\",\"on\"]}],\"express\":0,\"launch\":[{\"deviceId\":\"1259807721394290690\",\"command\":\"event.lumi.sensor_motion.aq2.motion\",\"enable\":true,\"keyName\":\"有人移动\",\"model\":\"lumi.sensor_motion.aq2\",\"scId\":264,\"trId\":108,\"value\":\"\"}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 高于29度开窗帘
//        String scene2 = "{\"sceneName\":\"高于29度开窗帘\",\"automatic\":true,\"action\":[{\"deviceId\":\"1259791615652806658\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"开\",\"model\":\"lumi.curtain.v1\",\"saId\":215,\"trId\":201,\"type\":0,\"value\":\"open\"}],\"express\":0,\"launch\":[{\"deviceId\":\"1259791615652806658\",\"command\":\"prop.lumi.weather.v1.temperature\",\"enable\":true,\"keyName\":\"高于指定温度\",\"model\":\"lumi.weather.v1\",\"scId\":260,\"trId\":110,\"value\":{\"min\":29}}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 门磁打开开窗帘开D1左键
        String scene3 = "{\"sceneName\":\"门磁打开开窗帘开D1左键\",\"automatic\":true,\"action\":[{\"deviceId\":\"1265177852156870658\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"开\",\"model\":\"lumi.curtain.v1\",\"saId\":215,\"trId\":201,\"type\":0,\"value\":\"open\"},{\"deviceId\":\"1264859252262809601\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"开左键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2888,\"trId\":201,\"type\":0,\"value\":[\"channel_0\",\"on\"]}],\"express\":0,\"launch\":[{\"deviceId\":\"1264838365283201026\",\"command\":\"event.lumi.sensor_magnet.aq2.open\",\"enable\":true,\"keyName\":\"打开\",\"model\":\"lumi.sensor_magnet.aq2\",\"scId\":272,\"trId\":107,\"value\":\"\"}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 门磁打开开窗帘开D1左键
        String scene4 = "{\"sceneName\":\"门磁打开开窗帘开D1左键\",\"automatic\":true,\"action\":[{\"deviceId\":\"1265177852156870658\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"关\",\"model\":\"lumi.curtain.v1\",\"saId\":216,\"trId\":201,\"type\":0,\"value\":\"close\"},{\"deviceId\":\"1264859252262809601\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"关左键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2889,\"trId\":201,\"type\":0,\"value\":[\"channel_0\",\"off\"]}],\"express\":0,\"launch\":[{\"deviceId\":\"1264838365283201026\",\"command\":\"event.lumi.sensor_magnet.aq2.close\",\"enable\":true,\"keyName\":\"关上\",\"model\":\"lumi.sensor_magnet.aq2\",\"scId\":273,\"trId\":107,\"value\":\"\"}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 单击无线开关左键开灯开窗帘
        String scene5 = "{\"sceneName\":\"单击无线开关左键开灯开窗帘\",\"automatic\":true,\"action\":[{\"deviceId\":\"1265191442733629442\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"开左键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2888,\"trId\":201,\"type\":0,\"value\":[\"channel_0\",\"on\"]},{\"deviceId\":\"1265191442242895873\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"开\",\"model\":\"lumi.curtain.v1\",\"saId\":215,\"trId\":201,\"type\":0,\"value\":\"open\"}],\"express\":0,\"launch\":[{\"deviceId\":\"1265192449337229314\",\"command\":\"event.lumi.remote.b286acn02.click_ch0\",\"enable\":true,\"keyName\":\"单击左键\",\"model\":\"lumi.remote.b286acn02\",\"scId\":1541,\"trId\":101,\"value\":\"\"}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 单击无线开关右键关灯关窗帘
        String scene6 = "{\"sceneName\":\"单击无线开关右键关灯关窗帘\",\"automatic\":true,\"action\":[{\"deviceId\":\"1265178357197209602\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"关左键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2889,\"trId\":201,\"type\":0,\"value\":[\"channel_0\",\"off\"]},{\"deviceId\":\"1265200755086753794\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"关\",\"model\":\"lumi.curtain.v1\",\"saId\":216,\"trId\":201,\"type\":0,\"value\":\"close\"}],\"express\":0,\"launch\":[{\"deviceId\":\"1264839119893016578\",\"command\":\"event.lumi.remote.b286acn02.click_ch1\",\"enable\":true,\"keyName\":\"单击右键\",\"model\":\"lumi.remote.b286acn02\",\"scId\":1542,\"trId\":101,\"value\":\"\"}],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 开零火右键开窗帘  训练 我回来了
        String scene7 = "{\"sceneName\":\"开零火右键开窗帘\",\"automatic\":false,\"action\":[{\"deviceId\":\"1259807721394290690\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"开右键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2894,\"trId\":201,\"type\":0,\"value\":[\"channel_1\",\"on\"]},{\"deviceId\":\"1259807721394290690\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"开\",\"model\":\"lumi.curtain.v1\",\"saId\":215,\"trId\":201,\"type\":0,\"value\":\"open\"}],\"express\":0,\"launch\":[],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";
        // TODO 关零火右键关窗帘  训练 我去上课了
        String scene8 = "{\"sceneName\":\"关零火右键关窗帘\",\"automatic\":false,\"action\":[{\"deviceId\":\"1264859252262809601\",\"command\":\"lumi.switch.b2nacn02.toggle_ctrl_neutral\",\"keyName\":\"关右键灯\",\"model\":\"lumi.switch.b2nacn02\",\"saId\":2895,\"trId\":201,\"type\":0,\"value\":[\"channel_1\",\"off\"]},{\"deviceId\":\"1265177852156870658\",\"command\":\"lumi.curtain.v1.toggle_device\",\"keyName\":\"关\",\"model\":\"lumi.curtain.v1\",\"saId\":216,\"trId\":201,\"type\":0,\"value\":\"close\"}],\"express\":0,\"launch\":[],\"timeSpan\":{\"endMin\":59,\"beginHour\":0,\"beginMin\":0,\"endHour\":23,\"weekDay\":[0,1,2,3,4,5,6]}}";

        Map<String, String> skillScene = Maps.newHashMap();
        skillScene.put("开零火右键开窗帘","我回来了");
        skillScene.put("关零火右键关窗帘","我去上课了");

        List<String> sceneList = Lists.newArrayList(scene1, scene3, scene4, scene5, scene6,scene7,scene8);
        createScene(sceneList,skillScene,model_deviceId);

    }

    private static void createScene(List<String> sceneList, Map<String, String> skillScene,Map<String, String> model_deviceId) {
        List<String> errorScene = Lists.newArrayList();
        sceneList.stream().forEach(scene->{
            try {
                JSONObject sceneJson = JSONUtil.parseObj(scene);
                List<JSONObject> actions = sceneJson.getJSONArray("action").toList(JSONObject.class);
                actions.stream().forEach(action->{
                    action.put("deviceId",model_deviceId.get(action.getStr("model")));
                });
                List<JSONObject> launchs = sceneJson.getJSONArray("launch").toList(JSONObject.class);
                launchs.stream().forEach(launch->{
                    launch.put("deviceId",model_deviceId.get(launch.getStr("model")));
                });
                HashMap body = JSONUtil.toBean(sceneJson, HashMap.class);
                String post = HttpUtils.send(SCENE_CREATE, "POST", null, body);
                Integer code = JSONUtil.parseObj(post).getInt("code");
                // TODO 场景创建成功 && 没有触发条件时 创建小爱训练
                if (code == 200){
                    Long data = JSONUtil.parseObj(post).getLong("data");
                    if (launchs.size() == 0){
                        HashMap<String, Object> skillBody = new HashMap<>();
                        skillBody.put("deviceId",model_deviceId.get("xiaomi.wifispeaker.lx04"));    // 设备标识
                        skillBody.put("trigger", Arrays.asList(skillScene.get(sceneJson.getStr("sceneName"))));   //音箱需要响应的语调
                        JSONObject result = new JSONObject();
                        result.put("type",3);       //训练类型, 0 语音回复,3 触发场景
                        result.put("value",data+":"+sceneJson.getStr("sceneName"));     //取值, type=0,小爱需要回复的语调,type = 3,取值为 场景 id: 场景名称
                        skillBody.put("result",result);
                        HttpUtils.send(SKILL_ADD,"POST",null,skillBody);
                    }
                } else {
                    // TODO 创建失败记录场景
                    errorScene.add(scene);
                }
            } catch (Exception e) {
                // TODO 创建失败记录场景
                errorScene.add(scene);
            }

        });
        Console.log(errorScene);
    }

    private static void updateProperty(GetDeviceByParentNodeVO deviceByParentNodeVO){
        Map<String, Object> body = new HashMap<String, Object>(16);
        // deviceId : 从 deviceParentNodePage() 接口获取
        body.put("deviceId", deviceByParentNodeVO.getDeviceId());
        try {
            switch (deviceByParentNodeVO.getProductCode()){
                case "lumi.curtain.v1" : // TODO 窗帘电机
                    // 窗帘打开
                    body.put("propertyCode", PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_OPEN.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_OPEN.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("窗帘电机打开");
                    Thread.sleep(thread_sleep);
                    // 窗帘关闭
                    body.put("propertyCode", PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_CLOSE.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_CLOSE.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("窗帘电机关闭");
                    Thread.sleep(thread_sleep);
                    break;
                case "lumi.ctrl_86plug.aq1": // TODO 墙壁插座
                    body.put("propertyCode", PropertyEnums.LUMI_CTRL_86PLUG_POWER_OPEN.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_CTRL_86PLUG_POWER_OPEN.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁插座打开");
                    Thread.sleep(thread_sleep);

                    body.put("propertyCode", PropertyEnums.LUMI_CTRL_86PLUG_POWER_CLOSE.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_CTRL_86PLUG_POWER_CLOSE.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁插座关闭");
                    break;
                case "lumi.switch.b2nacn02":// TODO 墙壁开关
                    body.put("propertyCode", PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_OPEN.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_OPEN.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁开关左键打开");
                    Thread.sleep(thread_sleep);

                    body.put("propertyCode", PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_CLOSE.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_CLOSE.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁开关左键关闭");
                    Thread.sleep(thread_sleep);

                    body.put("propertyCode", PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_OPEN.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_OPEN.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁开关右键打开");
                    Thread.sleep(thread_sleep);

                    body.put("propertyCode", PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_CLOSE.getPropertyCode());
                    body.put("value", PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_CLOSE.getPropertyValue());
                    HttpUtils.send(DEVICE_UPDATE_PROPERTY,"POST",null,body);
                    Console.log("墙壁开关左键关闭");
                    Thread.sleep(thread_sleep);
                    break;
                default:
                    Console.error("{},没有设备控制配置。",deviceByParentNodeVO.getProductCode());
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
