package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.OpsTableColumn;
import com.yisutech.iisp.dataops.repository.pojo.OpsTableColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpsTableColumnMapper {
    long countByExample(OpsTableColumnExample example);

    int deleteByExample(OpsTableColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpsTableColumn record);

    int insertSelective(OpsTableColumn record);

    List<OpsTableColumn> selectByExample(OpsTableColumnExample example);

    OpsTableColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpsTableColumn record, @Param("example") OpsTableColumnExample example);

    int updateByExample(@Param("record") OpsTableColumn record, @Param("example") OpsTableColumnExample example);

    int updateByPrimaryKeySelective(OpsTableColumn record);

    int updateByPrimaryKey(OpsTableColumn record);
}