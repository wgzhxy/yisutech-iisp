package com.yisutech.iisp.dataops.repository.pojo;

public class OpsLogicTable {
    private Integer id;

    private Integer ltbSourceId;

    private String ltbTables;

    private String ltbSqlExpress;

    private Integer ltbType;

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

    public String getLtbTables() {
        return ltbTables;
    }

    public void setLtbTables(String ltbTables) {
        this.ltbTables = ltbTables;
    }

    public String getLtbSqlExpress() {
        return ltbSqlExpress;
    }

    public void setLtbSqlExpress(String ltbSqlExpress) {
        this.ltbSqlExpress = ltbSqlExpress;
    }

    public Integer getLtbType() {
        return ltbType;
    }

    public void setLtbType(Integer ltbType) {
        this.ltbType = ltbType;
    }

    public String getLtbDesc() {
        return ltbDesc;
    }

    public void setLtbDesc(String ltbDesc) {
        this.ltbDesc = ltbDesc;
    }
}