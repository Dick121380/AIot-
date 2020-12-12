package com.kingsoft.aiot.enums;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.enums.PropertyEnums
 * @description
 * @date 2020-04-14 12:41
 * function：所用设备控制以及查询状态封装，在DeviceDemo控制中直接使用封装好的参数更方便
 */
public enum PropertyEnums {

    /**
     *  "code": "lumi.curtain.v1"
     *  "name": "Aqara智能窗帘电机（Zigbee开合帘版）"
     *  电机操作
     */
    LUMI_CURTAIN_MOTOR_CONTROL_PAUSE("lumi.curtain.v1","motor_control","0"),//暂停
    LUMI_CURTAIN_MOTOR_CONTROL_OPEN("lumi.curtain.v1","motor_control","1"),//打开
    LUMI_CURTAIN_MOTOR_CONTROL_CLOSE("lumi.curtain.v1","motor_control","2"),//关闭

    /**
     * 小米小爱触屏音箱 音量  propertyValue为音量值
     */
    XIAOMI_WIFISPEAKER_VOLUME("xiaomi.wifispeaker.lx04","volume","50"),//调节音量大小
    //小米小爱触屏音箱 麦克风开关：
    XIAOMI_WIFISPEAKER_MICROPHONE_MUTE_OPEN("xiaomi.wifispeaker.lx04","microphone_mute","1"),//静音开
    XIAOMI_WIFISPEAKER_MICROPHONE_MUTE_CLOSE("xiaomi.wifispeaker.lx04","microphone_mute","0"),//静音关
    //小米小爱触屏音箱 播放状态
    R_XIAOMI_WIFISPEAKER_PLAYING_STATE("xiaomi.wifispeaker.lx04","playing_state","1"),//播放

    /**
     * "code": "lumi.ctrl_86plug.aq1",
     * "name": "Aqara智能墙壁插座(zigbee版)",
     * 开关
     */
    LUMI_CTRL_86PLUG_POWER_OPEN("lumi.ctrl_86plug.aq1","power","1"),//电源开
    LUMI_CTRL_86PLUG_POWER_CLOSE("lumi.ctrl_86plug.aq1","power","0"),//电源关

    /**
     * Aqara无线开关D1(贴墙式双键版)
     */
    LUMI_SWITCH_B286ACN02_RIGHT_OPEN("lumi.remote.b286acn02","right_switch","1"),//右键开
    LUMI_SWITCH_B286ACN02_RIGHT_CLOSE("lumi.remote.b286acn02","right_switch","0"),//右键关
    LUMI_SWITCH_B286ACN02_LEFT_OPEN("lumi.remote.b286acn02","left_switch","1"),//左键开
    LUMI_SWITCH_B286ACN02_LEFT_CLOSE("lumi.remote.b286acn02","left_switch","0"),//左键关



    /**
     * Aqara智能墙壁开关 D1（零火线双键版）
     */
    LUMI_SWITCH_B2NACN02_RIGHT_OPEN("lumi.switch.b2nacn02","right_switch","1"),//右键开
    LUMI_SWITCH_B2NACN02_RIGHT_CLOSE("lumi.switch.b2nacn02","right_switch","0"),//右键关
    LUMI_SWITCH_B2NACN02_LEFT_OPEN("lumi.switch.b2nacn02","left_switch","1"),//左键开
    LUMI_SWITCH_B2NACN02_LEFT_CLOSE("lumi.switch.b2nacn02","left_switch","0"),//左键关


    /**
     * Aqara智能墙壁开关 D1（单火线单键版）
     */

    LUMI_SWITCH_B1LACN02_OPEN("lumi.switch.b1lacn02","switch","1"),//开
    LUMI_SWITCH_B1LACN02_CLOSE("lumi.switch.b1lacn02","switch","0"),//关


    /**
     * Aqara智能墙壁开关 D1（单火线双键版）
     */

    LUMI_SWITCH_DANHUO_LEFT_OPEN("lumi.switch.b2lacn02","left_switch","1"),//开
    LUMI_SWITCH_DANHUO_LEFT_CLOSE("lumi.switch.b2lacn02","left_switch","0"),//关
    LUMI_SWITCH_DANHUO_RIGHT_OPEN("lumi.switch.b2lacn02","right_switch","1"),//开
    LUMI_SWITCH_DANHUO_RIGHT_CLOSE("lumi.switch.b2lacn02","right_switch","0"),//关

    /**
     *绿米水浸传感器
     * */

//    LUMI_SHUIJIN_CHUANGANQI1("lumi.sensor_wleak.aq1","temperature",null),//温度传感器，查询温度时用
//    LUMI_SHUIJIN_CHUANGANQI2("lumi.sensor_wleak.aq1","humidity",null),//湿度传感器，查询湿度时用
//    LUMI_SHUIJIN_CHUANGANQI3("lumi.sensor_wleak.aq1","pressure",null),//压力传感器，查询大气压时用


    /**
     *绿米温湿度传感器
     * */

    LUMI_WEATHER_TEMPERATURE("lumi.weather.v1","temperature",null),//温度传感器，查询温度时用
    LUMI_WEATHER_HUMIDITY("lumi.weather.v1","humidity",null),//湿度传感器，查询湿度时用
    LUMI_WEATHER_PRESSURE("lumi.weather.v1","pressure",null),//压力传感器，查询大气压时用


