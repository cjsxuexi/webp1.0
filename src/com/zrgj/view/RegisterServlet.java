package com.zrgj.view;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.zrgj.bean.User;
import com.zrgj.convertor.ArrayConvert;
import com.zrgj.item.UserFromBean;
import com.zrgj.servlet.Registerimp;


@WebServlet("/service/register")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6101994754141552445L; 
	
	private Registerimp  registerimp = new Registerimp();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		1.0、解决中文乱码问题
		req.setCharacterEncoding("UTF-8");
//		1、获取信息
		UserFromBean userbean = putWebMessageToBean(req, UserFromBean.class);
//		判断信息是否存在且正常
//		2、不正常结束，提示错误
		if(!userbean.getErrorsMap().isEmpty()){
			req.setAttribute("UserBean", userbean);
			req.getRequestDispatcher("/WEB-INF/p1.0/Register.jsp").forward(req, resp);
			return;
		}
//		3.0、 将信息转换为User格式
		User user = new User();
		try {
			ConvertUtils.register(new ArrayConvert(), String.class);
			BeanUtils.copyProperties(user, userbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		3、将信息存入数据库
		try {
			registerimp.addUser(user);
			
			resp.sendRedirect(req.getContextPath()+"/index.jsp");
			
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		4、跳转到登入页面
		req.setAttribute("UserBean", userbean);
		req.getRequestDispatcher("/WEB-INF/p1.0/Register.jsp").forward(req, resp);
	}


	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	/**
	 * 将web页面信息输入到user对象中,返回user对象
	 * @param req
	 * @param user
	 * @return 
	 */

	private <T> T putWebMessageToBean(HttpServletRequest req, Class<T> clazz) {
		
		
		try {
			T user = clazz.newInstance();
			BeanUtils.populate(user, req.getParameterMap());
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
