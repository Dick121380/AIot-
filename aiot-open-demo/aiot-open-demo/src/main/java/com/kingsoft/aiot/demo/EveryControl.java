package com.kingsoft.aiot.demo;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.kingsoft.aiot.enums.PropertyEnums;
import com.kingsoft.aiot.util.HttpUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.kingsoft.aiot.constant.UrlConstant.*;

public class EveryControl {

    static String xiaoai_deviceId = "1310855961932681217";//小爱音箱
    static String linghuo_switch_deviceId = "1285784952786210818";//零火线开关
    static String wuxian_switch_deviceId = "1336326620916391937";//无线开关
    static String danhuo_switch_deviceId = "1261262304217772033";//单火线开关
    static String danhuo_switch_dual_deviceId = "1278589475488284673";//带火线开关*2
    static String chuanglian_deviceId = "1285785747397103617";//窗帘
    static String wenshidu_sensor_deviceId = "1336324993748738050";//温湿度
    static String chazuo_deviceId = "1285785151743021058";//插座
    static String kongqijinghua_deviceId = "1326139622014689281";//空气净化器
    static String kongtiao_deviceId = "1285784159450386434";//空调
    static String menci_sensor_deviceId = "1278589224492744706";//门磁感应
    static String renti_sensor_deviceId = "1278589224920563713";//人体红外
    static String qingping_deviceId = "1286284620748963841";//青萍
    static String taideng_deviceId = "1286292572713140226";//台灯
    static String kongjinF1_deviceId = "1326139622014689281";//?

    public static double getInfo(String deviceid, String propertyCode) {//自定义方法，与getquery对应
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("deviceId", deviceid);
        body.put("propertyCode", Arrays.asList(propertyCode));
        return HttpUtils.AskTemperature(DEVICE_QUERY_PROPERTY_LIST, "POST", null, body);

    }
    public static void deviceControl(String deviceid, String propertyCode, String value) {
        String params = "";
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("deviceId", deviceid);
        body.put("propertyCode", propertyCode);
        body.put("value", value);
        HttpUtils.send(DEVICE_UPDATE_PROPERTY, "POST", params, body);
    }

    public static void deviceControl1(String deviceid, String propertyCode, int value) {
        String params = "";
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("deviceId", deviceid);
        body.put("propertyCode", propertyCode);
        body.put("value", value);
        HttpUtils.send(DEVICE_UPDATE_PROPERTY, "POST", params, body);
    }

    public static void getQuery(String deviceid, String propertyCode) {
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("deviceId", deviceid);
        body.put("propertyCode", Arrays.asList(propertyCode));
        HttpUtils.send(DEVICE_QUERY_PROPERTY_LIST, "POST", null, body);
    }

    public static void getQueryAll(String deviceid, List propertyCode) {
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("deviceId", deviceid);
        body.put("propertyCode", propertyCode);
        HttpUtils.send(DEVICE_QUERY_PROPERTY_LIST, "POST", null, body);
    }


    /**
     * 单独列出——窗帘电机控制
     */
    public static void Curtain(String value) {
        if (value.equals("0")) {
            deviceControl(chuanglian_deviceId, PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_PAUSE.getPropertyCode(), value);
        } else if (value.equals("1")) {
            deviceControl(chuanglian_deviceId, PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_OPEN.getPropertyCode(), value);
        } else if (value.equals("2")) {
            deviceControl(chuanglian_deviceId, PropertyEnums.LUMI_CURTAIN_MOTOR_CONTROL_CLOSE.getPropertyCode(), value);
        } else {
            System.out.println("参数错误");
        }
    }

    /**
     * 单独列出——小爱音箱的静音控制
     */
    public static void SpeakerMute(String value) {
        if (value.equals("0")) {
            deviceControl(xiaoai_deviceId, PropertyEnums.XIAOMI_WIFISPEAKER_MICROPHONE_MUTE_CLOSE.getPropertyCode(), value);
        } else if (value.equals("1")) {
            deviceControl(xiaoai_deviceId, PropertyEnums.XIAOMI_WIFISPEAKER_MICROPHONE_MUTE_OPEN.getPropertyCode(), value);
        } else {
            System.out.println("参数错误");
        }
    }

