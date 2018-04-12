package com.yisutech.iisp.dataops.repository.pojo;

public class OpsLogicTableColumn {
    private Integer id;

    private String lfdName;

    private String lfdType;

    private String lfdExpress;

    private String lfdTbId;

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
}