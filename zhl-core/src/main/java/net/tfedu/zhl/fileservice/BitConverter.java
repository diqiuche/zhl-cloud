package net.tfedu.zhl.fileservice;

/**
 * 各类型数据与Byte数组转换 Build time: 2013/1/6
 * 
 * @author Boat
 */
public class BitConverter {
    public static byte[] GetBytes(int Value) {
        byte[] result = new byte[4];

        for (int i = 0; i < 4; i++) {
            result[i] = (byte) (Value >> (8 * i) & 0xFF);
        }

        return result;
    }

    public static byte[] GetBytes(long Value) {
        byte[] result = new byte[8];

        for (int i = 0; i < 8; i++) {
            result[i] = (byte) (Value >> (8 * i) & 0xFF);
        }

        return result;
    }

    public static byte[] GetBytes(double Value) {
        return GetBytes(Double.doubleToLongBits(Value));
    }

    public static long ToInt64(byte[] from, int offset) {
        long iOutcome = 0;
        long bLoop;

        for (int i = offset; i < offset + 8; i++) {
            bLoop = from[i] & 0xFF;
            iOutcome += bLoop << (8 * (i - offset));
        }

        return iOutcome;
    }

    public static int ToInt32(byte[] from, int offset) {
        int iOutcome = 0;
        byte bLoop;

        for (int i = offset; i < offset + 4; i++) {
            bLoop = from[i];
            iOutcome += (bLoop & 0xFF) << (8 * (i - offset));
        }

        return iOutcome;
    }

    public static short ToInt16(byte[] from, int offset) {
        short iOutcome = 0;
        byte bLoop;

        for (int i = offset; i < offset + 2; i++) {
            bLoop = from[i];
            iOutcome += (bLoop & 0xFF) << (8 * (i - offset));
        }

        return iOutcome;
    }

    public static double ToDouble(byte[] from, int offset) {
        long accum = 0;
        int i = offset;
        for (int shiftBy = 0; shiftBy < 64; shiftBy += 8) {
            accum |= ((long) (from[i] & 0xff)) << shiftBy;
            i++;
        }
        return Double.longBitsToDouble(accum);
    }

    public static float ToFloat(byte[] from, int offset) {

        long accum = 0;
        int i = offset;
        for (int shiftBy = 0; shiftBy < 32; shiftBy += 8) {
            accum |= ((long) (from[i] & 0xff)) << shiftBy;
            i++;
        }
        return (float) Double.longBitsToDouble(accum);
    }

    public static String ToHexString(byte b[]) {
        return ToHexString(b, 0, b.length);
    }

    public static String ToHexString(byte b[], int offset, int length) {
        StringBuffer hexString = new StringBuffer();
        for (int i = offset; i < offset + length; i++) {
            String plainText = Integer.toHexString(0xff & b[i]);
            if (plainText.length() < 2)
                plainText = "0" + plainText;
            hexString.append(plainText);
        }

        return hexString.toString();
    }

    public static byte[] FromHexString(String from) {
        byte digest[] = new byte[from.length() / 2];
        for (int i = 0; i < digest.length; i++) {
            String byteString = from.substring(2 * i, 2 * i + 2);
            int byteValue = Integer.parseInt(byteString, 16);
            digest[i] = (byte) byteValue;
        }

        return digest;
    }
}