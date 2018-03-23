package com.yisutech.iisp.dataops.repository.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OpsDataSource {

    private Integer id;

    @NotEmpty(message = "数据库连接url不能为空")
    @Size(min = 1, max = 256, message = "数据库连接url不能超过128字符")
    private String dsUrl;

    @NotEmpty(message = "数据库用户名不能为空")
    @Size(min = 1, max = 64, message = "数据库用户名不能超过64字符")
    private String dsUser;

    @NotEmpty(message = "数据库密码不能为空")
    @Size(min = 1, max = 64, message = "数据库密码不能超过64字符")
    private String dsPassword;

    @NotEmpty(message = "数据库名不能为空")
    @Size(min=1, max = 64, message = "数据库名不能超过64字符")
    private String dsName;

    @Max(value = 256, message = "数据库描述不能超过256字符")
    private String dsDesc;

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
}