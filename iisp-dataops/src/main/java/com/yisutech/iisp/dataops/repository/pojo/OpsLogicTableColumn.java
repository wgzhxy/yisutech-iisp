package com.yisutech.iisp.dataops.repository.pojo;

public class OpsLogicTableColumn {
    private Integer id;

    private String lfdName;

    private String lfdType;

    private Integer lfdLength;

    private String lfdExpress;

    private String lfdTbAlias;

    private String lfdDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLfdName() {
        return lfdName;
    }

    public void setLfdName(String lfdName) {
        this.lfdName = lfdName;
    }

    public String getLfdType() {
        return lfdType;
    }

    public void setLfdType(String lfdType) {
        this.lfdType = lfdType;
    }

    public Integer getLfdLength() {
        return lfdLength;
    }

    public void setLfdLength(Integer lfdLength) {
        this.lfdLength = lfdLength;
    }

    public String getLfdExpress() {
        return lfdExpress;
    }

    public void setLfdExpress(String lfdExpress) {
        this.lfdExpress = lfdExpress;
    }

    public String getLfdTbAlias() {
        return lfdTbAlias;
    }

    public void setLfdTbAlias(String lfdTbAlias) {
        this.lfdTbAlias = lfdTbAlias;
    }

    public String getLfdDesc() {
        return lfdDesc;
    }

    public void setLfdDesc(String lfdDesc) {
        this.lfdDesc = lfdDesc;
    }
}