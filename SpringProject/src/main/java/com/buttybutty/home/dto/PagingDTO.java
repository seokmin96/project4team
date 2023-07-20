package com.buttybutty.home.dto;

//페이지 관련 변수, 검색어 관련 변수
public class PagingDTO {
		private int nowPage = 1; //현재 페이지(기본값 : 1페이지)
		private int onePageRecord = 10; //한 페이지에 표시할 레코드 개수(10개씩 설정)
		private int totalRecord; //총 레코드 개수
		private int totalPage; // 총 페이지 개수
	
		private int onePageNumCount = 10; //한 페이지에 표시되는 페이지 번호 개수(10개씩 설정)
		private int startPageNum = 1; // 페이지에서 표시되는 시작페이지 번호
	
		private int lastPageRecord = 10;//마지막 페이지의 남아있는 레코드 수(기본값 10개로 설정)

		private String searchKey; //검색키
		private String searchWord; //검색어
	
		public int getNowPage() {
				return nowPage;
		}
		public void setNowPage(int nowPage) {
				this.nowPage = nowPage;
		
				//페이지의 시작 페이지번호 생성하기 
				startPageNum = ((nowPage-1)/onePageNumCount)*onePageNumCount + 1;
		}
		public int getOnePageRecord() {
				return onePageRecord;
		}
		public void setOnePageRecord(int onePageRecord) {
				this.onePageRecord = onePageRecord;
		}
		public int getTotalRecord() {
				return totalRecord;
		}
		public void setTotalRecord(int totalRecord) {
				this.totalRecord = totalRecord;
				
				//총 페이지 개수 계산하기 (ex. 16 -> 4페이지, 15 -> 3페이지, 11 -> 3페이지)
				totalPage = (int)Math.ceil((double)totalRecord/onePageRecord);
				//마지막페이지의 남은 레코드 수 계산하기
				lastPageRecord = onePageRecord; //마지막페이지가 아니면 5개
				if(totalPage == nowPage) { //마지막페이지이면
						if(totalRecord%onePageRecord != 0) { //총 레코드 수가 5의 배수가 아니라면
								lastPageRecord = totalRecord % onePageRecord; //1,2,3,4 중 하나
						}
				}
				System.out.println("lastPageRecord =>" + lastPageRecord);
		}
		public int getTotalPage() {
				return totalPage;
		}
		public void setTotalPage(int totalPage) {
				this.totalPage = totalPage;
		}
		public int getOnePageNumCount() {
				return onePageNumCount;
		}
		public void setOnePageNumCount(int onePageNumCount) {
				this.onePageNumCount = onePageNumCount;
		}
		public int getStartPageNum() {
				return startPageNum;
		}
		public void setStartPageNum(int startPageNum) {
				this.startPageNum = startPageNum;
		}
		public int getLastPageRecord() {
				return lastPageRecord;
		}
		public void setLastPageRecord(int lastPageRecord) {
				this.lastPageRecord = lastPageRecord;
		}
		public String getSearchKey() {
				return searchKey;
		}
		public void setSearchKey(String searchKey) {
				this.searchKey = searchKey;
		}
		public String getSearchWord() {
				return searchWord;
		}
		public void setSearchWord(String searchWord) {
				this.searchWord = searchWord;
		}
}