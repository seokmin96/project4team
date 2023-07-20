package com.buttybutty.home.dto;

public class BoardDTO {
	private int mab_no;
	private int ma_num;
	private String m_userid;
	private String ma_name;
	private String mb_title;
	private String mb_content;
	private String mb_date;
	private int mb_hit;
	
	public int getMab_no() {
		return mab_no;
	}
	public void setMab_no(int mab_no) {
		this.mab_no = mab_no;
	}
	public int getMa_num() {
		return ma_num;
	}
	public void setMa_num(int ma_num) {
		this.ma_num = ma_num;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getMa_name() {
		return ma_name;
	}
	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}
	public String getMb_title() {
		return mb_title;
	}
	public void setMb_title(String mb_title) {
		this.mb_title = mb_title;
	}
	public String getMb_content() {
		return mb_content;
	}
	public void setMb_content(String mb_content) {
		this.mb_content = mb_content;
	}
	public String getMb_date() {
		return mb_date;
	}
	public void setMb_date(String mb_date) {
		this.mb_date = mb_date;
	}
	public int getMb_hit() {
		return mb_hit;
	}
	public void setMb_hit(int mb_hit) {
		this.mb_hit = mb_hit;
	}
}
