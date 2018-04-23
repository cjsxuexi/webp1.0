package com.zrgj.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrgj.bean.Car;
import com.zrgj.bean.CatItem;
import com.zrgj.bean.Product;
import com.zrgj.dao.ProductDaoImpl;
import com.zrgj.dao.in.ProductInf;
import com.zrgj.exception.MySqlException;

@WebServlet("/view/catServlrt")
public class CatServlrt extends HttpServlet {

	private static final long serialVersionUID = -8665083027780543944L;
	
	private ProductInf productDao = new ProductDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		
//		�ж��Ƿ���ڹ��ﳵ
		Car car = (Car) req.getSession().getAttribute("Car");
		if(car ==null){
//			�������ﳵ�������ﳵ�ŵ�session��
			req.getSession().setAttribute("Car",car = new Car());
		}
//		����Ʒ���빺�ﳵ
		String id = req.getParameter("id");
		try {
			Product product = productDao.queryByPid(Integer.parseInt(id));
			CatItem catItem = new CatItem();
			catItem.setProduct(product);
			car.setCatMap(catItem);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (MySqlException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/WEB-INF/p1.0/Cat.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
