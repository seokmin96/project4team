package com.buttybutty.home.dao;

import com.buttybutty.home.dto.RegisterMerchantDTO;
import com.buttybutty.home.dto.RegisterUsersDTO;

public interface RegisterDAO {
	
	public int usersInsert(RegisterUsersDTO dto); //����ȸ�� ȸ������
	public int merchantInsert(RegisterMerchantDTO dto); //������� ȸ������
	
	public RegisterUsersDTO usersSelect(String userid, String userpwd); //����ȸ�� �α���, ȸ������ ��й�ȣ Ȯ��
	public RegisterMerchantDTO merchantSelect(String m_userid, String m_userpwd); //������� �α���
	
	public int usersUpdate(RegisterUsersDTO dto); //����ȸ�� ȸ������
	public int merchantUpdate(RegisterMerchantDTO dto); //������� ȸ������
	
	public RegisterUsersDTO usersIdSearch(RegisterUsersDTO dto); //����ȸ�� ���̵�ã��
	public RegisterMerchantDTO merchantIdSearch(RegisterMerchantDTO dto); //������� ���̵�ã��
	
	public RegisterUsersDTO usersPwdSearch(RegisterUsersDTO dto); //����ȸ�� ���̵�ã��
	public RegisterMerchantDTO merchantPwdSearch(RegisterMerchantDTO dto); //������� ���̵�ã��
}
