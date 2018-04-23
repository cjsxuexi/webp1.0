package com.zrgj.servlet.in;

import java.util.List;

import com.zrgj.bean.Product;
import com.zrgj.exception.MySqlException;

public interface ProductOperationIn {
	
	/**
	 * 查询product表中所有数据
	 * @return
	 */
	public List<Product> queryAll()throws MySqlException;
	
	/**
	 * 根据商品编号查询商品信息
	 * @param pid	商品编号
	 * @return
	 */
	public Product queryByPid(int pid)throws MySqlException;

}
