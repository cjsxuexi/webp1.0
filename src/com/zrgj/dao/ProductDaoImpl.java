package com.zrgj.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.zrgj.bean.Product;
import com.zrgj.dao.in.ProductInf;
import com.zrgj.exception.MySqlException;
import com.zrgj.util.DataSouceUtils;

/**
 * create table product(
	pid int primary key auto_increment,
	pname varchar(10),
	pricate decimal(10,2),
	introduce varchar(100),
	pno varchar(10));
 *
 */
public class ProductDaoImpl implements ProductInf {
	
	private QueryRunner query= new QueryRunner(DataSouceUtils.getDataSource()); 

	@Override
	public List<Product> queryAllRroduct() throws MySqlException {
		List<Product> list = null;
		String sql = "select pid,pname,pricate,introduce,pno from product";
		try {
			list = query.query(sql, new BeanListHandler<Product>(Product.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySqlException("系统繁忙，请稍后访问……");
		}
		return list;
	}

	@Override
	public Product queryByPid(int pid) throws MySqlException {
		Product product = null;
		String sql = "select pid,pname,pricate,introduce,pno from product where pid = ?";
		Object[] parm = {pid};
		try {
			product = query.query(sql, new BeanHandler<Product>(Product.class),parm);
		} catch (SQLException e) {
			throw new MySqlException("系统正在为你查找……");
		}
		return product;
	}

	@Override
	public void insertProduct(Product product) throws MySqlException {
		String sql = "insert into product(pid,pname,pricate,pno,introduce) value(?,?,?,?,?)";
		
		Object[] param = {product.getPid(),product.getPname(),
				product.getPricate(),product.getPno(),
				product.getIntroduce()};
		try {
			query.update(sql, param);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MySqlException("系统繁忙，请稍后……");
		}
		
	}
	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub

	}

}
