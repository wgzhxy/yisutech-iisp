package com.yisutech.iisp.dataops.engine.template.model;

import com.yisutech.iisp.toolkit.utils.ValidUtil;
import org.apache.commons.lang3.tuple.MutablePair;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.model.ColumnMeta
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:27
 **/
public class ColumnMeta implements Serializable {

    private static final long serialVersionUID = 65462900089386881L;

    /**
     * 字段名称
     */
    @NotNull(message = "columnName is empty")
    String columnName;
    /**
     * 类型
     */
    @NotNull(message = "type is null")
    ColumnType type;
    /**
     * 长度
     */
    int size;
    /**
     * 是否主键
     */
    boolean primaryKey;
    /**
     * 默认值
     */
    String defaultValue;
    /**
     * 是否允许为空
     */
    boolean tagNull;

    public boolean valid() {
        MutablePair pair = ValidUtil.fastValid(this);
        if (pair == null) {
            return true;
        } else {
            return false;
        }
    }

    enum ColumnType {
        String, Date, DateTime, Text, Int, Long, Varchar;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isTagNull() {
        return tagNull;
    }

    public void setTagNull(boolean tagNull) {
        this.tagNull = tagNull;
    }
}
