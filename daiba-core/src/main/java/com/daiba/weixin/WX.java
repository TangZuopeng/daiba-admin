package com.daiba.weixin;

import com.daiba.utils.HTTPRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author　 tinydolphin
 * @date　 2018-5-04  17:40
 * @description　 WX唯一实例
 */
public class WX {

    private WX(){ }
    private static WX instance = null;

    public static final String TOKEN = "WeiXinToken_daiba";

    public static final String serverUrl = "https://api.weixin.qq.com/cgi-bin/";
    public static final String GrantType = "client_credential";

    //测试号：wxceb6dfad8560c277
    //服务号：wxefafe5d086334c61
    public static final String AppID = "wxefafe5d086334c61";

    //测试号：32fdb38b8e7d75d05b1b98e2eaf5a9f7
    //服务号：fcad129265d90bdb3a6718d536ec000d
    public static final String AppSecret = "ec02758e859cbf8564b1d87271cf8e71";

    public static WX getInstance() {
        if (instance == null)
            instance = new WX();
        return instance;
    }

    public void initWX(){
        setAccess_token();
        setJsApiTicket();
    }

    private String access_token = null;

    public String getAccess_token() {
        while (access_token == null){
            System.out.println("waiting...");
        }
        return access_token;
    }

    private void setAccess_token() {
        new Thread(new Runnable() {
            public void run() {
                String url = serverUrl + "token";
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("grant_type", WX.GrantType);
                params.put("appid", WX.AppID);
                params.put("secret", WX.AppSecret);
                updateAccess_token(url, params);
            }
        }).start();
    }
    private String ticket = null;
    public String getJsApiTicket(){
        return ticket;
    }
    private void setJsApiTicket(){
        new Thread(new Runnable() {
            public void run() {
                HashMap<String, String> params = new HashMap<>();
                params.put("access_token", getAccess_token());
                params.put("type", "jsapi");
                String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
                updateJsApi(url, params);
            }
        }).start();
    }

    private void updateJsApi(final String url, final HashMap<String, String> params){
        try {
            JSONObject jsonObject = new JSONObject(HTTPRequest.ajax(url, params, HTTPRequest.GET));
            ticket = jsonObject.getString("ticket");
            int timelimit = jsonObject.getInt("expires_in");
            Thread.sleep((timelimit-60) * 1000);
            updateJsApi(url, params);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //  获取access_token
    private void updateAccess_token(final String url, final HashMap<String, String> params) {
        try {
            JSONObject jsonObject = new JSONObject(HTTPRequest.ajax(url, params, HTTPRequest.GET));
            access_token = jsonObject.getString("access_token");
            int timelimit = jsonObject.getInt("expires_in");
            Thread.sleep((timelimit-60) * 1000);
            updateAccess_token(url, params);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}