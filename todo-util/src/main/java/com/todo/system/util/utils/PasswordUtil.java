package com.todo.system.util.utils;

import org.springframework.util.DigestUtils;

public class PasswordUtil {

    // 加盐 文明
    private static final String SALT = "@#$SQSM";

    /**
     * 密码用md5加密
     * @param password
     * @return
     */
    public static String md5Encrypt(String password) {
        return DigestUtils.md5DigestAsHex((PasswordUtil.SALT + password).getBytes());
    }

}
