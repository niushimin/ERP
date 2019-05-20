package com.erp4j.ssm.util;

import com.erp4j.ssm.actionform.quality.monitor.ResponseStatus;

public class ResponseUtil {

    public static ResponseStatus getResponseStatus(String msg,String status) {
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setMsg(msg);
        responseStatus.setStatus(status);
        return responseStatus;
    }
}
