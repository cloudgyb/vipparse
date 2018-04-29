package com.gyb.iqiyi.pojo;

import java.util.List;

public class PageInfo<T> {
	private int currPageNum;
	private int total;
	private int totalPage;
	private int pageSize;
	private List<T> data;
	public int getCurrPageNum() {
		return currPageNum;
	}
	public void setCurrPageNum(int currPageNum) {
		this.currPageNum = currPageNum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
