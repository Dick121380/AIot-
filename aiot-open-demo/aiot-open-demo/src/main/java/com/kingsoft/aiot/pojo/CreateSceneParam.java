package com.kingsoft.aiot.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wuguanglu
 * @className CreateSceneParam
 * @description
 * @date 2020/1/14 2:24 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSceneParam {

//    @ApiModelProperty("是否为自动化场景")
    private Boolean automatic;

//    @ApiModelProperty("场景名称")
    private String sceneName;

//    @ApiModelProperty("场景内需要执行的动作")
    private List<Action> action;

//    @ApiModelProperty("场景触发的条件")
    private List<Launch> launch;

//    @ApiModelProperty("场景触发的条件的关系,0 全部满足,1 任意条件满足")
    private String express;

//    @ApiModelProperty(value = "执行时间段",required = true)
    private TimeSpan timeSpan;


    @Builder
    @Data
    public static class Action{

//        @ApiModelProperty("控制名称,场景模板获取")
        private String keyName;

//        @ApiModelProperty("设备模型编码")
        private String model;

//        @ApiModelProperty("设备操作取值")
        private String value;

//        @ApiModelProperty("执行动作指令")
        private String command;

//        @ApiModelProperty("设备标识")
        private Long deviceId;

//        @ApiModelProperty("场景模板接口获取")
        private Integer saId;

//        @ApiModelProperty("场景模板接口获取")
        private Integer trId;

    }

    @Builder
    @Data
    public static class Launch{

//        @ApiModelProperty("自动化条件取值")
        private String value;

//        @ApiModelProperty("设备标识")
        private Long deviceId;

//        @ApiModelProperty("场景模板接口获取")
        private Integer trId;

//        @ApiModelProperty("场景模板接口获取")
        private Integer scId;

//        @ApiModelProperty("场景触发的指令,场景模板接口获取")
        private String command;
    }

    @Builder
    @Data
    public static class TimeSpan{

//        @ApiModelProperty(value = "开始小时")
        private Integer beginHour;

//        @ApiModelProperty(value = "开始分钟")
        private Integer beginMin;

//        @ApiModelProperty(value = "结束小时")
        private Integer endHour;

//        @ApiModelProperty(value = "结束时间")
        private Integer endMin;

//        @ApiModelProperty(value = "0-6,周单位,天的区间",required = true)
        private List<Integer> weekDay;

    }
}
