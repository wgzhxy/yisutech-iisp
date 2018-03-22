package com.yisutech.iisp.dataops.repository.pojo;

public class opsTable {
    private Integer id;

    private String tbName;

    private String tbDesc;

    private Integer tbFiledsNum;

    private Integer tbSourceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTbName() {
        return tbName;
    }

    public void setTbName(String tbName) {
        this.tbName = tbName;
    }

    public String getTbDesc() {
        return tbDesc;
    }

    public void setTbDesc(String tbDesc) {
        this.tbDesc = tbDesc;
    }

    public Integer getTbFiledsNum() {
        return tbFiledsNum;
    }

    public void setTbFiledsNum(Integer tbFiledsNum) {
        this.tbFiledsNum = tbFiledsNum;
    }

    public Integer getTbSourceId() {
        return tbSourceId;
    }

    public void setTbSourceId(Integer tbSourceId) {
        this.tbSourceId = tbSourceId;
    }
}