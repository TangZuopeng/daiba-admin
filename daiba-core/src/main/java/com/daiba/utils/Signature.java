package com.daiba.utils;

import java.util.*;

/**
 * @author　 tinydolphin
 * @date　 2018-5-15  16:37
 * @description　 签名算法
 *
 */
public class Signature {

    private final static String key = "Daiba520TangPuZhouZhangDaiComeon";

    //  对外接口
    public static String getSign(Map<String, String> mParams){
        ArrayList<Map.Entry<String, String>> params = new ArrayList<Map.Entry<String, String>>(mParams.entrySet());
        String stringA = sort(params);
        String sign = setSign(stringA);
        return sign;
    }

    //  参数排序
    private static String sort(ArrayList<Map.Entry<String, String>> mParams){
        Collections.sort(mParams, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                //  字典序升序
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        StringBuffer params = new StringBuffer();
        for (int i = 0; i < mParams.size(); i++) {
            params.append(mParams.get(i).getKey())
                    .append("=")
                    .append(mParams.get(i).getValue())
                    .append("&");
        }
        //  删除最后以一个&
        params.deleteCharAt(params.length() - 1);
        return params.toString();
    }

    //  API密匙拼接
    private static String setSign(String mParams){
        StringBuffer stringSignTemp = new StringBuffer();
        stringSignTemp.append(mParams)
                .append("&key=").append(key);
        return MD5.MD5Encode(stringSignTemp.toString()).toUpperCase();
    }

}
