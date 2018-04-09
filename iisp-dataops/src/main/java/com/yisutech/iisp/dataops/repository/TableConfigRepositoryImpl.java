package com.yisutech.iisp.dataops.repository;

import com.yisutech.iisp.dataops.repository.TableConfigRepository;
import com.yisutech.iisp.dataops.repository.mapper.*;
import com.yisutech.iisp.dataops.repository.pojo.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.repository.TableConfigRepositoryImpl
 * 描述：
 * <p>
 * 表元信息查询
 *
 * @author guangzhong.wgz
 * @create 2018-04-08 下午7:10
 **/
@Repository
public class TableConfigRepositoryImpl implements TableConfigRepository {

    @Override
    public OpsLogicTable queryLogicTable(String tableCode) {

        // 查询逻辑表
        Assert.isTrue(StringUtils.isNotBlank(tableCode), "tableCode is null");
        OpsLogicTable opsLogicTable = opsLogicTableMapper.selectByPrimaryKey(Integer.valueOf(tableCode));

        Assert.notNull(opsLogicTable, String.format("LogicTable %s is not exists", tableCode));
        return opsLogicTable;
    }

    @Override
    public List<OpsLogicTableColumn> queryLogicTableColumn(String tableCode) {

        // 查询逻辑表字段
        Assert.isTrue(StringUtils.isNotBlank(tableCode), "tableCode is null");

        OpsLogicTableColumnExample example = new OpsLogicTableColumnExample();
        example.createCriteria().andLfdTbIdEqualTo(tableCode);

        return opsLogicTableColumnMapper.selectByExample(example);
    }

    @Override
    public OpsTable queryTable(String tableCode) {

        Assert.isTrue(StringUtils.isNotBlank(tableCode), "tableCode is null");

        return opsTableMapper.selectByPrimaryKey(Integer.valueOf(tableCode));
    }

    @Override
    public List<OpsTableColumn> queryTableColumn(String tableCode) {

        Assert.isTrue(StringUtils.isNotBlank(tableCode), "tableCode is null");

        OpsTableColumnExample example = new OpsTableColumnExample();
        example.createCriteria().andIdEqualTo(Integer.valueOf(tableCode));

        return opsTableColumnMapper.selectByExample(example);
    }

    @Override
    public OpsDataSource queryDataSource(String dataSourceId) {
        Assert.isTrue(StringUtils.isNotBlank(dataSourceId), "dataSourceId is null");
        return opsDataSourceMapper.selectByPrimaryKey(Integer.valueOf(dataSourceId));
    }

    @Setter
    @Getter
    @Resource
    private OpsTableMapper opsTableMapper;
    @Setter
    @Getter
    @Resource
    private OpsDataSourceMapper opsDataSourceMapper;
    @Setter
    @Getter
    @Resource
    private OpsTableColumnMapper opsTableColumnMapper;
    @Setter
    @Getter
    @Resource
    private OpsLogicTableMapper opsLogicTableMapper;
    @Setter
    @Getter
    @Resource
    private OpsLogicTableColumnMapper opsLogicTableColumnMapper;
}