    /**
     * 米家空气净化器PRO/F 1
     */
    MIJIA_AIR_CLEANER_POWER_ON("dmaker.airpurifier.f20","power","1"),//电源开
    MIJIA_AIR_CLEANER_POWER_OFF("dmaker.airpurifier.f20","power","0"),//电源关
    MIJIA_AIR_CLEANER_MODE_AUTO("dmaker.airpurifier.f20","mode","0"),//自动模式
    MIJIA_AIR_CLEANER_MODE_SLEEP("dmaker.airpurifier.f20","mode","1"),//睡眠模式
    MIJIA_AIR_CLEANER_MODE_CUSTOM("dmaker.airpurifier.f20","mode","2"),//自定义模式
    MIJIA_AIR_CLEANER_FAN_LEVEL_AUTO("dmaker.airpurifier.f20","fan_level","0"),//风速自动
    MIJIA_AIR_CLEANER_FAN_LEVEL_SLEEP("dmaker.airpurifier.f20","fan_level","1"),//风速睡眠
    MIJIA_AIR_CLEANER_FAN_LEVEL_CUSTOM("dmaker.airpurifier.f20","fan_level","2"),//风速自定义
    MIJIA_AIR_CLEANER_TEMPERATURE("dmaker.airpurifier.f20","indoor_temperature",null),//温度
    MIJIA_AIR_CLEANER_HUMIDITY("dmaker.airpurifier.f20","humidity",null),//湿度
    MIJIA_AIR_CLEANER_PM25("dmaker.airpurifier.f20","pm2.5",null),//PM2.5
    MIJIA_AIR_CLEANER_CONTROL_LOCK_OPEN("dmaker.airpurifier.f20","physical_control_locked","1"),//控制锁开
    MIJIA_AIR_CLEANER_CONTROL_LOCK_CLOSE("dmaker.airpurifier.f20","physical_control_locked","0"),//控制锁关

    MIJIA_AIR_CLEANER_INDICATOR_LIGHT_OPEN("dmaker.airpurifier.f20","light_switch","1"),//指示灯开
    MIJIA_AIR_CLEANER_INDICATOR_LIGHT_CLOSE("zdmaker.airpurifier.f20","light_switch","0"),//指示灯关
    MIJIA_AIR_CLEANER_F1("dmaker.airpurifier.f20","temperature","1"),


    /**
     * 青萍传感器
     */
    QINGPING_HUMIDITY("cgllc.airmonitor.s1","humidity","1"),
    QINGPING_PM25("cgllc.airmonitor.s1","pm2.5","1"),
    QINGPING_TEMPERATURE("cgllc.airmonitor.s1","temperature","1"),
    QINGPING_CO2("cgllc.airmonitor.s1","co2","1"),
    QINGPING_TVOC("cgllc.airmonitor.s1","tvoc","1"),
    QINGPING_BATTERY("cgllc.airmonitor.s1","battery","1"),
    QINGPING_CHARGING_STATE("cgllc.airmonitor.s1","charging_state","1"),

    /**
     * 米家台灯1S
     */
    TAIDENG_POWER_OPEN("yeelink.light.lamp4","power","1"),//台灯开
    TAIDENG_POWER_CLOSE("yeelink.light.lamp4","power","0"),//台灯关
    TAIDENG_BRIGHTNESS("yeelink.light.lamp4","brightness","0"),//亮度
    TAIDENG_MODE_READ("yeelink.light.lamp4","mode","0"),//阅读
    TAIDENG_MODE_PC("yeelink.light.lamp4","mode","1"),//电脑
    TAIDENG_MODE_COLOR_TEMPERATURE("yeelink.light.lamp4","color_temperature","1"),//色温



    /**
     * 智米全直流变频空调  型号：KFR-35GW/02ZM(M1)
     */
    MIJIA_AIR_CONDITIONER_POWER_ON("zhimi.aircondition.v1","power","0"),//电源开
    MIJIA_AIR_CONDITIONER_POWER_OFF("zhimi.aircondition.v1","power","1"),//电源关
    MIJIA_AIR_CONDITIONER_MODE_COOL("zhimi.aircondition.v1","mode","0"),//制冷
    MIJIA_AIR_CONDITIONER_MODE_DRY("zhimi.aircondition.v1","mode","1"),//干燥
    MIJIA_AIR_CONDITIONER_MODE_HEAT("zhimi.aircondition.v1","mode","2"),//制热
    MIJIA_AIR_CONDITIONER_MODE_WIND("zhimi.aircondition.v1","mode","3"),//送风
    MIJIA_AIR_CONDITIONER_SET_TEMPERATURE("zhimi.aircondition.v1","target_temperature",null),//设定温度
    MIJIA_AIR_CONDITIONER_FAN_LEVEL_AUTO("zhimi.aircondition.v1","fan_level","0"),//风速自动
    MIJIA_AIR_CONDITIONER_FAN_LEVEL_LOW("zhimi.aircondition.v1","fan_level","1"),//风速低
    MIJIA_AIR_CONDITIONER_FAN_LEVEL_MEDIUM("zhimi.aircondition.v1","fan_level","2"),//风速中
    MIJIA_AIR_CONDITIONER_FAN_LEVEL_HIGHT("zhimi.aircondition.v1","fan_level","3"),//风速高





    ;


    private String productCode;
    private String propertyCode;
    private String propertyValue;


    PropertyEnums(String productCode, String propertyCode, String propertyValue) {
        this.productCode = productCode;
        this.propertyCode = propertyCode;
        this.propertyValue = propertyValue;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public String getPropertyValue() {
        return propertyValue;
    }
}
