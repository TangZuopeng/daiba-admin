package com.daiba.utils;

import java.security.MessageDigest;

/**
 * @author　 tinydolphin
 * @date　 2018-5-03  15:33
 * @description　 SHA 加密算法
 */
public class SHA {

    /**
     * @description 定义加密方式
     */
    private final static String SHA1 = "SHA-1";

    /**
     * SHA 加密
     * @param data 需要加密的字节数组
     * @return 加密之后的字节数组
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data);
        // 完成摘要计算并返回
        return sha.digest();
    }

    /**
     * SHA 加密
     * @param data 需要加密的字符串
     * @return 加密之后的字符串
     * @throws Exception
     */
    public static String encryptSHA(String data) throws Exception {
        // 验证传入的字符串
        if (data == null) {
            return "";
        }
        // 创建具有指定算法名称的信息摘要
        MessageDigest sha = MessageDigest.getInstance(SHA1);
        // 使用指定的字节数组对摘要进行最后更新
        sha.update(data.getBytes());
        // 完成摘要计算
        byte[] bytes = sha.digest();
        // 将得到的字节数组变成字符串返回
        return byteArrayToHexString(bytes);
    }

    /**
     * 转换字节数组为十六进制字符串
     * @param byteArray 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            sb.append(byteToHexString(byteArray[i]));
        }
        return sb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     * @param mByte 字节数
     * @return 字符串
     */
    private static String byteToHexString(byte mByte) {
        String mHex = Integer.toHexString(mByte & 0xFF);
        return (mHex.length() == 1) ? ("0" + mHex) : mHex ;
    }
}
