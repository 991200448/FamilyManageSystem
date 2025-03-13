package com.daisypig.common.api.dto;

import java.io.Serializable;
import java.util.List;



public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 总记录数
	 */
	private long total = 0;

	/**
	 * 当前页的数据列表
	 */
	private List<T> data;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public PageResult(long total, List<T> data) {
		this.total = total;
		this.data = data;
	}

}
