package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.OpsTable;
import com.yisutech.iisp.dataops.repository.pojo.OpsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpsTableMapper {
    long countByExample(OpsTableExample example);

    int deleteByExample(OpsTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpsTable record);

    int insertSelective(OpsTable record);

    List<OpsTable> selectByExample(OpsTableExample example);

    OpsTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpsTable record, @Param("example") OpsTableExample example);

    int updateByExample(@Param("record") OpsTable record, @Param("example") OpsTableExample example);

    int updateByPrimaryKeySelective(OpsTable record);

    int updateByPrimaryKey(OpsTable record);
}