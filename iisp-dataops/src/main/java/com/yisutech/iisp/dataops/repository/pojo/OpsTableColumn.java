package com.yisutech.iisp.dataops.repository.pojo;

public class OpsTableColumn {
    private Integer id;

    private Integer tbId;

    private String fdName;

    private String fdDesc;

    private String fdType;

    private Integer fdLength;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTbId() {
        return tbId;
    }

    public void setTbId(Integer tbId) {
        this.tbId = tbId;
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    public String getFdDesc() {
        return fdDesc;
    }

    public void setFdDesc(String fdDesc) {
        this.fdDesc = fdDesc;
    }

    public String getFdType() {
        return fdType;
    }

    public void setFdType(String fdType) {
        this.fdType = fdType;
    }

    public Integer getFdLength() {
        return fdLength;
    }

    public void setFdLength(Integer fdLength) {
        this.fdLength = fdLength;
    }
}