package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;

public interface UnqulifyFindService {

    UnqualifyApplyPojo[] queryUnqulifyApplyAll(int page, int rows);
}
