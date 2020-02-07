package org.spring.dto;

public class PageDTO {
	private int curPage=1; //현재페이지
	private int perPage=5; //한페이지의 게시물 수
	private int perBlock=3; //페이지 블럭의 수
	private int totPage; //전체페이지 수
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	private int startNo; //시작번호
	private int endNo; //끝번호
	
	private String searchKey; //검색키
	private String searchValue; //검색값
	public PageDTO() {
		super();
	}
	public PageDTO(int curPage, int perPage, int perBlock, int totPage, int startPage, int endPage, int startNo,
			int endNo, String searchKey, String searchValue) {
		super();
		this.curPage = curPage;
		this.perPage = perPage;
		this.perBlock = perBlock;
		this.totPage = totPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startNo = startNo;
		this.endNo = endNo;
		this.searchKey = searchKey;
		this.searchValue = searchValue;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	@Override
	public String toString() {
		return "PageDTO [curPage=" + curPage + ", perPage=" + perPage + ", perBlock=" + perBlock + ", totPage="
				+ totPage + ", startPage=" + startPage + ", endPage=" + endPage + ", startNo=" + startNo + ", endNo="
				+ endNo + ", searchKey=" + searchKey + ", searchValue=" + searchValue + "]";
	}
	
	

}
