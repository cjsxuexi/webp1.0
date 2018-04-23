package com.zrgj.servlet.in;

import java.sql.SQLException;

import com.zrgj.bean.User;

public interface Register {
	
//	查看用户名是否存在，不存在就添加用户
	public void addUser(User bean) throws SQLException ;
	
//	查询密码
	public void getPassword();

}
