package com.zrgj.servlet.in;

import java.sql.SQLException;

import com.zrgj.bean.User;

public interface Register {
	
//	�鿴�û����Ƿ���ڣ������ھ�����û�
	public void addUser(User bean) throws SQLException ;
	
//	��ѯ����
	public void getPassword();

}
