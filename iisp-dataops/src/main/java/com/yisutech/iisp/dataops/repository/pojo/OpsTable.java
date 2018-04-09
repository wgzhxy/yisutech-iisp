package com.yisutech.iisp.dataops.repository.pojo;

public class OpsTable {
    private Integer id;

    private String tbName;

    private String tbDesc;

    private Integer tbFiledsNum;

    private Integer tbLtbId;

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

    public Integer getTbLtbId() {
        return tbLtbId;
    }

    public void setTbLtbId(Integer tbLtbId) {
        this.tbLtbId = tbLtbId;
    }
}