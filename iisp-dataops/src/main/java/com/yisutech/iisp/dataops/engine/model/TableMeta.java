package com.yisutech.iisp.dataops.engine.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.model.TableMeta
 * <p>
 * 描述：
 * 数据表元信息
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:26
 **/
public class TableMeta implements Serializable {

    private static final long serialVersionUID = -3736347964219313753L;

    /**
     * 表名
     */
    @Getter
    @Setter
    String tableName;
    /**
     * 表字段meta信息
     */
    @Getter
    @Setter
    Map<String, ColumnMeta> columnsMeta;

}
