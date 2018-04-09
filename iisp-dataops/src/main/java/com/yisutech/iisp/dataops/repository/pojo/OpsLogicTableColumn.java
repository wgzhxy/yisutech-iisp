package com.yisutech.iisp.dataops.repository.pojo;

public class OpsLogicTableColumn {
    private Integer id;

    private String lfdName;

    private String lfdType;

    private Integer lfdLength;

    private String lfdExpress;

    private String lfdTbId;

    private String lfdDesc;

    private Boolean lfdPrimaryKey;

    private Boolean lfdTagNull;

    private String lfdDefaultValue;

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

    public String getLfdTbId() {
        return lfdTbId;
    }

    public void setLfdTbId(String lfdTbId) {
        this.lfdTbId = lfdTbId;
    }

    public String getLfdDesc() {
        return lfdDesc;
    }

    public void setLfdDesc(String lfdDesc) {
        this.lfdDesc = lfdDesc;
    }

    public Boolean getLfdPrimaryKey() {
        return lfdPrimaryKey;
    }

    public void setLfdPrimaryKey(Boolean lfdPrimaryKey) {
        this.lfdPrimaryKey = lfdPrimaryKey;
    }

    public Boolean getLfdTagNull() {
        return lfdTagNull;
    }

    public void setLfdTagNull(Boolean lfdTagNull) {
        this.lfdTagNull = lfdTagNull;
    }

    public String getLfdDefaultValue() {
        return lfdDefaultValue;
    }

    public void setLfdDefaultValue(String lfdDefaultValue) {
        this.lfdDefaultValue = lfdDefaultValue;
    }
}