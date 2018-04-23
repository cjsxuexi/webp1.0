package com.zrgj.servlet;

import java.sql.SQLException;

import com.zrgj.bean.User;
import com.zrgj.dao.UserDaoImpl;
import com.zrgj.exception.MySqlException;
import com.zrgj.servlet.in.Register;

public class Registerimp implements Register {
	
	private UserDaoImpl userdao = new UserDaoImpl();

	@Override
	public void addUser(User bean) throws SQLException {
		
		if(userdao.queryByName(bean.getUsername())==null){
			
			userdao.insert(bean);
		}
		else {
			throw new MySqlException("用户已经存在！");
		}
		

	}

	@Override
	public void getPassword() {
		
		

	}

}
