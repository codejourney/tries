package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = CustomProperties.PREFIX)
public class CustomProperties {

    public static final String PREFIX = "custom";

    public static String getPREFIX() {
        return PREFIX;
    }

    private static String defaultSeparator = "/";
    private static String Lang = "zh_CN";

    public static String getLang() {
        return Lang;
    }

    public static void setLang(String lang) {
        Lang = lang;
    }
}