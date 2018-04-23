package com.zrgj.servlet.in;

import java.util.List;

import com.zrgj.bean.Product;
import com.zrgj.exception.MySqlException;

public interface ProductOperationIn {
	
	/**
	 * ��ѯproduct������������
	 * @return
	 */
	public List<Product> queryAll()throws MySqlException;
	
	/**
	 * ������Ʒ��Ų�ѯ��Ʒ��Ϣ
	 * @param pid	��Ʒ���
	 * @return
	 */
	public Product queryByPid(int pid)throws MySqlException;

}
