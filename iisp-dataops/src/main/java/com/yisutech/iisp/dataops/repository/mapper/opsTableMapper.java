package com.yisutech.iisp.dataops.repository.mapper;

import com.yisutech.iisp.dataops.repository.pojo.opsTable;
import com.yisutech.iisp.dataops.repository.pojo.opsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface opsTableMapper {
    long countByExample(opsTableExample example);

    int deleteByExample(opsTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(opsTable record);

    int insertSelective(opsTable record);

    List<opsTable> selectByExample(opsTableExample example);

    opsTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") opsTable record, @Param("example") opsTableExample example);

    int updateByExample(@Param("record") opsTable record, @Param("example") opsTableExample example);

    int updateByPrimaryKeySelective(opsTable record);

    int updateByPrimaryKey(opsTable record);
}