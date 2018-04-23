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
//		1������diskFileFactory��������ȡ����FileItem��һ������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//ָ�����ڴ��л������ݴ�С,��λΪbyte,������Ϊ1Mb   
        factory.setSizeThreshold(1 * 1024 * 1024);   
        //����һ���ļ���С����getSizeThreshold()��ֵʱ���ݴ����Ӳ�̵�Ŀ¼   
        factory.setRepository(new File("F:\new")); 
//		2���ṩ�˹�����ȡserveletFileUpload���󣬾����������������ļ����ϴ�
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		
//		3���ж��ϴ���������
		if(!ServletFileUpload.isMultipartContent(req)){
			req.setAttribute("message", "�˱������ļ��ϴ����͵ı�");
			req.getRequestDispatcher("/WEB-INF/p1.0/Error.jsp").forward(req, resp);
			return;
		}
		try {
			List<FileItem> fileItems = fileUpload.parseRequest(req);
			
			if(fileItems!=null && fileItems.size()>0){
				for(FileItem item :fileItems){
//					5�����ȥ�жϴ�item������ʲô���͵���������
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
