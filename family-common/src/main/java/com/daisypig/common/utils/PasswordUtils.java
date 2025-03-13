package com.daisypig.common.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verify(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}