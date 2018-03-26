package com.yisutech.iisp.dataops.engine.template.model;

import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    String columnName;
    /**
     * 类型
     */
    @Getter
    @Setter
    ColumnType type;
    /**
     * 长度
     */
    @Getter
    @Setter
    int size;
    /**
     * 是否主键
     */
    @Getter
    @Setter
    boolean primaryKey;
    /**
     * 默认值
     */
    @Getter
    @Setter
    String defaultValue;
    /**
     * 是否允许为空
     */
    @Getter
    @Setter
    boolean tagNull;

    enum ColumnType {
        String, Date, DateTime, Text;
    }

}
