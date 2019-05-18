package com.erp4j.ssm.actionform.quality.monitor;

import java.util.List;

/**
 * Created by little Stone
 * Date 2019/5/18 Time 9:54
 */
public class ResponseVo<T> {
	List<T> rows;
	int total;

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
