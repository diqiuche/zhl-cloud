package net.tfedu.zhl.fileservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

/**
 * 知好乐资源管理中心接口
 * 
 * @author BoatZhang
 * 
 * @version 2015/11/26
 */
public class zhldowncenter {

    public String LastError;

    /**
     * 知好乐流媒体文件编码器
     * 
     * @author BoatZhang
     * @param CustomerID
     *            客服服务号码
     * @param CustomerKey
     *            客服服务密码
     * @param DownloadCenterURL
     *            下载中心地址
     */
    public zhldowncenter(String CustomerID, String CustomerKey, String DownloadCenterURL) {
        this.CustomerID = CustomerID;
        this.CustomerKey = CustomerKey;
        this.DownloadCenterURL = DownloadCenterURL;
        if (this.DownloadCenterURL.lastIndexOf('/') != this.DownloadCenterURL.length() - 1)
            this.DownloadCenterURL += "/";
    }

    private String appendParam(String returnStr, String paramId, String paramValue) {
        if (!StringUtil.IsNullOrEmpty(returnStr)) {
            if (!StringUtil.IsNullOrEmpty(paramValue)) {
                returnStr += "&" + paramId + "=" + paramValue;
            }
        }
        else {
            if (!StringUtil.IsNullOrEmpty(paramValue)) {
                returnStr = paramId + "=" + paramValue;
            }
        }
        return returnStr;
    }

    private String CustomerID;
    private String CustomerKey;
    private String DownloadCenterURL;

    // 请求方法
    private static String GetMethod = "get.do?";
    private static String ApplyMethod = "app.do?";
    private static String UploadMethod = "push.do?";
    private static String DeleteMethod = "del.do?";
    private static String PlayerPage = "play.aspx?";
    private static String ZipMethod = "zip.do";
    private static String FileMethod = "file.do";

