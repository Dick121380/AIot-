package com.kingsoft.aiot.demo;

import com.alibaba.fastjson.JSONObject;
import com.kingsoft.aiot.util.HttpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.kingsoft.aiot.constant.UrlConstant.*;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.demo.SkillDemo
 * @description  训练DEMO
 * @date 2020-04-21 14:52
 */
public class SkillDemo {

    /**
     * 创建训练
     */
    public static void skillAdd(){
        HashMap<String, Object> body = new HashMap<>();
        body.put("deviceId","1330767102494519297");    // 小爱音箱设备标识
        body.put("trigger", Arrays.asList("Kingsoft Cloud","金山云"));   //音箱触发语调
        JSONObject result = new JSONObject();
        result.put("type",0);       //训练类型, 0 语音回复,3 触发场景
        result.put("value","138MarketStreet,CapitaGreen");     //取值, type=0,小爱需要回复的语调,type = 3,取值为 "场景id: 场景名称"
        body.put("result",result);
        HttpUtils.send(SKILL_ADD,"POST",null,body);
    }

    /**
     * 获取训练计划
     */
    public static void skillGetList(){
        String deviceId = "1265992469468708865";
        String param = "deviceId="+deviceId;
        HttpUtils.send(SKILL_GET_LIST,"GET",param,null);
    }

    /**
     * 获取小爱音响技能列表
     */
    public static void skillGetSpeakerList(){
        String deviceId = "1265992469468708865";
        String param = "deviceId="+deviceId;
        HttpUtils.send(SKILL_GET_SPEAKER_LIST,"GET",param,null);
    }

    /**
     * 小爱定时播放语音
     */
    public static void skillTimePlay(String deviceId,String broadcastType, String cycleMin,String day,String hour,String min,String value){
      /*  { "broadcastType": 1,
                "cycleMin": 2,
                "day": "2020-05-09",
                "deviceId": 1328533083739004929,
                "hour": 10,
                "minute":42,
                "text": "天干物燥,小心火烛"}*/

        JSONObject result = new JSONObject();
        result.put("broadcastType",broadcastType);       //1:循环播放   0：单次播放
        result.put("cycleMin",cycleMin);     //循环执行的间隔,单位分钟,单次执行取值为 0, 最大间隔 43200 分钟
        result.put("day",day);       //单次精准播报的日期
        result.put("deviceId",deviceId);     //音箱deviceId
        result.put("hour",hour);     //播报的小时
        result.put("minute",min);       //播报的分钟
        result.put("text",value);     //播报内容
        HttpUtils.send(SKILL_TIME_PLAY,"POST",null,result);
    }

    /**
     * 获取定时播报列表
     */
    public static void GetBroadcstList(){
        String deviceId = "1265992469468708865";
        String param = "deviceId="+deviceId;
        HttpUtils.send(GET_SKILL_TIME_PLAY_LIST,"GET",param,null);
    }

    /**
     * 删除定时播报
     */
    public static void DelBroadcast(){
        String broadcastId = "1278514514585206785";
        String param = "broadcastId="+broadcastId;
        HttpUtils.send(DEL_SKILL_TIME_PLAY,"GET",param,null);
    }

    /**
     * 小爱删除训练
     */
    public static void skillDelete(){
        // 获取训练计划列表 取值
        String skillId = "636669";
        String deviceId = "1265992469468708865";
        String param = "skillId="+skillId+"&deviceId="+deviceId;
        HttpUtils.send(SKILL_DELETE,"GET",param,null);
    }

}
