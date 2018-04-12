package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.OpsDataSource;
import com.yisutech.iisp.dataops.repository.pojo.OpsDataSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpsDataSourceMapper {
    long countByExample(OpsDataSourceExample example);

    int deleteByExample(OpsDataSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OpsDataSource record);

    int insertSelective(OpsDataSource record);

    List<OpsDataSource> selectByExampleWithBLOBs(OpsDataSourceExample example);

    List<OpsDataSource> selectByExample(OpsDataSourceExample example);

    OpsDataSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OpsDataSource record, @Param("example") OpsDataSourceExample example);

    int updateByExampleWithBLOBs(@Param("record") OpsDataSource record, @Param("example") OpsDataSourceExample example);

    int updateByExample(@Param("record") OpsDataSource record, @Param("example") OpsDataSourceExample example);

    int updateByPrimaryKeySelective(OpsDataSource record);

    int updateByPrimaryKeyWithBLOBs(OpsDataSource record);

    int updateByPrimaryKey(OpsDataSource record);
}