package com.todo.system.util.web;

public class UrlRegulation {

    public class RequestPrefix {

        /** 请求需登录的前缀 */
        public static final String REQ_LOGIN = "/l";

        /** 请求无需登录的前缀 */
        public static final String REQ_NO_LOGIN = "/n";
    }


    public  class BizPrefix{

        /** 用户登录前缀 */
        public static final String LOGIN = "/log";

        /** 用户前缀*/
        public static final String USER ="/user";

        /**管理员登录前缀 */
        public static final String ADMINLOGIN = "/alog";

        /** admin */
        public static final String ADMIN = "/admin";

    }

}
