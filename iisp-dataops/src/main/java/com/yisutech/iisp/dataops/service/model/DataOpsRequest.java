package com.yisutech.iisp.dataops.service.model;

import com.google.common.collect.Lists;
import com.yisutech.iisp.toolkit.utils.ValidUtil;
import org.apache.commons.lang3.tuple.Pair;

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
     * 查询字段列表
     * ps :
     * 为空，则返回所有字段信息；
     * 非空，返回指定字段信息；
     */
    List<String> queryColumns = Lists.newArrayList();
    /**
     * 操作字段及值集合
     * ps:
     * 写入记录时，为写入记录信息
     * 对象: <columnName, value>
     */
    List<Pair<String, Object>> columnValues = Lists.newArrayList();
    /**
     * 条件字段及值集合
     * ps:
     * 做查询，更新记录时条件
     * 对象: <columnName, value>
     */
    List<Pair<String, Object>> whereColumnValues = Lists.newArrayList();
    /**
     * 当前页面
     */
    int currentPage = 1;
    /**
     * 页面记录数
     */
    int pageSize = 20;

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

    public List<Pair<String, Object>> getColumnValues() {
        return columnValues;
    }

    public void setColumnValues(List<Pair<String, Object>> columnValues) {
        this.columnValues = columnValues;
    }

    public List<Pair<String, Object>> getWhereColumnValues() {
        return whereColumnValues;
    }

    public void setWhereColumnValues(List<Pair<String, Object>> whereColumnValues) {
        this.whereColumnValues = whereColumnValues;
    }

    public List<String> getQueryColumns() {
        return queryColumns;
    }

    public void setQueryColumns(List<String> queryColumns) {
        this.queryColumns = queryColumns;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
