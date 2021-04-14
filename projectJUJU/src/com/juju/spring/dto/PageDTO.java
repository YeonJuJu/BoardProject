package com.juju.spring.dto;

import lombok.Getter;

@Getter
public class PageDTO {
	
	//최소, 최대 페이지 번호
	private int min;
	private int max;
	
	//이전 페이지 번호
	private int prePage;
	
	//다음 페이지 번호
	private int nextPage;
	
	//현재 페이지 번호
	private int currentPage;
	
	//전체 페이지 개수
	private int pageCount;
	
	public PageDTO(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
	
		this.currentPage = currentPage;
		
		this.pageCount = contentCnt/contentPageCnt;
		if(contentCnt%contentPageCnt != 0)
			this.pageCount++;
		
		this.min = ((currentPage - 1) / contentPageCnt) * contentPageCnt + 1;
		this.max = min + paginationCnt - 1;
		
		if(max > pageCount) {
			max = pageCount;
		}
		
		prePage = min-1;
		nextPage = max+1;
		
		if(nextPage > pageCount) {
			nextPage=pageCount;
		}
	}
}
