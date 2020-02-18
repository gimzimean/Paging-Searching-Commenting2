package com.pgm.bbs.dto;

public class Criteria {
	private int page;
	private int perPageNum;
	private String type;
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return keyword;
	}

	private String keyword;
	
	public Criteria() {
		this.page=1;
		this.perPageNum=10;
	
	}
	public Criteria(int page, int perPageNum) {
		this.page=page;
		this.perPageNum=perPageNum;
	}
	
	public String[] getTypeArr() {
		return type==null? new String[]{}:type.split("");
	}
	
	public void setPage(int page) {
		if(page<=0) {
			this.page=1;
			return;
		}
		this.page=page;
	}
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100) {
			this.perPageNum=10;
			return;
		}
		this.perPageNum=perPageNum;
	}
	public int getPage() {
		return page;
	}
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
