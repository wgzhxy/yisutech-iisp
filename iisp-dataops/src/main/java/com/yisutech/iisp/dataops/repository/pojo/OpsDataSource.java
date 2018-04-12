package com.yisutech.iisp.dataops.repository.pojo;

public class OpsDataSource {
    private Integer id;

    private String dsUrl;

    private String dsUser;

    private String dsPassword;

    private String dsName;

    private String dsDesc;

    private String dsType;

    private String dsExtParam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsUrl() {
        return dsUrl;
    }

    public void setDsUrl(String dsUrl) {
        this.dsUrl = dsUrl;
    }

    public String getDsUser() {
        return dsUser;
    }

    public void setDsUser(String dsUser) {
        this.dsUser = dsUser;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDsDesc() {
        return dsDesc;
    }

    public void setDsDesc(String dsDesc) {
        this.dsDesc = dsDesc;
    }

    public String getDsType() {
        return dsType;
    }

    public void setDsType(String dsType) {
        this.dsType = dsType;
    }

    public String getDsExtParam() {
        return dsExtParam;
    }

    public void setDsExtParam(String dsExtParam) {
        this.dsExtParam = dsExtParam;
    }
}