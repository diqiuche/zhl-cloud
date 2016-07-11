package net.tfedu.zhl.cloud.utils.datatype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayUtil {

    /**
     * 判断对象是否为空 对象可以为数组、集合、普通对象
     * 
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {
        if (value instanceof Collection<?>) {
            Collection<?> list = (Collection<?>) value;
            if (list == null || list.isEmpty() || list.size() == 0) {
                return true;
            }
        } else if (value instanceof Object[]) {
            Object[] list = (Object[]) value;
            if (list == null || list.length == 0) {
                return true;
            }
        } else if (value == null) {
            return true;
        }
        return false;
    }

    /** 并集 */
    public static List<String> merge(String[] a, String[] b) {
        List<String> strList = new ArrayList<String>();

        for (String s : a) {
            strList.add(s);
        }

        for (String s : b) {
            if (!strList.contains(s)) {
                strList.add(s);
            }
        }

        return strList;
    }

    /**
     * list转字符串 以,号隔开
     * 
     * @param strList
     * @return
     */
    public static String listToString(List<String> strList) {
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 数组转List
     * 
     * @param array
     *            可为空
     * @return
     */
    public static <T> List<T> arrayToList(T[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>(array.length);
        for (T s : array) {
            list.add(s);
        }
        return list;
    }

    /**
     * list转字符串数组
     * 
     * @param strList
     * @return
     */
    public static String[] listToStrings(List<String> strList) {
        String[] array = new String[strList.size()];
        return strList.toArray(array);
    }
}
