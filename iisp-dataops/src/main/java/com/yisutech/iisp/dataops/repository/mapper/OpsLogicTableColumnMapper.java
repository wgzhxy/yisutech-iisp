package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTableColumn;
import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTableColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpsLogicTableColumnMapper {
    long countByExample(OpsLogicTableColumnExample example);

    int deleteByExample(OpsLogicTableColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpsLogicTableColumn record);

    int insertSelective(OpsLogicTableColumn record);

    List<OpsLogicTableColumn> selectByExample(OpsLogicTableColumnExample example);

    OpsLogicTableColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpsLogicTableColumn record, @Param("example") OpsLogicTableColumnExample example);

    int updateByExample(@Param("record") OpsLogicTableColumn record, @Param("example") OpsLogicTableColumnExample example);

    int updateByPrimaryKeySelective(OpsLogicTableColumn record);

    int updateByPrimaryKey(OpsLogicTableColumn record);
}