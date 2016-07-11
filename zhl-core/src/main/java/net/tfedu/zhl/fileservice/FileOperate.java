package net.tfedu.zhl.fileservice;

public class FileOperate {
    private String CustomerID;
    private String SignCode;

    /**
     * 操作类型：copy,move,delete
     */
    private String OperateType;
    /**
     * 源文件列表
     */
    private String[] SourceFile;
    /**
     * 目标文件列表
     */
    private String[] DestFile;

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

    public String getOperateType() {
        return OperateType;
    }

    /**
     * 操作类型：copy,move,delete
     */
    public void setOperateType(String operateType) {
        OperateType = operateType;
    }

    public String[] getSourceFile() {
        return SourceFile;
    }

    public void setSourceFile(String[] sourceFile) {
        SourceFile = sourceFile;
    }

    public String[] getDestFile() {
        return DestFile;
    }

    public void setDestFile(String[] destFile) {
        DestFile = destFile;
    }

    /**
     * 全部源文件拼接字符串
     */
    public String getAllSourceFile() {
        if (SourceFile == null || SourceFile.length == 0)
            return "";
        else {
            String Result = "";
            for (int i = 0; i < SourceFile.length; i++)
                Result += SourceFile[i];
            return Result;
        }
    }
}