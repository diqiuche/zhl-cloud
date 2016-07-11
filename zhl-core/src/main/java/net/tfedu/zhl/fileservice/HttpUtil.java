package net.tfedu.zhl.fileservice;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
    public static String PostHttpWebRequest(String PageUrl) {
        URL url;
        String line = null;
        StringBuffer sb = new StringBuffer();
        BufferedReader buffer = null;
        try {
            url = new URL(PageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = buffer.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static String PostFileToServer(String PageUrl, String FileName) {
        String line = null;
        StringBuffer sb = new StringBuffer();
        String BOUNDARY = "---------------------------123821742118716"; // boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(PageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            conn.connect();
            conn.setConnectTimeout(10000);
            OutputStream out = conn.getOutputStream();

            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
            strBuf.append("Content-Disposition: form-data; filename=\"" + java.net.URLEncoder.encode(FileName, "utf-8") + "\"\r\n");
            strBuf.append("Content-Type:application/octet-stream" + "\r\n\r\n");

            out.write(strBuf.toString().getBytes());

            DataInputStream in = new DataInputStream(new FileInputStream(FileName));
            int bytes = 0;
            byte[] buffer = new byte[1024];
            while ((bytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }
            in.close();
            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            conn.disconnect();
        }
        catch (Exception e) {
            System.out.println("发送文件出现异常！" + e);
            e.printStackTrace();
        }

        return sb.toString();
    }
}
