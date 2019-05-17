package com.erp4j.ssm.service.quality.monitor;

import com.erp4j.ssm.pojo.quality.monitor.UnqualifyApplyPojo;

public interface UnqulifyFindService {

    UnqualifyApplyPojo[] queryList(int page, int rows);
}
