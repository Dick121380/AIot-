package com.kingsoft.aiot.demo;

import java.util.List;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.demo.MainApi
 * @description
 * @date 2020-04-21 14:54
 */
public class MainApi {

    public static void main(String[] args) throws Exception {
//         获取用户下设备列表
          DeviceDemo.deviceParentNodePage();

/******************** 以下为单个设备的控制 ***************************/
          //EveryControl.WirelessSwitch("2");
//        EveryControl.Curtain("2");//窗帘    0：暂停    1：打开    2：关闭
//        EveryControl.SpeakerMute("1");//小爱音箱静音   0:静音    1：取消静音
//        EveryControl.SpeakerVolume("55");//小爱音箱调音量   传入音量值(步长为5)
//        EveryControl.SpeakerPlayStatus();//小爱音箱播放状态
//        EveryControl.Socket("1");//1智能插座  1:电源开   0：电源关
        //System.out.println(EveryControl.GetSensorValue("2"));//温湿度传感器  0：查温度     1：查湿度    2：查气压值
//        EveryControl.LHSwitch("1");//零火双键开关   0：左键开   1：左键关   2：右键开    3：右键关
//        EveryControl.DHSw01itch("0");//单火单键开关    0：关闭   1：开
//        EveryControl.DHDualSwitch("3");//单火双键  0：左键开   1：左键关   2：右键开   3：右键关
/********************   空气净化器  ***************************/
//        EveryControl.AirCleanerPower("0");//空净电源  0：关闭电源   1:打开电源
//        EveryControl.AirCleanerMode("1");//空净模式  0：自动   1：睡眠   2：自定义
//        EveryControl.AirCleanerFanLevel("0");//空净风速  0：自动   1：睡眠   2：自定义//
//        EveryControl.AirCleanerSensor("0");//空净温湿度查询   0:查温度   1：查湿度   2：查PM2.5
//        EveryControl.AirCleanerGetStatus("0");//空气净化器   0：查模式   1：查风速    2：查电源状态
/********************   空调  ***************************/
//        EveryControl.AirConditionPower("1");//空调  0：关    1：开
//        EveryControl.AirConditionSetTemperature("26");//空调调温度  参数：需要的温度
//        EveryControl.AirConditionMode("0");//空调设置模式   0：制冷  1：干燥   2：制热   3：送风
//        EveryControl.AirConditionFanLevel("1");//空调风速控制   0：自动 1：低风   2：中风   3：高风
//        EveryControl.AirConditionGetStatus("0");//0:查风速  1：查模式
/********************   台灯  ***************************/
//        EveryControl.LampPower("1");//台灯  0：关    1：开
//        EveryControl.Brightness("10");//亮度调节
//        EveryControl.BrightMode("1");//模式   0：阅读  1：用电脑
//        EveryControl.Color_temperature("5000");//色温调节   输入色温值
/********************   青萍传感器  ***************************/
//        EveryControl.GetQPSensor("0");//青萍传感器查询： 0：co2    1:湿度   2：温度   3：PM2.5    4：VOC   5：充电状态   6：电量   7:查询所有值
/********************   场景  ***************************/
//        SceneDemo.getSceneTemplateInfo();
//        EveryControl.CreateSceneDemo();
//        SceneDemo.getDeviceScene();
/********************   小爱训练  *************************/
//        EveryControl.SpeakerTimePlay("2020-07-02","10","05","12月24日，学院学生会将在软件楼举办圣诞晚会，欢迎大家踊跃报名参加活动，报名联系校学生会或各班班主任");
//        EveryControl.SpeakerSkillAddAudio("今天什么课","语文课");
//        EveryControl.SpeakerSkillAddScene("我起床了");

/*******************通用接口*************************/
        // 获取设备信息
//      DeviceDemo.deviceInfo();

//         获取物模型属性
//        DeviceDemo.metaTypeProductModel();

         //设备重命名
         //DeviceDemo.deviceUpdateName("Aqara无线开关D1(贴墙式双键版)",EveryControl.wuxian_switch_deviceId);
//
        // 获取指定设备的属性数据
//        DeviceDemo.deviceQueryPropertyList();
//
        // 设备控制
        DeviceDemo.deviceUpdateProperty();

        // 获取产品列表
//        DeviceDemo.metaTypeProductList();

        // 设备解绑
//        DeviceDemo.deviceUnbind();

        // 创建训练
//        SkillDemo.skillAdd();

        // 获取训练计划
//       SkillDemo.skillGetList();

        // 获取小爱音响技能
//        SkillDemo.skillGetSpeakerList();

        // 删除训练计划
//        SkillDemo.skillDelete();

        // 创建场景
//        SceneDemo.createScene();

        // 根据deviceId获取该设备支持的场景模板
//        SceneDemo.getSceneTemplateInfo();

        //根据deviceID获取该设备已创建的场景
//        SceneDemo.getDeviceScene();

        //根据deviceId获取音箱已创建的广播列表
//        EveryControl.SpeakerTimePlayList();

        //删除小爱音箱播报
//        EveryControl.DelSpeakerTimePlay();
        // 获取场景信息
//        SceneDemo.getSceneInfo();

        // 执行场景
//        SceneDemo.startScene();

        //删除场景
//        SceneDemo.DeleteScene();

        //创建controldID
//        EveryControl.CreateControldId("光明他家");

        //查询事件
//        EveryControl.EventQuery("1286284620748963841","2020-07-24 14:42:00","2020-08-28 14:45:00");

        //查询使用时长
//        EveryControl.UsedLength("1283694337409236994","20200723","20200828");

        //扫码绑定接口
//        EveryControl.Scanbind("1353528097","https://c3.account.xiaomi.com/longPolling/login?ticket=D023ec8394de-4114-4364-9ec5-e355c5a0cdbb&dc=c3","xiaomi.wifispeaker.lx04");

    }
}
