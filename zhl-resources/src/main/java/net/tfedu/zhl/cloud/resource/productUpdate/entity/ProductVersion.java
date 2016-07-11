package net.tfedu.zhl.cloud.resource.productUpdate.entity;


public class ProductVersion {

    private Long code;

    private String name;

    private String description;

    public ProductVersion(Long versioncode, String versionname, String description) {
      
        this.code = versioncode;
        this.name = versionname;
        this.description = description;
    }

    public ProductVersion() {
        super();
    }


    /**
     * @return code
     */
    public Long getcode() {
        return code;
    }

    /**
     * @param versioncode
     */
    public void setcode(Long code) {
        this.code = code;
    }

    /**
     * @return name
     */
    public String getname() {
        return name;
    }

    /**
     * @param versionname
     */
    public void setname(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}