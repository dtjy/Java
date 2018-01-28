/*
 *******************************************************************************
 * @FileName	PageBean.java
 * @package		com.jy.domain
 * @author		jiangyao
 * @Date		2018年1月29日 上午2:26:07
 * @description 
 *******************************************************************************
 */
package com.jy.domain;

import java.util.List;

/**
 * 分页封装类
 ******************************************
 * @author jiangyao  [2018年1月29日 上午2:26:07]
 ******************************************
 */
public class PageBean<T> {
	
	//当前页数
	private int currPage;
	//每页记录数
	private int pageSize;
	//总记录数
	private int totalCount;
	//总页数
	private int toatlPage;
	//每页显示数据
	private List<T> list;
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getToatlPage() {
		return toatlPage;
	}
	public void setToatlPage(int toatlPage) {
		this.toatlPage = toatlPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
