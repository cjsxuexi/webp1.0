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
//		获取商品列表
		try {
			products = prOp.queryAll();
		} catch (MySqlException e) {
			req.setAttribute("message", "系统繁忙，请稍后");
			req.getRequestDispatcher("/WEB-INF/p1.0/Error.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}
//		将信息传送到前端页面
		req.setAttribute("Products", products);
		req.getRequestDispatcher("/WEB-INF/p1.0/Product.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
