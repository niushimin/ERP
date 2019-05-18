package com.erp4j.ssm.mapper.quality.monitor;

import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnqualifyMapper {

    UnqualifyApplyPojo[] queryUnqulifyApplyAll(@Param("page") int page, @Param("page") int rows);
}
