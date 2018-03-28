package com.yisutech.iisp.dataops.service.model;

import com.google.common.collect.Lists;
import com.yisutech.iisp.toolkit.utils.ValidUtil;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.model.DataOpsRequest
 * 描述：
 * <p>
 * 数据操作请求
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午2:19
 **/
public class DataOpsRequest implements Serializable {

    private static final long serialVersionUID = -2213606069999775496L;

    /**
     * 表编码
     */
    @NotEmpty
    String tableCode;
    /**
     * 表名称
     */
    @NotEmpty
    String tableName;
    /**
     * 操作字段列表
     */
    List<String> columns = Lists.newArrayList();

    public Map<String, String> valid() {
        return ValidUtil.allValid(this);
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
