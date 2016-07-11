package net.tfedu.zhl.cloud.utils.security;

/**
 * 加密算法 按位计算 异或 密钥：TFEDU1A2B3C4D5E6F7G8H9I 来自2.5系统
 * 
 * @author Administrator
 *
 */
public class PWDEncrypt {

    private static String secretKey = "TFEDU1A2B3C4D5E6F7G8H9I";

    /**
     * 获取字符串对应的ASCII码
     * 
     * @param str
     * @return
     */
    private static int[] getASCII(String str) {
        int[] temp = new int[str.length()];
        char[] char_temp = str.toCharArray();
        for (int i = 0; i < char_temp.length; i++) {
            temp[i] = (int) char_temp[i];
        }
        return temp;
    }

    /**
     * 根据ASCII码获取对应的字符
     * 
     * @return
     */
    private static String getStrFromASCII(int[] ia) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ia.length; i++) {
            sb.append((char) ia[i]);
        }
        return sb.toString();
    }

    /**
     * 简单密码加密算法
     * 
     * 取 密码的每个字符 及 密钥对应下标字符 的ASCII码 异或运算
     * 
     * 转成字符串
     * 
     * @param plaintext
     * @param secretKey
     * @return
     */
    public static String doEncrypt(String plaintext) {

        String key = PWDEncrypt.secretKey.substring(0, plaintext.length());
        int[] temp_i = new int[plaintext.length()];
        int temp_p[] = PWDEncrypt.getASCII(plaintext);
        int temp_k[] = PWDEncrypt.getASCII(key);
        for (int i = 0; i < plaintext.length(); i++) {
            temp_i[i] = temp_p[i] ^ temp_k[i];
        }
        return PWDEncrypt.getStrFromASCII(temp_i);
    }

    public static byte[] doEncryptByte(String plaintext) {
        String key = PWDEncrypt.secretKey.substring(0, plaintext.length());
        byte[] temp_p = plaintext.getBytes();
        byte[] temp_k = key.getBytes();
        byte[] temp_i = new byte[temp_p.length];
        for (int i = 0; i < temp_p.length; i++) {
            temp_i[i] = (byte) (temp_p[i] ^ temp_k[i]);
        }
        return temp_i;
    }

    public static String getPWD(byte[] b) {
        byte[] temp_k = PWDEncrypt.secretKey.substring(0, b.length).getBytes();
        byte[] pwd = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            pwd[i] = (byte) (b[i] ^ temp_k[i]);
        }
        return new String(pwd);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        System.out.println(PWDEncrypt.doEncrypt("123456"));
    }
}
