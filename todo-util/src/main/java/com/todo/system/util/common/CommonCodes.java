package com.todo.system.util.common;

public class CommonCodes {

    /**
     * 数据库插入状态区分
     */
    public static  class InsertStatus{
        public static final int SUCCESS= 1;

        public static final int FAIL= 0;
    }

    /**
     * 数据启用停用区分
     */
    public  static class IsEnable{
        //启用
        public static final int ENABLE= 1;

        //停用
        public static final int DISCONTINUE= 2;
    }


    /**
     * 返回状态
     */
    public  static class ReturnStatus{
        //成功
        public static final String SUCCESS= "200";

        //失败
        public static final String ERROR= "500";

        //用户身份信息未完善
        public static final String PERFECT_NON = "201";

        //无数据
        public static final String NOT_FOUND= "404";

        //当前账户状态为非登陆状态
        public static final String TO_BE_ACCEPTED = "405";

        //编码重复
        public static final String CODE_REPEAT= "502";

        //名字重复
        public static final String NAME_REPEAT= "503";

        //用户无权限
        public static final String NO_AUTHORITY ="502";

        //微信登陆失败
        public static final String WECHAT_ERROR = "504";

        //注册手机号不规范（为空或位数不对）
        public static final String NON_STANDARD = "505";

        //短信验证码锁死十分种
        public static final String AWAIT = "506";

        //短信验证码验证超时
        public static final String MSG_OVERTIME = "507";

        //短信验证码错误
        public static final String MSG_ERROR = "508";

    }

    /**
     * api 返回的状态
     */
    public static class ApiResponseStatus {
        /**SUCCESS*/
        public static final String SUCCESS = "SUCCESS";

        /**FAIL*/
        public static final String FAIL = "FAIL";
    }


    /**
     * 用户注册渠道信息
     */
    public static class RegSource{
        //Erp注册渠道
        public static final Integer ERP = 1;
        //微信注册渠道
        public static final Integer WECHAT = 2;
    }


}