    /**
     * 单独列出——小爱音箱的音量大小控制
     */
    public static void SpeakerVolume(String value) {
        deviceControl(xiaoai_deviceId, PropertyEnums.XIAOMI_WIFISPEAKER_VOLUME.getPropertyCode(), value);
    }

    /**
     * 单独列出——小爱音箱播放控制
     */
    public static void SpeakerPlayStatus() {

//        getQuery(xiaoai_deviceId, PropertyEnums.R_XIAOMI_WIFISPEAKER_PLAYING_STATE.getPropertyCode());
        getQuery("1326139206996697089", "battery");

    }

    /**
     * 单独列出——小爱音箱定时播放
     */
    public static void SpeakerTimePlay(String day, String hour, String min, String value) {
        SkillDemo.skillTimePlay(xiaoai_deviceId, "0", "2", day, hour, min, value);

    }

    /**
     * 单独列出——小爱音箱获取定时播放列表
     */
    public static void SpeakerTimePlayList() {
        SkillDemo.GetBroadcstList();
    }

    /**
     * 单独列出——小爱音箱删除定时播放
     */
    public static void DelSpeakerTimePlay() {
        SkillDemo.DelBroadcast();
    }

    /**
     * 单独列出——小爱音箱训练(回复语音)
     */
    public static void SpeakerSkillAddAudio(String value1, String value2) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("deviceId", xiaoai_deviceId);    // 小爱音箱设备标识
        body.put("trigger", Arrays.asList(value1));   //音箱触发语调
        JSONObject result = new JSONObject();
        result.put("type", 0);       //训练类型, 0 语音回复,3 触发场景
        result.put("value", value2);     //取值, type=0,小爱需要回复的语调,type = 3,取值为 "场景id: 场景名称"
        body.put("result", result);
        HttpUtils.send(SKILL_ADD, "POST", null, body);
    }

    /**
     * 单独列出——小爱音箱训练（执行场景）
     */
    public static void SpeakerSkillAddScene(String value1) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("deviceId", xiaoai_deviceId);    // 小爱音箱设备标识
        body.put("trigger", Arrays.asList(value1));   //音箱触发语调
        JSONObject result = new JSONObject();
        result.put("type", 3);       //训练类型, 0 语音回复,3 触发场景
        result.put("value", "2760968392:小爱开灯开窗帘开空调");     //取值, type=0,小爱需要回复的语调,type = 3,取值为 "场景id: 场景名称"
        body.put("result", result);
        HttpUtils.send(SKILL_ADD, "POST", null, body);
    }


    /**
     * 单独列出——智能插座控制
     */
    public static void Socket(String value) {
        if (value.equals("1")) {
            deviceControl(chazuo_deviceId, PropertyEnums.LUMI_CTRL_86PLUG_POWER_OPEN.getPropertyCode(), value);
        } else if (value.equals("0")) {
            deviceControl(chazuo_deviceId, PropertyEnums.LUMI_CTRL_86PLUG_POWER_CLOSE.getPropertyCode(), value);
        } else {
            System.out.println("参数错误，请输入1或者0");
        }

    }

    /**
     * 单独列出——查温度传感器
     */
    public static double GetSensorValue(String value) {//重写了这个方法，调用getinfo 而非getquery
        if (value.equals("0")) {
            return getInfo(wenshidu_sensor_deviceId, PropertyEnums.LUMI_WEATHER_TEMPERATURE.getPropertyCode());
        } else if (value.equals("1")) {
            return getInfo(wenshidu_sensor_deviceId, PropertyEnums.LUMI_WEATHER_HUMIDITY.getPropertyCode());
        } else if (value.equals("2")) {
            return getInfo(wenshidu_sensor_deviceId, PropertyEnums.LUMI_WEATHER_PRESSURE.getPropertyCode());
        } else {
            System.out.println("参数错误，请输入0或者1或者2");
            return -100;
        }
    }


    /**
     * 单独列出——青萍传感器
     */
    public static void GetQPSensor(String value) {
        switch (value) {
            case "0":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_CO2.getPropertyCode());
                break;
            case "1":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_HUMIDITY.getPropertyCode());
                break;
            case "2":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_TEMPERATURE.getPropertyCode());
                break;
            case "3":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_PM25.getPropertyCode());
                break;
            case "4":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_TVOC.getPropertyCode());
                break;
            case "5":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_CHARGING_STATE.getPropertyCode());
                break;
            case "6":
                getQuery(qingping_deviceId, PropertyEnums.QINGPING_BATTERY.getPropertyCode());
                break;
            case "7":
                List<String> propertyCodelist = new ArrayList<>();
                propertyCodelist.add(PropertyEnums.QINGPING_CO2.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_HUMIDITY.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_TEMPERATURE.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_PM25.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_TVOC.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_CHARGING_STATE.getPropertyCode());
                propertyCodelist.add(PropertyEnums.QINGPING_BATTERY.getPropertyCode());
                getQueryAll(qingping_deviceId, propertyCodelist);
                break;
            default:
                System.out.println("参数错误，请输入正确的参数0或者1或者2或者3");
        }
    }


    public static void setValue() {
        String value = "get_value";
        HashMap<String, Object> body = new HashMap<>();
        body.put("get_value", 1);    // 小爱音箱设备标识
        HttpUtils.send(DEVICE_UPDATE_PROPERTY, "POST", null, body);
    }

    /**
     * 单独列出——零火双键控制
     */
    public static void LHSwitch(String value) {
        switch (value) {
            case "0":
                deviceControl(linghuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_OPEN.getPropertyCode(), "1");
                break;
            case "1":
                deviceControl(linghuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B2NACN02_RIGHT_CLOSE.getPropertyCode(), "0");
                break;
            case "2":
                deviceControl(linghuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_OPEN.getPropertyCode(), "1");
                break;
            case "3":
                deviceControl(linghuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B2NACN02_LEFT_CLOSE.getPropertyCode(), "0");
                break;
            default:
                System.out.println("参数错误，请输入正确的参数0或者1或者2或者3");
        }
    }

    /**
     * 单独列出——无线双键控制
     */
    public static void WirelessSwitch(String value) {
            if(value.equals("0"))deviceControl(wuxian_switch_deviceId, PropertyEnums.LUMI_SWITCH_B286ACN02_LEFT_OPEN.getPropertyCode(), "1");


            else if(value.equals("1"))deviceControl(wuxian_switch_deviceId, PropertyEnums.LUMI_SWITCH_B286ACN02_LEFT_CLOSE.getPropertyCode(), "0");

            else if(value.equals("2"))deviceControl(wuxian_switch_deviceId, PropertyEnums.LUMI_SWITCH_B286ACN02_RIGHT_OPEN.getPropertyCode(), "1");


            else if(value.equals("3"))deviceControl(wuxian_switch_deviceId, PropertyEnums.LUMI_SWITCH_B286ACN02_RIGHT_CLOSE.getPropertyCode(), "0");


            else System.out.println("参数错误，请输入正确的参数0或者1或者2或者3");

    }

    /**
     * 单独列出——单火开关控制
     */
    public static void DHSwitch(String value) {//电源开关
        switch (value) {
            case "0":
                deviceControl(danhuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B1LACN02_CLOSE.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(danhuo_switch_deviceId, PropertyEnums.LUMI_SWITCH_B1LACN02_OPEN.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1");
        }
    }

    /**
     * 单独列出——单火双键开关控制
     */
    public static void DHDualSwitch(String value) {//电源开关
        switch (value) {
            case "0":
                deviceControl(danhuo_switch_dual_deviceId, PropertyEnums.LUMI_SWITCH_DANHUO_LEFT_OPEN.getPropertyCode(), "1");
                break;
            case "1":
                deviceControl(danhuo_switch_dual_deviceId, PropertyEnums.LUMI_SWITCH_DANHUO_LEFT_CLOSE.getPropertyCode(), "0");
                break;
            case "2":
                deviceControl(danhuo_switch_dual_deviceId, PropertyEnums.LUMI_SWITCH_DANHUO_RIGHT_OPEN.getPropertyCode(), "1");
                break;
            case "3":
                deviceControl(danhuo_switch_dual_deviceId, PropertyEnums.LUMI_SWITCH_DANHUO_RIGHT_CLOSE.getPropertyCode(), "0");
                break;
            default:
                System.out.println("参数错误，请输入0或者1");
        }
    }

    /**
     * 单独列出——米家台灯1S
     */
    public static void LampPower(String value) {//电源开关
        switch (value) {
            case "0":
                deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_POWER_CLOSE.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_POWER_OPEN.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1");
        }
    }

    public static void Brightness(String value) {//亮度调节
        deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_BRIGHTNESS.getPropertyCode(), value);
    }


    public static void BrightMode(String value) {//模式控制
        switch (value) {
            case "0":
                deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_MODE_READ.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_MODE_PC.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2");
        }
    }

    public static void Color_temperature(String value) {//色温调节
        deviceControl(taideng_deviceId, PropertyEnums.TAIDENG_MODE_COLOR_TEMPERATURE.getPropertyCode(), value);
    }


    /**
     * 单独列出——空气净化器控制
     */
    public static void AirCleanerPower(String value) {//电源开关
        switch (value) {
            case "0":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_POWER_OFF.getPropertyCode(), value);


                break;
            case "1":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_POWER_ON.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1");
        }
    }

    public static void AirCleanerMode(String value) {//模式控制
        switch (value) {
            case "0":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_MODE_AUTO.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_MODE_SLEEP.getPropertyCode(), value);
                break;
            case "2":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_MODE_CUSTOM.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2");
        }
    }

    public static void AirCleanerFanLevel(String value) {//风速控制
        switch (value) {
            case "0":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_FAN_LEVEL_AUTO.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_FAN_LEVEL_SLEEP.getPropertyCode(), value);
                break;
            case "2":
                deviceControl(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_FAN_LEVEL_CUSTOM.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2");
        }
    }

    public static void AirCleanerGetStatus(String value) {//查询状态
        switch (value) {
            case "0":
                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_MODE_AUTO.getPropertyCode());//0：查模式
                break;
            case "1":
                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_FAN_LEVEL_AUTO.getPropertyCode());//1：查风速
                break;
            case "2":
                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_POWER_ON.getPropertyCode());//2：查开关状态
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2");
        }
    }

    public static void AirCleanerSensor(String value) {//温湿度查询
        switch (value) {
            case "0":
//                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_TEMPERATURE.getPropertyCode());
                getQuery(kongqijinghua_deviceId, "battery");

                break;
            case "1":
                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_HUMIDITY.getPropertyCode());
                break;
            case "2":
                getQuery(kongqijinghua_deviceId, PropertyEnums.MIJIA_AIR_CLEANER_PM25.getPropertyCode());
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2");
        }
    }

    /**
     * 单独列出————————————————————空调
     */
    public static void AirConditionPower(String value) {
        switch (value) {
            case "0":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_POWER_ON.getPropertyCode(), value);
                break;
            case "1":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_POWER_OFF.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1");
        }
    }

    public static void AirConditionSetTemperature(String value) {//调温度
        deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_SET_TEMPERATURE.getPropertyCode(), value);
    }

    public static void AirConditionMode(String value) {//模式控制
        switch (value) {
            case "0":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_COOL.getPropertyCode(), value);//制冷
                break;
            case "1":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_DRY.getPropertyCode(), value);//干燥
                break;
            case "2":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_HEAT.getPropertyCode(), value);//制热
                break;
            case "3":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_WIND.getPropertyCode(), value);//送风
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2或者3");
        }
    }

    public static void AirConditionFanLevel(String value) {//风速控制
        switch (value) {
            case "0":
                getQuery(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_COOL.getPropertyCode());
                break;
            case "1":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_FAN_LEVEL_LOW.getPropertyCode(), value);
                break;
            case "2":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_FAN_LEVEL_MEDIUM.getPropertyCode(), value);
                break;
            case "3":
                deviceControl(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_FAN_LEVEL_HIGHT.getPropertyCode(), value);
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2或者3");
        }
    }

    public static void AirConditionGetStatus(String value) {//各状态查询
        switch (value) {
            case "0":
                getQuery(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_FAN_LEVEL_AUTO.getPropertyCode());
                break;
            case "1":
                getQuery(kongtiao_deviceId, PropertyEnums.MIJIA_AIR_CONDITIONER_MODE_DRY.getPropertyCode());
                break;
            default:
                System.out.println("参数错误，请输入0或者1或者2或者3");
        }
    }

    /**
     * 单独列出---查询设备事件
     */
    public static void EventQuery(String deviceId, String startTime, String endTime) throws ParseException {
        Map<String, Object> body = new HashMap<String, Object>(16);
        System.out.println("时间戳：" + dateToStamp(startTime));
        body.put("deviceId", deviceId);
        body.put("startTime", dateToStamp(startTime));
        body.put("endTime", dateToStamp(endTime));
        HttpUtils.send(EVENT_QUERY, "POST", null, body);

    }

    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 单独列出---按天查询使用时长
     */
    public static void UsedLength(String deviceId, String startTime, String endTime) {
        Map<String, Object> body = new HashMap<String, Object>(16);
        String arr[] = {deviceId};
        body.put("deviceId", Arrays.asList(arr));
        body.put("startTime", startTime);
        body.put("endTime", endTime);
        HttpUtils.send(USED_LENGTH, "POST", null, body);
    }

    /**
     * 单独列出---扫码绑定接口
     */
    public static void Scanbind(String controlUnitId, String data, String modelCode) {
        Map<String, Object> body = new HashMap<String, Object>(16);
        body.put("controlUnitId", controlUnitId);
        body.put("data", data);
        body.put("modelCode", modelCode);
        HttpUtils.send(SCAN_BIND, "POST", null, body);
    }
}

    /**
     * 单独列出——创建场景
     * keyName、type、trId、model、saId、scId、value通过SceneDemo.getSceneTemplateInfo()函数获取，
     * 以上参数分为actionList下的和launchList下的，注意填写
     */
    /*自动场景示例
        {
    "sceneName":"单击左键开灯开窗帘",
    "automatic":true,
    "action":[
        {
            "keyName":"开/关右键灯",
            "type":0,
            "deviceId":"1259807721394290690",
            "command":"lumi.switch.b2lacn02.toggle_ctrl_neutral",
            "trId":301,
            "model":"lumi.switch.b2lacn02",
            "saId":2884,
            "value":["neutral_1","toggle"]
        },{
            "keyName":"开/关",
            "type":0,
            "deviceId":"1259791615652806658",
            "command":"lumi.curtain.v1.toggle_device",
            "trId":301,
            "model":"lumi.curtain.v1",
            "saId":217,
            "value":"auto"
        }
    ],
    "express":0,
    "launch":[
        {
            "keyName":"双击右键",
            "deviceId":"1259789349554241537",
            "command":"event.lumi.remote.b286acn02.click_ch1",
            "trId":101,
            "enable":true,
            "model":"lumi.remote.b286acn02",
            "value":"",
            "scId":1542
        }
    ],
    "timeSpan":{
        "endMin":59,
        "beginHour":0,
        "beginMin":0,
        "endHour":23,
        "weekDay":[
            0,
            1,
            2,
            3,
            4,
            5,
            6
        ]
    }
}
    ********************************************/
    /*手动场景示例
  {
    "sceneName":"手动场景开关灯",
    "automatic":false,
    "action":[
        {
                "deviceId":"1259807721394290690",
                "command":"lumi.switch.b2nacn02.toggle_ctrl_neutral",
				"keyName":"开左键灯",
				"model":"lumi.switch.b2nacn02",
				"saId":2888,
				"trId":201,
				"type":0,
				"value":[
					"channel_0",
					"on"
				]
        },
        {
                "deviceId":"1259807721394290690",
				"command":"lumi.curtain.v1.toggle_device",
				"keyName":"开",
				"model":"lumi.curtain.v1",
				"saId":215,
				"trId":201,
				"type":0,
				"value":"open"
        }
    ],
    "express":0,
    "launch":[

    ],
    "timeSpan":{
        "endMin":59,
        "beginHour":0,
        "beginMin":0,
        "endHour":23,
        "weekDay":[
            0,
            1,
            2,
            3,
            4,
            5,
            6
        ]
    }
}
    * */

