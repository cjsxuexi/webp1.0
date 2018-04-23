package com.zrgj.view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/personInformation")
public class PersonInformation extends HttpServlet{

	private static final long serialVersionUID = -4882851074548535441L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(ServletFileUpload.isMultipartContent(req));
//		1、创建diskFileFactory工厂，获取解析FileItem的一个工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//指定在内存中缓存数据大小,单位为byte,这里设为1Mb   
        factory.setSizeThreshold(1 * 1024 * 1024);   
        //设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录   
        factory.setRepository(new File("F:\new")); 
//		2、提供此工厂获取serveletFileUpload对象，就是这个对象完成了文件的上传
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
//		3、判断上传表达的类型
		if(!ServletFileUpload.isMultipartContent(req)){
			req.setAttribute("message", "此表单不是文件上传类型的表单");
			req.getRequestDispatcher("/WEB-INF/p1.0/Error.jsp").forward(req, resp);
			return;
		}
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			
			if(fileItems!=null && fileItems.size()>0){
				for(FileItem item :fileItems){
//					5、如何去判断此item到底是什么类型的输入域呢
					if(item.isFormField()){
						System.out.println(item.getString("name"));
					}else{
						
					}
				}
				
			}
		
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	
}
