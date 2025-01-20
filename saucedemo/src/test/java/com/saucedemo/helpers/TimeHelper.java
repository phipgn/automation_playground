package com.saucedemo.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeHelper {
    public static String getCurrentDateTime() {
        var now = LocalDateTime.now();
        var formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
