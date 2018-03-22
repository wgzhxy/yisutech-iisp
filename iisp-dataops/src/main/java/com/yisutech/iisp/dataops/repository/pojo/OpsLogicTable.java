package com.yisutech.iisp.dataops.repository.pojo;

public class OpsLogicTable {
    private Integer id;

    private Integer ltbSourceId;

    private String itbTables;

    private String ltbSqlExpress;

    private String ltbDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLtbSourceId() {
        return ltbSourceId;
    }

    public void setLtbSourceId(Integer ltbSourceId) {
        this.ltbSourceId = ltbSourceId;
    }

    public String getItbTables() {
        return itbTables;
    }

    public void setItbTables(String itbTables) {
        this.itbTables = itbTables;
    }

    public String getLtbSqlExpress() {
        return ltbSqlExpress;
    }

    public void setLtbSqlExpress(String ltbSqlExpress) {
        this.ltbSqlExpress = ltbSqlExpress;
    }

    public String getLtbDesc() {
        return ltbDesc;
    }

    public void setLtbDesc(String ltbDesc) {
        this.ltbDesc = ltbDesc;
    }
}