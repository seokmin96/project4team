package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int mab_no; //�ڷ�� �Ϸù�ȣ
	private int ma_num; //���� �Ϸù�ȣ
	private String m_userid; //���� ���̵�
	private String ma_name; //���� �̸�
	private String mb_title; //�ڷ�� ������
	private String mb_content; //�ڷ�� �۳���
	private String mb_date; //�ڷ�� �۵����
	private int mb_hit; //�ڷ�� ����ȸ��
}
