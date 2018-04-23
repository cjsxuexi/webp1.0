package com.zrgj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zrgj.bean.User;
import com.zrgj.util.DataSouceUtils;


/**
 * @author dsgzao
 *
create table webbean(
		 id int primary key auto_increment,
		 username varchar(5),
		 password varchar(15),
		 sex int(1),
		 birthday varchar(20),
		 hobby varchar(10),
		 education varchar(20));
 *
 *
 */
public class UserDaoImpl {
	
	private QueryRunner qRunner = new QueryRunner(DataSouceUtils.getDataSource());
	
	/**
	 * 向webBean表中添加user信息
	 * @param user添加的用户信息
	 * @throws SQLException
	 */
	public void  insert(User user) throws SQLException {
		
		String sql = "insert into  webBean(username,password,six,birthday,"
				+ "hobby,education) values(?,?,?,?,?,?) ";
		
		Object[] param = new Object[]{user.getUsername(),user.getPassword(),
			user.getSex(),user.getBirthday(),user.getHobby(),user.getEducation()};
		
		qRunner.update(sql, param);
	}
	
	/**
	 * 查询所有用户信息
	 * @return ArrayList<WebBean>形式的所有用户信息
	 * @throws SQLException
	 */
	public ArrayList<User> queryAll() throws SQLException{
		
		String sql = "select username,password,six,birthday,hobby,education from webBean";
		
		ArrayList<User> result = (ArrayList<User>) qRunner.query(sql,new BeanListHandler<User>(User.class));		
				
		return result;
	}
	
	public User queryById(int id){
		
		String sql = "select username,password,six,birthday,hobby,education from webBean where id = ?";
		
		Object[] param = new Object[]{id};
		
		try {
			User uBean = qRunner.query(sql, new BeanHandler<User>(User.class), param);
			
			return uBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 根据用户名找回密码
	 * @param name 用户名
	 * @return 用户信息
	 */
	public User queryByName(String name){
			
			String sql = "select username,password,six,birthday,hobby,education from webBean where username = ?";
			
			Object[] param = new Object[]{name};
			
			try {
				User uBean = qRunner.query(sql, new BeanHandler<User>(User.class), param);
				
				return uBean;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	
	public boolean queryExist(String name,String password){
			
			String sql = "select username,password,six,birthday,hobby,education "
					+ "from webBean where username = ? and password = ?";
			boolean result = false;
			
			Object[] param = new Object[]{name,password};
			
			try {
				User uBean = qRunner.query(sql, new BeanHandler<User>(User.class), param);
				
				if(uBean != null&& !uBean.equals("")){
					result = true;
					return result;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
	

}

