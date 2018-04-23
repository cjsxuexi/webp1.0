package com.zrgj.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.bean.Product;
import com.zrgj.exception.MySqlException;
import com.zrgj.servlet.ProductOperation;
import com.zrgj.servlet.in.ProductOperationIn;

@WebServlet("/view/productServlet")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 2848914086650003755L;
	
	private ProductOperationIn prOp = new ProductOperation();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		List<Product> products = null;
//		��ȡ��Ʒ�б�
		try {
			products = prOp.queryAll();
		} catch (MySqlException e) {
			req.setAttribute("message", "ϵͳ��æ�����Ժ�");
			req.getRequestDispatcher("/WEB-INF/p1.0/Error.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}
//		����Ϣ���͵�ǰ��ҳ��
		req.setAttribute("Products", products);
		req.getRequestDispatcher("/WEB-INF/p1.0/Product.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
