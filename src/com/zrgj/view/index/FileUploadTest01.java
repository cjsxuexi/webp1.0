package com.zrgj.view.index;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/servlet/fileUploadTest01")
public class FileUploadTest01 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// ������ʱĿ¼
		//factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));
		
		// 2��ͨ��������ȡServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 3���жϴ˱������������ǲ���multipart/form-data
		if(!ServletFileUpload.isMultipartContent(request)){
			return;
		}
		
		// ��������ϴ��ļ�����������������
		upload.setHeaderEncoding("UTF-8");
		
		// ���õ����ļ��Ĵ�С
		//upload.setFileSizeMax(1024);
		
		// �����ļ��ϴ��Ľ���
		upload.setProgressListener(new ProgressListener() {
			
			public void update(long currentUploadFileSize, long fileSize, int arg2) {
				
				System.out.println("��ǰʣ��"+((fileSize - currentUploadFileSize) / 1024 / 1024)+"M���ݻ�û���ϴ�");
			
			}
		});
		
		// 4��ͨ��ServletFileUpload��ȥ��������
		// 1������Ҫ��ȡ���ļ����ϴ�Ŀ¼
		String filePathDir = this.getServletContext().getRealPath("/WEB-INF/upload");
		
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			if(fileItems != null && fileItems.size() > 0){
				for(FileItem item : fileItems){
					
					// 5����������ͨ��������ļ��ϴ���,�������
					if(item.isFormField()){
						// ��ʾ������ͨ������
						String filedName =item.getFieldName();
						String fileValue = item.getString("UTF-8");
						
						System.out.println(filedName + "--->"+fileValue);
					}else{
						// ��ʾ�����ļ��ϴ���
						// 2����ȡ���ļ��ϴ�������
						String fileName = item.getName(); 
						
						if(fileName == null ||"".equals(fileName.trim())){
							return;
						}
						
						if(fileName.contains("\\")){
							fileName = fileName.substring(fileName.lastIndexOf("\\"));
						}
						
						// 2.1 ����Ψһ���ļ���
						fileName = FileUtils.generateFileName(fileName);
						
						// 2.2 ��ȡ�ļ�����չ�����ļ�����ʵ����
						String ext = FileUtils.getFileExt(fileName);
						//MagicMatch match = Magic.getMagicMatch(item.get());  
						String type = "image/gif";
						
//						boolean result = FileUtils.validateFileTypeIsImage(ext,type);
//						if(!result){
//							System.out.println("���ϴ����ļ�����ͼƬ�ļ�");
//							return;
//						}
						
						// 3����ȡ�����ļ���Ӧ��������
						InputStream is = item.getInputStream();
						
						// 3.1 ����Ŀ¼
						String realDir = FileUtils.generateDirByDate(filePathDir);
						
						// 4��д�뵽һ�����������ȥ
						FileOutputStream fos = new FileOutputStream(new File(realDir,fileName));
						int len = 0;
						byte[] buffer = new byte[1024];
						while((len = is.read(buffer)) != -1){
							fos.write(buffer, 0, len);
							fos.flush();
						}
						
						is.close();
						fos.close();
						
						// ɾ����ʱ�ļ�
						item.delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}