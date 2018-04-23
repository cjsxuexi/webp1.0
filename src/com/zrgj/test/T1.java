package com.zrgj.test;

import java.math.BigDecimal;

import org.junit.Test;

import com.zrgj.bean.Product;
import com.zrgj.dao.ProductDaoImpl;
import com.zrgj.exception.MySqlException;


public class T1 {
	
	private ProductDaoImpl daoImpl= new ProductDaoImpl(); 
	/*@Test
	public void testinsert(){
		Product p1 = new Product(1,"tomcat",new BigDecimal("70"),"b002","tomcat秘籍"),
				p3 = new Product(2,"java",new BigDecimal("170"),"b001","java秘籍"),
				p4 = new Product(3,"童话故事",new BigDecimal("20"),"b003","诱拐小萝莉秘籍"),
				p2 = new Product(4,"水杯",new BigDecimal("7"),"t001","日常生活用品"),
				p5 = new Product(5,"充气娃娃",new BigDecimal("700"),"p001","宅男必需品");
		try {
			daoImpl.insertProduct(p1);
			daoImpl.insertProduct(p2);
			daoImpl.insertProduct(p3);
			daoImpl.insertProduct(p4);
			daoImpl.insertProduct(p5);
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void testqueryall(){
		try {
			System.out.println(daoImpl.queryAllRroduct());
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
