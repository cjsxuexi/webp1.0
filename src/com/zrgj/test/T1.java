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
		Product p1 = new Product(1,"tomcat",new BigDecimal("70"),"b002","tomcat�ؼ�"),
				p3 = new Product(2,"java",new BigDecimal("170"),"b001","java�ؼ�"),
				p4 = new Product(3,"ͯ������",new BigDecimal("20"),"b003","�չ�С�����ؼ�"),
				p2 = new Product(4,"ˮ��",new BigDecimal("7"),"t001","�ճ�������Ʒ"),
				p5 = new Product(5,"��������",new BigDecimal("700"),"p001","լ�б���Ʒ");
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
