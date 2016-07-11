package net.tfedu.zhl.cloud.utils.security;

import java.security.MessageDigest;
import java.util.Random;

import net.tfedu.zhl.cloud.utils.datatype.IdUtil;

public class MD5Util {

    /***
     * MD5加密 生成32位md5码
     * 
     * @param 待加密字符串
     * @return 返回32位md5码
     */
    public static String str2md5(String strSrc) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bt = md5.digest(strSrc.getBytes("UTF-8"));
            StringBuffer des = new StringBuffer(32);
            for (int i = 0; i < bt.length; i++) {
                String tmp = (Integer.toHexString(bt[i] & 0xFF));
                if (tmp.length() == 1) {
                    des.append("0");
                }
                des.append(tmp);
            }
            return des.toString();
        } catch (Exception e) {
            System.out.println("加密出错：" + e.toString());
            return "";
        }
    }

    public static void main(String[] args) {
        String password = str2md5("admin");
        System.out.println(password);
    }
}