    private String PostHttpWebRequest(final String PageUrl, String strContent) {
        URL url;
        String line = null;
        StringBuffer sb = new StringBuffer();
        BufferedReader buffer = null;
        try {
            // 先进行请求文本编码
            strContent = xxtea.HexEncrypt(strContent, "ZHLFileServices");

            url = new URL(PageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setConnectTimeout(50000);// 设置连接超时
            conn.setReadTimeout(50000);// 设置读取超时
            conn.setRequestMethod("POST");
            // conn.setRequestProperty("Content-Type",
            // "text/xml; charset=UTF-8");

            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            osw.write(strContent);
            osw.flush();
            // osw.close();

            if (conn.getResponseCode() == 200) {
                buffer = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((line = buffer.readLine()) != null) {
                    sb.append(line);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                buffer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    // 签名和生成请求URL功能函数
    private String GetSignCode(String strFileName, String strSerialNumber, String strCustomerID, String strCustomerKey) {
        // 验证签名
        String SignString = appendParam("", "uid", strCustomerID);
        SignString = appendParam(SignString, "file", strFileName);
        SignString = appendParam(SignString, "sn", strSerialNumber);
        SignString = appendParam(SignString, "key", strCustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        return sign;
    }

    private String GetQueryString(String strFileName, String strSerialNumber, String strSignCode, String strCustomerID) {
        // 验证签名
        String SignString = appendParam("", "uid", strCustomerID);
        try {
            SignString = appendParam(SignString, "file", URLEncoder.encode(Base64.encode(strFileName.getBytes("utf-8")), "utf-8"));
        }
        catch (Exception e) {
        }

        SignString = appendParam(SignString, "sn", strSerialNumber);
        SignString = appendParam(SignString, "sign", strSignCode);

        return SignString;
    }

    private String GetApplySignCode(String strFileName, String strCustomerID, String strCustomerKey) {
        return GetApplySignCode(null, strFileName, strCustomerID, strCustomerKey);
    }

    private String GetApplySignCode(String appMode, String strFileName, String strCustomerID, String strCustomerKey) {
        // 验证签名
        String SignString = appendParam("", "uid", strCustomerID);
        SignString = appendParam(SignString, "file", strFileName);
        if (appMode != null && !"".equals(appMode))
            SignString = appendParam(SignString, "mode", appMode);
        SignString = appendParam(SignString, "key", strCustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        return sign;
    }

    private String GetApplyQueryString(String strFileName, String strSignCode, String strCustomerID) {
        return GetApplyQueryString(null, strFileName, strSignCode, strCustomerID);
    }

    private String GetApplyQueryString(String appMode, String strFileName, String strSignCode, String strCustomerID) {
        // 验证签名
        String SignString = appendParam("", "uid", strCustomerID);
        try {
            SignString = appendParam(SignString, "file", URLEncoder.encode(Base64.encode(strFileName.getBytes("utf-8")), "utf-8"));
        }
        catch (Exception e) {
        }
        SignString = appendParam(SignString, "sign", strSignCode);
        if (appMode != null && !"".equals(appMode))
            SignString = appendParam(SignString, "mode", appMode);

        return SignString;
    }

    private String GetFilenameSign(String strSerialNumber, String strType) {
        String strSign = MD5.getMD5Str(strSerialNumber + "-" + strType);
        char[] signchar = strSign.toCharArray();
        return strSerialNumber + "-" + strType + signchar[0] % 10 + signchar[1] % 10;
    }

    // 上传部分
    private String GetUploadSignCode(String strFilePath, String strSerialNumber, String strExtend, String strReturn) {
        // 验证签名
        String SignString = appendParam("", "uid", CustomerID);
        SignString = appendParam(SignString, "file", strFilePath);
        SignString = appendParam(SignString, "sn", strSerialNumber);
        SignString = appendParam(SignString, "ext", strExtend);
        SignString = appendParam(SignString, "ret", strReturn);
        SignString = appendParam(SignString, "key", CustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        return sign;
    }

    private String GetUploadQueryString(String strFilePath, String strSerialNumber, String strExtend, String strReturn) {
        // 验证签名
        String SignString = appendParam("", "uid", CustomerID);
        try {
            SignString = appendParam(SignString, "file", URLEncoder.encode(Base64.encode(strFilePath.getBytes("utf-8")), "utf-8"));
        }
        catch (Exception e) {
        }
        SignString = appendParam(SignString, "sn", strSerialNumber);

        try {
            SignString = appendParam(SignString, "ext", URLEncoder.encode(Base64.encode(strExtend.getBytes("utf-8")), "utf-8"));
        }
        catch (Exception e) {
        }
        SignString = appendParam(SignString, "ret", strReturn);

        String signcode = GetUploadSignCode(strFilePath, strSerialNumber, strExtend, strReturn);
        SignString = appendParam(SignString, "sign", signcode);

        return SignString;
    }

    // 删除部分
    private String GetDeleteSignCode(String strFileName) {
        // 验证签名
        String SignString = appendParam("", "uid", CustomerID);
        SignString = appendParam(SignString, "file", strFileName);
        SignString = appendParam(SignString, "key", CustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        return sign;
    }

    private String GetDeleteQueryString(String strFileName) {
        // 验证签名
        String SignString = appendParam("", "uid", CustomerID);
        try {
            SignString = appendParam(SignString, "file", URLEncoder.encode(Base64.encode(strFileName.getBytes("utf-8")), "utf-8"));
        }
        catch (Exception e) {
        }
        String signcode = GetDeleteSignCode(strFileName);
        SignString = appendParam(SignString, "sign", signcode);

        return SignString;
    }

    /**
     * 获取受保护下载的URL参数字符串，默认直接在网页中打开文件，而不是以附件的形式下载
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public String GetProtectDownloadURLString(String FileName) {
        return GetProtectDownloadURLString(FileName, 1);
    }

    public String GetProtectDownloadURLString(String FileName, int DiskID) {
        return GetProtectDownloadURLString(FileName, (short) 1, false, null, DiskID);
    }

    /**
     * 获取受保护下载的URL参数字符串
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public String GetProtectDownloadURLString(String FileName, Boolean IsDown) {
        return GetProtectDownloadURLString(FileName, IsDown, 1);
    }

    public String GetProtectDownloadURLString(String FileName, Boolean IsDown, int DiskID) {
        if (IsDown)
            return GetProtectDownloadURLString(FileName, (short) 9, false, null, DiskID);
        else
            return GetProtectDownloadURLString(FileName, (short) 1, false, null, DiskID);
    }

    /**
     * 获取受保护下载的URL参数字符串
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @param PlayerType
     *            视频播放类型，1:Lexue插件播放 2:Flash播放器播放 3:Video标签嵌入视频
     * @param IsMultiFile
     *            指定资源是否多文件
     * @param MainFile
     *            IsMultiFile为True时，指定多文件的主文件，为False时此参数忽略
     * @author BoatZhang
     */
    public String GetProtectDownloadURLString(String FileName, short PlayerType, Boolean IsMultiFile, String MainFile) {
        return GetProtectDownloadURLString(FileName, PlayerType, IsMultiFile, MainFile, 1);
    }

    public String GetProtectDownloadURLString(String FileName, short PlayerType, Boolean IsMultiFile, String MainFile, int DiskID) {
        return getDownloadURLString("nor", FileName, PlayerType, IsMultiFile, MainFile, DiskID);
    }

    /**
     * 获取受保护下载的URL参数字符串 时间等限制
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public String GetProtectDownloadURLString(String FileName, Boolean IsDown, Boolean IsMultiFile) {
        return GetProtectDownloadURLString(FileName, IsDown, IsMultiFile, 1);
    }

    public String GetProtectDownloadURLString(String FileName, Boolean IsDown, Boolean IsMultiFile, int DiskID) {
        if (IsDown)
            return GetProtectDownloadURLString(FileName, (short) 9, IsMultiFile, null, DiskID);
        else
            return GetProtectDownloadURLString(FileName, (short) 1, IsMultiFile, null, DiskID);
    }

    /**
     * 获取加密文件下载的URL参数字符串
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public String GetEncryptDownloadURLString(String FileName, int DiskID) {
        return getDownloadURLString("dec", FileName, (short) 0, false, null, DiskID);
    }

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
     * @author BoatZhang
     */
    public String GetEncryptDownloadURLString(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile, int DiskID) {
        return getDownloadURLString("dec", FileName, (short) PlayerType, IsMultiFile, MainFile, DiskID);
    }

    public String GetEncryptDownloadURLString(String FileName, int PlayerType, Boolean IsMultiFile, String MainFile) {
        return GetEncryptDownloadURLString(FileName, PlayerType, IsMultiFile, MainFile, 1);
    }

    private String getDownloadURLString(String FileType, String FileName, short PlayerType, Boolean IsMultiFile, String MainFile, int DiskID) {
        try {
            String SerialNumber = "";

            String ApplySignCode = GetApplySignCode(FileName, CustomerID, CustomerKey);
            String ApplyURL = DownloadCenterURL + ApplyMethod + GetApplyQueryString(FileName, ApplySignCode, CustomerID) + "&disk=" + DiskID;
            SerialNumber = HttpUtil.PostHttpWebRequest(ApplyURL);

            if (SerialNumber.length() > 0) {
                String strExt = Path.GetExtension(FileName).toLowerCase();

                // 测试，全部使用通用请求是否可行
                if (IsMultiFile)
                    return DownloadCenterURL + FileType + "/" + GetFilenameSign(SerialNumber, String.valueOf(PlayerType)) + '/' + MainFile;
                else
                    return DownloadCenterURL + FileType + "/" + GetFilenameSign(SerialNumber, String.valueOf(PlayerType)) + strExt;

            }
            else
                return "";
        }
        catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取免费文件下载的URL参数字符串，比如缩略图文件
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public String GetFreeDownloadURLString(String FileName) {
        return GetFreeDownloadURLString(FileName, 1);
    }

    public String GetFreeDownloadURLString(String FileName, int DiskID) {
        return GetFreeDownloadURLString(FileName, false, DiskID);
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
    public String GetFreeDownloadURLString(String FileName, Boolean IsDown, int DiskID) {
        String Result = "";
        String SerialNumber = "tfedu";
        String SignCode = GetSignCode(FileName, SerialNumber, CustomerID, CustomerKey);

        Result = DownloadCenterURL + GetMethod;
        if (IsDown)
            Result += "down=1&";

        return Result + GetQueryString(FileName, SerialNumber, SignCode, CustomerID) + "&disk=" + DiskID;
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
    public String GetFreeDownloadURLString(String FileName, Boolean IsDown) {
        return GetFreeDownloadURLString(FileName, IsDown, 1);
    }

    /**
     * 判断下载服务器是否存在此文件
     * 
     * @param FileName
     *            要下载的文件相对文件名
     * @author BoatZhang
     */
    public boolean TestFileExist(String FileName) {
        return TestFileExist(FileName, 1);
    }

    public boolean TestFileExist(String FileName, int DiskID) {
        String SerialNumber = "tfedu";
        String SignCode = GetSignCode(FileName, SerialNumber, CustomerID, CustomerKey);
        return "True".equals(HttpUtil.PostHttpWebRequest(DownloadCenterURL + GetMethod + "check=1&disk=" + DiskID + "&" + GetQueryString(FileName, SerialNumber, SignCode, CustomerID)));
    }

    /**
     * 獲取文件信息
     * 
     * @param FileName
     * @return
     */
    public String GetFileInfo(String FileName) {
        return GetFileInfo(FileName, 1);
    }

    public String GetFileInfo(String FileName, int DiskID) {
        String Result = "";

        String ApplySignCode = GetApplySignCode("fileinfo", FileName, CustomerID, CustomerKey);
        String ApplyURL = DownloadCenterURL + ApplyMethod + GetApplyQueryString("fileinfo", FileName, ApplySignCode, CustomerID) + "&disk=" + DiskID;
        Result = HttpUtil.PostHttpWebRequest(ApplyURL);

        return Result;
    }

    /**
     * 获取资源播放地址
     * 
     * @param IsMultiFile
     *            是否为多文件
     */
    public String GetResourcePlayURL(String FileName, Boolean IsMultiFile) {
        return GetResourcePlayURL(FileName, IsMultiFile, 1);
    }

    public String GetResourcePlayURL(String FileName, Boolean IsMultiFile, int DiskID) {
        String SerialNumber;

        String ApplySignCode = GetApplySignCode(FileName, CustomerID, CustomerKey);
        String ApplyURL = DownloadCenterURL + ApplyMethod + GetApplyQueryString(FileName, ApplySignCode, CustomerID) + "&disk=" + DiskID;
        SerialNumber = HttpUtil.PostHttpWebRequest(ApplyURL);

        if (IsMultiFile)
            return DownloadCenterURL + PlayerPage + "uid=" + CustomerID + "&sn=" + SerialNumber + "&multi=1";
        else
            return DownloadCenterURL + PlayerPage + "uid=" + CustomerID + "&sn=" + SerialNumber + "&multi=0";
    }

    /**
     * 获取资源播放地址
     */
    public String GetResourcePlayURL(String FileName) {
        return GetResourcePlayURL(FileName, 1);
    }

    public String GetResourcePlayURL(String FileName, int DiskID) {
        return GetResourcePlayURL(FileName, false, DiskID);
    }

    /**
     * 获取资源（.swf .mp4）离线限时播放包
     * 
     * @param FileName
     *            文件名（FilePath有效时为主文件名）
     * @param FilePath
     *            文件路径（多文件时有效）
     * @return
     */
    public String GetExePackageURL(String FileName, String FilePath) {
        return GetExePackageURL(FileName, FilePath, 1);
    }

    public String GetExePackageURL(String FileName, String FilePath, int DiskID) {
        String sign = GetApplySignCode("exepackage", FileName, CustomerID, CustomerKey);
        try {
            return DownloadCenterURL + ApplyMethod + GetApplyQueryString("exepackage", FileName, sign, CustomerID) + "&path=" + URLEncoder.encode(FilePath, "utf-8") + "&disk=" + DiskID;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 发送Zip文件包压缩任务到服务器
     * 
     * @param Content
     *            结构化数据
     * @return True or False, 失败时查看LastError
     */
    public Boolean SendZipPackageTask(ZipTaskContent Content) {
        Content.setCustomerID(CustomerID);
        String SignString = appendParam("", "uid", CustomerID);
        SignString = appendParam(SignString, "zip", Content.getZipFileName());
        SignString = appendParam(SignString, "key", CustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        Content.setSignCode(sign);

        String zipcontent = JSONObject.toJSONString(Content);

        // Post方式将请求（XML格式）发送到服务器，获取返回XML
        String ApplyURL = DownloadCenterURL + ZipMethod;
        String strResult = PostHttpWebRequest(ApplyURL, zipcontent);
        LastError = strResult;

        return "OK".equals(strResult);
    }

    // 外部调用的公共方法 上传
    public String GetUploadURLString(String FilePath, String DownCenterURL, String Extend, String ReturnURL) {
        String SerialNumber = "";
        // 获取序列号，序列号20分钟（默认）内使用有效

        String ApplySignCode = GetApplySignCode(FilePath, CustomerID, CustomerKey);
        String ApplyURL = DownloadCenterURL + ApplyMethod + GetApplyQueryString(FilePath, ApplySignCode, CustomerID);
        SerialNumber = HttpUtil.PostHttpWebRequest(ApplyURL);

        if (SerialNumber.length() > 0) {
            String Result = DownCenterURL + UploadMethod;
            String Code = GetUploadQueryString(FilePath, SerialNumber, Extend, ReturnURL);
            try {
                Result += "code=" + Base64.encode(Code.getBytes("utf-8"));
            }
            catch (Exception e) {
            }
            return Result;
        }
        else
            return "";
    }

    public String GetUploadURLString(String FilePath, String Extend, String ReturnURL) {
        return GetUploadURLString(FilePath, DownloadCenterURL, Extend, ReturnURL);
    }

    /**
     * 发送文件操作到资源服务器
     * 
     * @param operate
     *            结构化数据
     * @return True or False, 失败时查看LastError
     */
    public boolean SendFileOperateTask(FileOperate operate) {
        operate.setCustomerID(CustomerID);
        String SignString = appendParam("", "uid", CustomerID);
        SignString = appendParam(SignString, "type", operate.getOperateType());
        SignString = appendParam(SignString, "src", operate.getAllSourceFile());
        SignString = appendParam(SignString, "key", CustomerKey);
        // 生成Md5摘要；
        String sign = MD5.getMD5Str(SignString);
        operate.setSignCode(sign);

        String content = JSONObject.toJSONString(operate);

        // Post方式将请求（XML格式）发送到服务器，获取返回XML
        String ApplyURL = DownloadCenterURL + FileMethod;
        String strResult = PostHttpWebRequest(ApplyURL, content);
        LastError = strResult;

        return "OK".equals(strResult);
    }

    public boolean SendFileConvertTask(String FileName, String Extend, String ReturnURL) {
        String sign = GetApplySignCode("convert", FileName, CustomerID, CustomerKey);
        String ApplyURL;
        try {
            ApplyURL = DownloadCenterURL + ApplyMethod + GetApplyQueryString("convert", FileName, sign, CustomerID) + "&ext=" + URLEncoder.encode(Base64.encode(Extend.getBytes("utf-8")), "utf-8")
                    + "&ret=" + URLEncoder.encode(ReturnURL, "utf-8");

            String strResult = HttpUtil.PostHttpWebRequest(ApplyURL);
            LastError = strResult;

            return strResult == "OK";
        }
        catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

    public static String GetOriginQueryString(String value) {
        if (value == null || value.length() == 0)
            return value;

        // URLEncoder.encode(Base64.encode(strFilePath.getBytes("utf-8")), "utf-8")
        // Url转换后字符串 ＋ 变成了 空格
        value = value.replace(" ", "+");
        try {
            value = URLDecoder.decode(value, "utf-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        byte[] b;
        try {
            b = Base64.decode(value);
            value = new String(b, "utf-8");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * 获取执行打包任务URL地址
     * 
     * @param FileName
     *            文件名（单文件时为文件全路径，多文件时为不带路径的主文件名）
     * @param FilePath
     *            文件路径（多文件时有效，多文件存放路径）
     * @return
     */
    public String InvokeExePackageTaskURL(String FileName, String FilePath) {
        String sign = GetApplySignCode("onlypackage", FileName, CustomerID, CustomerKey);

        try {
            return DownloadCenterURL + ApplyMethod + GetApplyQueryString("onlypackage", FileName, sign, CustomerID) + "&path=" + (FilePath == null ? "" : URLEncoder.encode(FilePath, "utf-8"));
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {

        // 资源服务器客户信息 云平台学习资源访问
        String CustomerID = "100798967857546";
        String CustomerKey = "JWJ83OPR0985LJL";

        // 用客户信息和资源服务器地址初始化接口类实例
        zhldowncenter down = new zhldowncenter(CustomerID, CustomerKey, "http://219.239.146.213/down");

        String url = down.InvokeExePackageTaskURL("test\\wt.mp4", null);
        System.out.println(url);
        String result = HttpUtil.PostHttpWebRequest(url);
        result = result.replace("\\", "\\\\");
        HashMap obj = JSONObject.parseObject(result, HashMap.class);

        System.out.println(obj.toString());
        System.out.println(obj.get("filename"));

        // zhldowncenter down = new zhldowncenter(CustomerID, CustomerKey,
        // "http://192.168.111.22:8099/down/");

        // 请求加密资源播放地址，格式为 EncryptMaterial\ + FPath + FName
        // String res = down
        // .GetFileInfo("upFile/2016/10105/390320126/2016021716133614649-27.png");
        // System.out.println(res);

        // String exepack = down.GetExePackageURL(
        // "Material\\gz\\0102\\mp4\\gzyy00018.mp4", "");
        // System.out.println(exepack);

        /*
         * 上传文件 String url = down.GetUploadURLString("upFile\\", "rename&uid=123&pp=中文", ""); System.out.println(url); res = HttpUtil.PostFileToServer(url, "F:\\知好乐资源中心云部署方案.docx");
         * System.out.println(res);
         */

        // down.SendFileConvertTask("upFile\\2015112617212898932-1.docx", "uid=123&pp=打开就是浮点数", "http://www.baidu.com");

        // down.SendFileConvertTask("/upFile/2015/341/699230735/2015072409002256126-6.doc", "rename&userId=699230735", "http://192.168.111.101:8090/historyConvert_insert.action");
        //
        // System.out.println();
        // System.out.println(zhldowncenter.GetOriginQueryString("cmVuYW1lJnVpZD0yMzQyMyZwcD3nsbvkvLznmoTnqbrpl7TliIblvIDkuoY="));
        //
        //
        // 转换完成后通知格式 url?uid=xxx&file=xxx&convert=xxx&ext=cmVuYW1lJnVpZD0yMzQyMyZwcD3nsbvkvLznmoTnqbrpl7TliIblvIDkuoY=
        // 其中ext为编码后数据，解码操作调用 zhldowncenter.GetOriginQueryString()

        /*
         * FileOperate operate = new FileOperate(); operate.setOperateType("copy"); String[] src = new String[1]; src[0] = "upFile\\2015\\10105\\390320126\\2015121810495846198-28.gif";
         * operate.setSourceFile(src);
         * 
         * String[] dst = new String[1]; dst[0] = "upFile\\2015\\one\\copy\\2015121810495846198-28.gif"; operate.setDestFile(dst);
         * 
         * Boolean result = down.SendFileOperateTask(operate); if (result) System.out.println("success"); else System.out.println(down.LastError);
         */
        /*
         * ZipTaskContent task = new ZipTaskContent(); task.setZipFileName("GZ\\1602.zip"); String[] src = new String[4]; src[0] = "GZ\\0101\\GZ0101011734\\GZ0101011734_QueQ.jpg"; src[1] =
         * "GZ\\0101\\GZ0101011734\\GZ0101011734_SubQ_1.jpg"; src[2] = "GZ\\0101\\GZ0101011742\\新建文件夹\\a.txt"; src[3] = "GZ\\0101\\GZ0101011742\\GZ0101011742_QueQ.jpg"; task.setSourceFile(src);
         * 
         * String[] ent = new String[4]; ent[0] = "GZ0101011734\\GZ0101011734_QueQ.jpg"; ent[1] = "GZ0101011734\\GZ0101011734_SubQ_1.jpg"; ent[2] = "GZ0101011742\\新建文件夹\\a.txt"; ent[3] =
         * "GZ0101011742\\GZ0101011742_QueQ.jpg"; task.setEntryName(ent);
         * 
         * //JSONObject object5 = (JSONObject) JSONSerializer.toJSON(task); String json = JSONObject.fromObject(task).toString();
         * 
         * String CustomerID = "0000000000"; String CustomerKey = "1111111111"; zhldowncenter down = new zhldowncenter(CustomerID, CustomerKey, "http://localhost/d/"); Boolean res =
         * down.SendZipPackageTask(task); if (res) System.out.println("success"); else System.out.println(down.LastError);
         * 
         * System.out.println(down.GetFreeDownloadURLString("GZ\\1602.zip")); // task.NotifyUrl = "http://localhost/d/sss.aspx?zip=" + HttpUtility.UrlEncode(task.ZipFileName);
         */
    }
}
