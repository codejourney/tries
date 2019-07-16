package com.example.WeixinMP;


import java.util.HashMap;
import java.util.Map;

public class reader {

    public static void main(String[] args) {
        reader rd = new reader();

        rd.weixinLoginUrl();

    }

    String openPlatformAppId = "";
    String openPlatformRedirect_uri = "";


    public Map<String, String> weixinLoginUrl() {
        String url = "https://open.weixin.qq.com/connect/qrconnect?appid=" + openPlatformAppId + "&redirect_uri="
                + ("'" + openPlatformRedirect_uri + "'/getWxLoginCode") + "&response_type=code" + "&scope=snsapi_login"
                + "&state=STATE#wechat_redirect";
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", url);
        map.put("getRedirect_uri", openPlatformRedirect_uri);    //openPlatformRedirect_uri为配置文件里的域名(开放平台配好的)
        return map;

    }
}
