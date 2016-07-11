package net.tfedu.zhl.cloud.utils.datatype;

import java.util.UUID;

public class IdUtil {

    private IdUtil() {

    }

    /**
     * 获取32位uuid字符串
     * 
     * @return
     */
    public static String getUUID() {
        // 创建 GUID 对象
        UUID uuid = UUID.randomUUID();
        // 得到对象产生的ID
        String a = uuid.toString();
        // 转换为大写
        return a.toUpperCase().replaceAll("-", "");
    }
}
