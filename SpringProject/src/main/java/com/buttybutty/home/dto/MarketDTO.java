package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class MarketDTO {
	private int ma_num; //���� �Ϸù�ȣ
	private String ma_name; //�����̸�
	private String ma_addr1; //��_��
	private String ma_addr2; //��_��
	private String ma_time; //�����ֱ�
	private int ma_count; //������
	private String ma_item; //���ǰ��
	private int ma_toilet; //����ȭ��� �������� (1:����, 0:�̺���)
	private int ma_parking; //������ �������� (����)
}
