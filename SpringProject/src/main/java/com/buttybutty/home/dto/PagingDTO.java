package com.buttybutty.home.dto;

//������ ���� ����, �˻��� ���� ����
public class PagingDTO {
		private int nowPage = 1; //���� ������(�⺻�� : 1������)
		private int onePageRecord = 10; //�� �������� ǥ���� ���ڵ� ����(10���� ����)
		private int totalRecord; //�� ���ڵ� ����
		private int totalPage; // �� ������ ����
	
		private int onePageNumCount = 10; //�� �������� ǥ�õǴ� ������ ��ȣ ����(10���� ����)
		private int startPageNum = 1; // ���������� ǥ�õǴ� ���������� ��ȣ
	
		private int lastPageRecord = 10;//������ �������� �����ִ� ���ڵ� ��(�⺻�� 10���� ����)

		private String searchKey; //�˻�Ű
		private String searchWord; //�˻���
	
		public int getNowPage() {
				return nowPage;
		}
		public void setNowPage(int nowPage) {
				this.nowPage = nowPage;
		
				//�������� ���� ��������ȣ �����ϱ� 
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
				
				//�� ������ ���� ����ϱ� (ex. 16 -> 4������, 15 -> 3������, 11 -> 3������)
				totalPage = (int)Math.ceil((double)totalRecord/onePageRecord);
				//�������������� ���� ���ڵ� �� ����ϱ�
				lastPageRecord = onePageRecord; //�������������� �ƴϸ� 5��
				if(totalPage == nowPage) { //�������������̸�
						if(totalRecord%onePageRecord != 0) { //�� ���ڵ� ���� 5�� ����� �ƴ϶��
								lastPageRecord = totalRecord % onePageRecord; //1,2,3,4 �� �ϳ�
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