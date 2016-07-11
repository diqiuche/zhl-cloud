package net.tfedu.zhl.fileservice;

/**
 * 资源辅导工具类
 * 
 * @author Administrator
 *
 *
 *
 *
 */
public class ResFdUtil {

    // 访问用户 个性化辅导平台的概念
    private static String customerID = "1001978562891";
    private static String customerKey = "F94KG8EU54JG8FKE8";
    // 在线flash路径(URL)加密方案密钥
    public static String secretKey_online = "www.zhihaole.net";

    /**
     * 获取加密文件下载的URL参数字符串
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param PlayerType
     *            视频播放类型，1:Lexue插件播放 2:Flash播放器播放 3:Video标签嵌入视频
     * @param IsMultiFile
     *            指定资源是否多文件
     * @param MainFile
     *            IsMultiFile为True时，指定多文件的主文件，为False时此参数忽略
     * @param serverURL
     *            辅导资源服务器url（路径前缀）
     * 
     * @author wangwr
     */
    public static String getFinalURL(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile, String serverURL) {

        String filePath = "";
        zhldowncenter down = new zhldowncenter(customerID, customerKey, serverURL);

        filePath = down.GetEncryptDownloadURLString("EncryptMaterial\\" + FileName, PlayerType, IsMultiFile, MainFile);
        return filePath;
    }

    public static String getEncryptURL(String FileName, String serverURL) {
        // .tfmp4 .tfswf
        String filePath = "";
        zhldowncenter down = new zhldowncenter(customerID, customerKey, serverURL);
        filePath = down.GetProtectDownloadURLString("EncryptMaterial\\" + FileName);
        return filePath;
    }

    /**
     * 获取免费文件下载的URL参数字符串，比如缩略图文件
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param IsDown
     *            是否以附件的形式下载文件
     * @author BoatZhang
     */
    public static String GetFreeDownloadURLString(String FileName, String serverURL) {
        zhldowncenter down = new zhldowncenter(customerID, customerKey, serverURL);
        return down.GetFreeDownloadURLString("EncryptMaterial\\" + FileName, true);
    }

    /**
     * flash在线播放路径的加密字段
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param PlayerType
     *            视频播放类型，1:Lexue插件播放 2:Flash播放器播放 3:Video标签嵌入视频
     * @param IsMultiFile
     *            指定资源是否多文件
     * @param MainFile
     *            IsMultiFile为True时，指定多文件的主文件，为False时此参数忽略
     * @param serverURL
     *            辅导资源服务器url（路径前缀）
     * @author wangwr
     */
    public static String getFinalURLEncrypt(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile, String serverURL) {
        String filePath = getFinalURL(FileName, PlayerType, IsMultiFile, MainFile, serverURL);
        return xxtea.HexEncrypt(filePath, secretKey_online);
    }

    /**
     * flash在线播放路径的加密字段
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param PlayerType
     *            视频播放类型，1:Lexue插件播放 2:Flash播放器播放 3:Video标签嵌入视频
     * @param IsMultiFile
     *            指定资源是否多文件
     * @param MainFile
     *            IsMultiFile为True时，指定多文件的主文件，为False时此参数忽略
     * @param serverURL
     *            辅导资源服务器url（路径前缀）
     * @author wangwr
     */
    public static String getFinalURLEncrypt(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile, String localServerURL, String serverURL) {
        String filePath = getFinalURL(FileName, PlayerType, IsMultiFile, MainFile, localServerURL);
        filePath = filePath.replace(localServerURL, serverURL);
        System.out.println("filePath=" + filePath);
        return xxtea.HexEncrypt(filePath, secretKey_online);
    }

    /**
     * flash在线播放路径的加密字段
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param PlayerType
     *            视频播放类型，1:Lexue插件播放 2:Flash播放器播放 3:Video标签嵌入视频
     * @param IsMultiFile
     *            指定资源是否多文件
     * @param MainFile
     *            IsMultiFile为True时，指定多文件的主文件，为False时此参数忽略
     * @param serverURL
     *            辅导资源服务器url（路径前缀）
     * @author wangwr
     */
    public static String getFinalURLEncryptNo(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile, String localServerURL, String serverURL) {
        String filePath = getFinalURL(FileName, PlayerType, IsMultiFile, MainFile, localServerURL);
        filePath = filePath.replace(localServerURL, serverURL);
        System.out.println("filePath=" + filePath);
        return filePath;
    }

    /**
     * 获取电子教辅路径
     * 
     * @param args
     * 
     */
    public static String GetEBookPlayerURL(String EBookPath, String serverURL) {
        zhldowncenter down = new zhldowncenter(customerID, customerKey, serverURL);
        // return down.GetResourcePlayURL("EncryptMaterial\\"+EBookPath,true) + "&mode=ebook";
        return down.GetResourcePlayURL(EBookPath, true) + "&mode=ebook";
    }

    public static void main(String args[]) {
        String fileName = "GZ\\0201\\mp4\\gzsx00001.mp4";
        String serverURL = "http://fd.tfedu.net/";

        int playerType = 2;
        String url = getFinalURL(fileName, playerType, false, "", serverURL);
        System.out.println(fileName + "----" + playerType + "--false--");
        String url2 = getFinalURLEncrypt(fileName, playerType, false, "", serverURL);
        System.out.println(url);
        System.out.println(url2);

    }

}