package net.tfedu.zhl.sso.users.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 资源列表
 * 
 * @author bruce
 *
 */
@Table(name = "j_funclist")
public class FuncList {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单id
     */
    @Column(name = "MenuId")
    private Long menuid;

    /**
     * 功能名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 功能描述
     */
    @Column(name = "FuncDesc")
    private String funcdesc;

    /**
     * 路径
     */
    @Column(name = "Path")
    private String path;

    /**
     * 功能所属区域
     */
    @Column(name = "Area")
    private String area;

    /**
     * 区域级别，省：A，市；B，区县，C，学校 D
     */
    @Column(name = "FuncType")
    private String functype;

    /**
     * 0-----基础功能；1------不是基础功能
     */
    @Column(name = "IsBase")
    private Boolean isbase;

    /**
     * 是否免费，0----免费；1-----不免费
     */
    @Column(name = "IsFree")
    private Boolean isfree;

    /**
     * 功能表，0----可用；1-----不可用
     */
    @Column(name = "IsEnabled")
    private Boolean isenabled;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 能功子集（父节点）
     */
    private Long pid;

    /**
     * 图标路径
     */
    @Column(name = "iconPath")
    private String iconpath;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共,1-子系统自定义
     */
    private Boolean tag;

    public FuncList(Long id, Long menuid, String name, String funcdesc, String path, String area, String functype, Boolean isbase, Boolean isfree, Boolean isenabled, Boolean flag, Long pid,
            String iconpath, String model, Boolean tag) {
        this.id = id;
        this.menuid = menuid;
        this.name = name;
        this.funcdesc = funcdesc;
        this.path = path;
        this.area = area;
        this.functype = functype;
        this.isbase = isbase;
        this.isfree = isfree;
        this.isenabled = isenabled;
        this.flag = flag;
        this.pid = pid;
        this.iconpath = iconpath;
        this.model = model;
        this.tag = tag;
    }

    public FuncList() {
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
     * 获取菜单id
     *
     * @return MenuId - 菜单id
     */
    public Long getMenuid() {
        return menuid;
    }

    /**
     * 设置菜单id
     *
     * @param menuid
     *            菜单id
     */
    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    /**
     * 获取功能名称
     *
     * @return Name - 功能名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置功能名称
     *
     * @param name
     *            功能名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取功能描述
     *
     * @return FuncDesc - 功能描述
     */
    public String getFuncdesc() {
        return funcdesc;
    }

    /**
     * 设置功能描述
     *
     * @param funcdesc
     *            功能描述
     */
    public void setFuncdesc(String funcdesc) {
        this.funcdesc = funcdesc == null ? null : funcdesc.trim();
    }

    /**
     * 获取路径
     *
     * @return Path - 路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置路径
     *
     * @param path
     *            路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取功能所属区域
     *
     * @return Area - 功能所属区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置功能所属区域
     *
     * @param area
     *            功能所属区域
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取区域级别，省：A，市；B，区县，C，学校 D
     *
     * @return FuncType - 区域级别，省：A，市；B，区县，C，学校 D
     */
    public String getFunctype() {
        return functype;
    }

    /**
     * 设置区域级别，省：A，市；B，区县，C，学校 D
     *
     * @param functype
     *            区域级别，省：A，市；B，区县，C，学校 D
     */
    public void setFunctype(String functype) {
        this.functype = functype == null ? null : functype.trim();
    }

    /**
     * 获取0-----基础功能；1------不是基础功能
     *
     * @return IsBase - 0-----基础功能；1------不是基础功能
     */
    public Boolean getIsbase() {
        return isbase;
    }

    /**
     * 设置0-----基础功能；1------不是基础功能
     *
     * @param isbase
     *            0-----基础功能；1------不是基础功能
     */
    public void setIsbase(Boolean isbase) {
        this.isbase = isbase;
    }

    /**
     * 获取是否免费，0----免费；1-----不免费
     *
     * @return IsFree - 是否免费，0----免费；1-----不免费
     */
    public Boolean getIsfree() {
        return isfree;
    }

    /**
     * 设置是否免费，0----免费；1-----不免费
     *
     * @param isfree
     *            是否免费，0----免费；1-----不免费
     */
    public void setIsfree(Boolean isfree) {
        this.isfree = isfree;
    }

    /**
     * 获取功能表，0----可用；1-----不可用
     *
     * @return IsEnabled - 功能表，0----可用；1-----不可用
     */
    public Boolean getIsenabled() {
        return isenabled;
    }

    /**
     * 设置功能表，0----可用；1-----不可用
     *
     * @param isenabled
     *            功能表，0----可用；1-----不可用
     */
    public void setIsenabled(Boolean isenabled) {
        this.isenabled = isenabled;
    }

    /**
     * 获取是否删除标示，0-----未删除；1----删除
     *
     * @return Flag - 是否删除标示，0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标示，0-----未删除；1----删除
     *
     * @param flag
     *            是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取能功子集（父节点）
     *
     * @return pid - 能功子集（父节点）
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置能功子集（父节点）
     *
     * @param pid
     *            能功子集（父节点）
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取图标路径
     *
     * @return iconPath - 图标路径
     */
    public String getIconpath() {
        return iconpath;
    }

    /**
     * 设置图标路径
     *
     * @param iconpath
     *            图标路径
     */
    public void setIconpath(String iconpath) {
        this.iconpath = iconpath == null ? null : iconpath.trim();
    }

    /**
     * 获取系统模块
     *
     * @return model - 系统模块
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置系统模块
     *
     * @param model
     *            系统模块
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取0-公共,1-子系统自定义
     *
     * @return tag - 0-公共,1-子系统自定义
     */
    public Boolean getTag() {
        return tag;
    }

    /**
     * 设置0-公共,1-子系统自定义
     *
     * @param tag
     *            0-公共,1-子系统自定义
     */
    public void setTag(Boolean tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "FuncList [id=" + id + ", menuid=" + menuid + ", name=" + name + ", funcdesc=" + funcdesc + ", path="
                + path + ", area=" + area + ", functype=" + functype + ", isbase=" + isbase + ", isfree=" + isfree
                + ", isenabled=" + isenabled + ", flag=" + flag + ", pid=" + pid + ", iconpath=" + iconpath + ", model="
                + model + ", tag=" + tag + "]";
    }
    
    
}