package com.daiba.utils;

import java.util.Random;

/**
 * @author　 tinydolphin
 * @date　 2018-5-17  12:13
 * @description　 随机字符串
 */
public class RandomString {

    //  字典
    private static final String map =
            "abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "0123456789";

    private static final int maxRandom = map.length();

    public static String getRandomString(int length) { //length表示生成字符串的长度
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int number = random.nextInt(maxRandom);
            sb.append(map.charAt(number));
        }
        return sb.toString();
    }

}
