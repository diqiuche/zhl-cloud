package net.tfedu.zhl.fileservice;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * xxtea.java Author: zhihaole.net Copyright: zhihaole.net Version: 1.0 LastModified: 2006-05-11 This library is free. You can redistribute it and/or modify it. http://www.zhihaole.net
 */

public class xxtea {

    public static String HexEncrypt(String data, String Key) {
        byte[] databyte = null;
        byte[] keybyte = null;
        byte[] encdata = null;
        try {
            databyte = data.getBytes("UTF-8");
            keybyte = Key.getBytes("UTF-8");
        }
        catch (Exception e) {
        }
        encdata = encrypt(databyte, keybyte);
        return bytesToHexString(encdata);
    }

    /**
     * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int) 来转换成16进制字符串。
     * 
     * @param src
     *            byte[] data
     * @return hex string
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    // 加密
    /*
     * public static String encryptstring(String data, String key) throws UnsupportedEncodingException { byte[] databyte = null; byte[] keybyte = null; byte[] encdata = null; databyte =
     * data.getBytes("UTF-8"); keybyte = key.getBytes("UTF-8");
     * 
     * encdata = encrypt(databyte, keybyte); return new String(encdata, "UTF-8"); }
     */
    public static String encryptstring(String data, String key) throws UnsupportedEncodingException {
        byte[] databyte = null;
        byte[] keybyte = null;
        byte[] encdata = null;
        databyte = data.getBytes("UTF-8");
        keybyte = key.getBytes("UTF-8");

        encdata = encrypt(databyte, keybyte);
        String enc_data = new String(Base64.encode(encdata).getBytes(), "UTf-8");

        return enc_data;
    }

    // 解密
    public static String decryptstring(String data, String key) throws IOException {
        byte[] databyte = null;
        byte[] keybyte = null;
        byte[] decdata = null;
        databyte = Base64.decode(data); // data.getBytes("UTF-8");
        keybyte = key.getBytes("UTF-8");

        decdata = decrypt(databyte, keybyte);
        return new String(decdata, "UTF-8");
    }

    /**
     * Encrypt data with key.
     * 
     * @param data
     * @param key
     * @return
     */
    public static byte[] encrypt(byte[] data, byte[] key) {
        if (data.length == 0) {
            return data;
        }

        return toByteArray(encrypt(toIntArray(data, true), toIntArray(key, false)), false);
    }

    /**
     * Decrypt data with key.
     * 
     * @param data
     * @param key
     * @return
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        if (data.length == 0) {
            return data;
        }
        return toByteArray(decrypt(toIntArray(data, false), toIntArray(key, false)), true);
    }

    /**
     * Encrypt data with key.
     * 
     * @param v
     * @param k
     * @return
     */
    public static int[] encrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];
            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int z = v[n], y = v[0], delta = 0x9E3779B9, sum = 0, e;
        int p, q = 6 + 52 / (n + 1);
        while (q-- > 0) {
            sum = sum + delta;
            e = sum >>> 2 & 3;
            for (p = 0; p < n; p++) {
                y = v[p + 1];
                z = v[p] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            }
            y = v[0];
            z = v[n] += (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
        }
        return v;
    }

    /**
     * Decrypt data with key.
     * 
     * @param v
     * @param k
     * @return
     */
    public static int[] decrypt(int[] v, int[] k) {
        int n = v.length - 1;
        if (n < 1) {
            return v;
        }
        if (k.length < 4) {
            int[] key = new int[4];
            System.arraycopy(k, 0, key, 0, k.length);
            k = key;
        }
        int z = v[n], y = v[0], delta = 0x9E3779B9, sum, e;
        int p, q = 6 + 52 / (n + 1);
        sum = q * delta;
        while (sum != 0) {
            e = sum >>> 2 & 3;
            for (p = n; p > 0; p--) {
                z = v[p - 1];
                y = v[p] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            }
            z = v[n];
            y = v[0] -= (z >>> 5 ^ y << 2) + (y >>> 3 ^ z << 4) ^ (sum ^ y) + (k[p & 3 ^ e] ^ z);
            sum = sum - delta;
        }

        return v;
    }

    /**
     * Convert byte array to int array.
     * 
     * @param data
     * @param includeLength
     * @return
     */
    private static int[] toIntArray(byte[] data, boolean includeLength) {
        int n = (((data.length & 3) == 0) ? (data.length >>> 2) : ((data.length >>> 2) + 1));
        int[] result;
        if (includeLength) {
            result = new int[n + 1];
            result[n] = data.length;
        }
        else {
            result = new int[n];
        }
        n = data.length;
        for (int i = 0; i < n; i++) {
            result[i >>> 2] |= (0x000000ff & data[i]) << ((i & 3) << 3);
        }

        return result;
    }

    /**
     * Convert int array to byte array.
     * 
     * @param data
     * @param includeLength
     * @return
     */
    private static byte[] toByteArray(int[] data, boolean includeLength) {
        int n;

        if (includeLength) {
            n = data[data.length - 1];
        }
        else {
            n = data.length << 2;
        }

        byte[] result = new byte[n >= 0 ? n : 0];

        for (int i = 0; i < n; i++) {
            result[i] = (byte) (data[i >>> 2] >>> ((i & 3) << 3));
        }

        result.toString();
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws MalformedURLException {
        String str = "NxdW5Ldd3uF+s68ZoB6h3xPxVK8R4kzw6GTyMYRuF1Sw7fvMcnZMJNcVY8gJ7/6pBsLBiVuhe2DjGO73MbM+oKsBYTJMiv5x";
        String strKey = "9k8i78jug6hd93kjf84h";
        try {
            System.out.println(xxtea.decryptstring(str, strKey));
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}