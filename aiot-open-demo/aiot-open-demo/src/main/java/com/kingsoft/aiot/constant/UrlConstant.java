package com.kingsoft.aiot.constant;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.constant.UrlConstant
 * @description
 * @date 2020-04-13 14:11
 */
public class UrlConstant {

    /**
     * 配置开发者账号和控制单元ID
     */
    public static final String appKey = "xnYcUJtC";
    public static final String appSecret = "ade491bedb576c1517bd8aa1096075b4";//appSecret
    public static final String path = "https://aiot-open.ksyun.com";//请求URL
    public static final String account = "1353583407";//改为每个展箱子上贴的controlID

//    public static final String appKey = "RtdEgT2W";
//    public static final String appSecret = "D0C794B915DCE515146960FF8705AA97";//appSecret
//    public static final String path = "http://aiot-open-test.ksyun.com";//请求URL
//    public static final String account = "1353519521";//改为每个展箱子上贴的controlID



    /**
     * 设备重命名
     */
    public static final String DEVICE_UPDATE_NAME = "/public/api/device/update/device/name";

    /**
     * 获取设备信息
     */
    public static final String DEVICE_INFO = "/public/api/device/info";

    /**
     * 获取多键开关的信息
     */
    public static final String DEVICE_MULTI_BUTTON_INFO = "/public/api/device/multi/button/info";

    /**
     * 获取多键开关的信息
     */
    public static final String DEVICE_MULTI_BUTTON_RENAME = "/public/api/device/multi/button/rename";

    /**
     * 设备解绑
     */
    public static final String DEVICE_UNBIND = "/public/api/device/unbind";

    /**
     * 修改设备属性
     */
    public static final String DEVICE_UPDATE_PROPERTY = "/public/api/device/update/property";

    /**
     * 获取用户下设备列表
     */
    public static final String DEVICE_PARENT_NODE_PAGE = "/public/api/device/parentNode/page";

    /**
     * 获取物模型属性
     */
    public static final String META_TYPE_PRODUCT_MODEL = "/public/api/meta/type/product/model";

    /**
     * 获取产品列表
     */
    public static final String META_TYPE_PRODUCT_LIST = "/public/api/meta/type/product/list";

    /**
     * 获取指定设备的属性数据
     */
    public static final String DEVICE_QUERY_PROPERTY_LIST = "/public/api/device/query/property/list";

    // ******************   训练  ****************
    /**
     * 创建训练
     */
    public static final String SKILL_ADD = "/public/api/skill/add";

    /**
     * 获取训练计划
     */
    public static final String SKILL_GET_LIST = "/public/api/skill/get/skill/list";

    /**
     * 删除训练计划
     */
    public static final String SKILL_DELETE = "/public/api/skill/delete/skill";

    /**
     * 获取小爱音响技能
     */
    public static final String SKILL_GET_SPEAKER_LIST = "/public/api/skill/get/speaker/skill/list";

    /**
     * 定时播报
     */
    public static final String SKILL_TIME_PLAY = "/public/api/skill/broadcast/add";

    /**
     * 获取定时播报列表
     */
    public static final String GET_SKILL_TIME_PLAY_LIST = "/public/api/skill/broadcast/list";

    /**
     * 删除定时播报
     */
    public static final String DEL_SKILL_TIME_PLAY = "/public/api/skill/broadcast/remove";


    // *****************    场景    *****************

    /**
     * 创建场景
     */
    public static final String SCENE_CREATE = "/public/api/scene/creat/scene";


    /**
     * 获取设备支持的场景模板
     */
    public static final String SCENE_GET_TEMPLATE_INFO = "/public/api/scene/get/scene/template/info";


    /**
     * 获取场景信息
     */
    public static final String SCENE_GET_INFO = "/public/api/scene/get/sceneInfo";


    /**
     * 通过设备id获取已建立的场景列表
     */
    public static final String SCENE_LIST_DEVICE = "/public/api/scene/device/sceneList";


    /**
     * 执行场景
     */
    public static final String SCENE_START = "/public/api/scene/start/scene";


    /**
     *删除场景
     */
    public static final String SCENE_DELETE = "/public/api/scene/delete/scene";

    /**
     *创建空间
     */
    public static final String CREATE_CONTROLID = "/public/api/third/platform/getControlUnitId";

    /**
     *查询事件
     */
    public static final String EVENT_QUERY = "/public/api/log/device/operation";

    /**
     *按天查询使用时长
     */
    public static final String USED_LENGTH = "/public/aiot-stat/device/online/duration";

    /**
     *扫码绑定接口
     */
    public static final String SCAN_BIND = "/public/api/device/scanCode/bind";

}
