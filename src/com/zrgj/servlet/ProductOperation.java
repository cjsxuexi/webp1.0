package com.zrgj.servlet;

import java.util.List;

import com.zrgj.bean.Product;
import com.zrgj.dao.ProductDaoImpl;
import com.zrgj.exception.MySqlException;
import com.zrgj.servlet.in.ProductOperationIn;

public class ProductOperation implements ProductOperationIn {
	
	private ProductDaoImpl daoImpl = new ProductDaoImpl(); 

	@Override
	public List<Product> queryAll() throws MySqlException {
		
		return daoImpl.queryAllRroduct();
		
	}

	@Override
	public Product queryByPid(int pid) throws MySqlException {
		
		return daoImpl.queryByPid(pid);
	}

}
