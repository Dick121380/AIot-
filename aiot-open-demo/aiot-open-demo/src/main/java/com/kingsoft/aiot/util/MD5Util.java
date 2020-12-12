package com.kingsoft.aiot.util;

import cn.hutool.core.lang.Console;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author KangZhiFeng
 * @className com.kingsoft.aiot.util.MD5Util
 * @description
 * @date 2020-04-13 14:30
 */
public class MD5Util {

    /**
     * md5 - 32位
     * @param sourceStr
     * @return
     * @throws Exception
     */
    public static String MD5(String sourceStr){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes(Charset.defaultCharset()));
            byte[] b = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            Console.log("md5 error, e:{}",e.getMessage());
        }
        return result;
    }
}
