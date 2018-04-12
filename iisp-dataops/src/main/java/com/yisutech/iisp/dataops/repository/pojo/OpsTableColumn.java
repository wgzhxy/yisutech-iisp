package com.yisutech.iisp.dataops.repository.pojo;

public class OpsTableColumn {
    private Integer id;

    private Integer tbId;

    private String fdName;

    private String fdDesc;

    private String fdType;

    private Integer fdLength;

    private Boolean fdPrimaryKey;

    private Boolean fdTagNull;

    private String fdDefaultValue;

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

    public Boolean getFdPrimaryKey() {
        return fdPrimaryKey;
    }

    public void setFdPrimaryKey(Boolean fdPrimaryKey) {
        this.fdPrimaryKey = fdPrimaryKey;
    }

    public Boolean getFdTagNull() {
        return fdTagNull;
    }

    public void setFdTagNull(Boolean fdTagNull) {
        this.fdTagNull = fdTagNull;
    }

    public String getFdDefaultValue() {
        return fdDefaultValue;
    }

    public void setFdDefaultValue(String fdDefaultValue) {
        this.fdDefaultValue = fdDefaultValue;
    }
}