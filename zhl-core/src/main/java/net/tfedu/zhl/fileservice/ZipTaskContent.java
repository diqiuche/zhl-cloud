package net.tfedu.zhl.fileservice;

public class ZipTaskContent {
    private String CustomerID;
    private String SignCode;
    /**
     * 保存的Zip文件名称
     */
    private String ZipFileName;
    /**
     * Zip包内文件的统一入口路径，如果不指定，则需为SourceFile一一指定EntryName
     */
    private String EntryPath;
    /**
     * 任务结束后的通知地址
     */
    private String NotifyUrl;
    /**
     * 源文件列表
     */
    private String[] SourceFile;
    /**
     * 每个文件单独的EntryName
     */
    private String[] EntryName;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getSignCode() {
        return SignCode;
    }

    public void setSignCode(String signCode) {
        SignCode = signCode;
    }

    public String getZipFileName() {
        return ZipFileName;
    }

    public void setZipFileName(String zipFileName) {
        ZipFileName = zipFileName;
    }

    public String getEntryPath() {
        return EntryPath;
    }

    public void setEntryPath(String entryPath) {
        EntryPath = entryPath;
    }

    public String getNotifyUrl() {
        return NotifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        NotifyUrl = notifyUrl;
    }

    public String[] getSourceFile() {
        return SourceFile;
    }

    public void setSourceFile(String[] sourceFile) {
        SourceFile = sourceFile;
    }

    public String[] getEntryName() {
        return EntryName;
    }

    public void setEntryName(String[] entryName) {
        EntryName = entryName;
    }
}