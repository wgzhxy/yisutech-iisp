package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTable;
import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpsLogicTableMapper {
    long countByExample(OpsLogicTableExample example);

    int deleteByExample(OpsLogicTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpsLogicTable record);

    int insertSelective(OpsLogicTable record);

    List<OpsLogicTable> selectByExample(OpsLogicTableExample example);

    OpsLogicTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpsLogicTable record, @Param("example") OpsLogicTableExample example);

    int updateByExample(@Param("record") OpsLogicTable record, @Param("example") OpsLogicTableExample example);

    int updateByPrimaryKeySelective(OpsLogicTable record);

    int updateByPrimaryKey(OpsLogicTable record);
}