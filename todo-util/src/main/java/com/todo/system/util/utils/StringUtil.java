package com.todo.system.util.utils;

public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        if ("".equals(str)) {
            return true;
        }
        return false;
    }

    public static String dateAddPart(String strdate, boolean addDay) {
        if (strdate.contains(" ")) {
            strdate = strdate.split(" ")[0];
        }

        if (addDay) {
            return strdate + " 23:59:59.999";
        } else {
            return strdate + " 00:00:00";
        }

    }

    public static String dateAddPart(String strdate, String timePart) {
        if (strdate.contains(" ")) {
            strdate = strdate.split(" ")[0];
        }
        if (timePart != null) {
            return strdate + " " + timePart;
        } else {
            return strdate + " 00:00:00";
        }
    }

}
