package com.zrgj.dao.in;

import java.util.Collections;
import java.util.List;

import com.zrgj.bean.Product;
import com.zrgj.exception.MySqlException;

public interface ProductInf {
	
	/**
	 * ��ѯ����������Ʒ
	 * @return	
	 */
	public List<Product> queryAllRroduct()throws MySqlException;
	
	/**
	 * ������Ʒ��Ų�ѯ��Ʒ
	 * @param pid	��Ʒ���
	 * @return	�оͷ��ظñ������Ӧ����Ʒ��û�оͷ���Collections.emptyList() 
	 */
	public Product queryByPid(int pid)throws MySqlException;
	
	/**
	 * ������Ʒ��ӵ��б���
	 * @param product	�������Ʒ
	 */
	public void insertProduct(Product product)throws MySqlException;
	
	/**
	 * ������Ʒ���ɾ����Ʒ
	 * @param pid	��Ʒ���
	 */
	public void deleteProduct(int pid);

}
