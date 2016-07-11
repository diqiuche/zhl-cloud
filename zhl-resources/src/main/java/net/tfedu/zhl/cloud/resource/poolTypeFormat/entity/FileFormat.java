package net.tfedu.zhl.cloud.resource.poolTypeFormat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "j_filetypedetail")
public class FileFormat implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 格式代码
     */
    @Column(name = "FormatCode")
    private String formatcode;

    /**
     * 文件类型
     */
    @Column(name = "FileFormat")
    private String fileformat;

    /**
     * 文件类型描述
     */
    @Column(name = "TypeDesc")
    private String typedesc;

    /**
     * 排序
     */
    @Column(name = "OrderNum")
    private Integer ordernum;

    /**
     * 是否删除，0----否；1-----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    public FileFormat(Long id, String formatcode, String fileformat, String typedesc, Integer ordernum, Boolean flag) {
        this.id = id;
        this.formatcode = formatcode;
        this.fileformat = fileformat;
        this.typedesc = typedesc;
        this.ordernum = ordernum;
        this.flag = flag;
    }

    public FileFormat() {
        super();
    }

    /**
     * 获取自增id
     *
     * @return Id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id
     *            自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取格式代码
     *
     * @return FormatCode - 格式代码
     */
    public String getFormatcode() {
        return formatcode;
    }

    /**
     * 设置格式代码
     *
     * @param formatcode
     *            格式代码
     */
    public void setFormatcode(String formatcode) {
        this.formatcode = formatcode == null ? null : formatcode.trim();
    }

    /**
     * 获取文件类型
     *
     * @return FileFormat - 文件类型
     */
    public String getFileformat() {
        return fileformat;
    }

    /**
     * 设置文件类型
     *
     * @param fileformat
     *            文件类型
     */
    public void setFileformat(String fileformat) {
        this.fileformat = fileformat == null ? null : fileformat.trim();
    }

    /**
     * 获取文件类型描述
     *
     * @return TypeDesc - 文件类型描述
     */
    public String getTypedesc() {
        return typedesc;
    }

    /**
     * 设置文件类型描述
     *
     * @param typedesc
     *            文件类型描述
     */
    public void setTypedesc(String typedesc) {
        this.typedesc = typedesc == null ? null : typedesc.trim();
    }

    /**
     * 获取排序
     *
     * @return OrderNum - 排序
     */
    public Integer getOrdernum() {
        return ordernum;
    }

    /**
     * 设置排序
     *
     * @param ordernum
     *            排序
     */
    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * 获取是否删除，0----否；1-----是
     *
     * @return Flag - 是否删除，0----否；1-----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除，0----否；1-----是
     *
     * @param flag
     *            是否删除，0----否；1-----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}