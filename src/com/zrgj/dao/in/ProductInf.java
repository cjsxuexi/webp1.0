package com.zrgj.dao.in;

import java.util.Collections;
import java.util.List;

import com.zrgj.bean.Product;
import com.zrgj.exception.MySqlException;

public interface ProductInf {
	
	/**
	 * 查询表中所有商品
	 * @return	
	 */
	public List<Product> queryAllRroduct()throws MySqlException;
	
	/**
	 * 根据商品编号查询商品
	 * @param pid	商品编号
	 * @return	有就返回该编号所对应的商品，没有就返回Collections.emptyList() 
	 */
	public Product queryByPid(int pid)throws MySqlException;
	
	/**
	 * 将待商品添加到列表中
	 * @param product	待添加商品
	 */
	public void insertProduct(Product product)throws MySqlException;
	
	/**
	 * 根据商品编号删除商品
	 * @param pid	商品编号
	 */
	public void deleteProduct(int pid);

}
