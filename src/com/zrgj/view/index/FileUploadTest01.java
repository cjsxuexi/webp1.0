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
	
		// 1、工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 设置临时目录
		//factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));
		
		// 2、通过工厂获取ServletFileUpload
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// 3、判断此表单的请求类型是不是multipart/form-data
		if(!ServletFileUpload.isMultipartContent(request)){
			return;
		}
		
		// 解决的是上传文件名的中文乱码问题
		upload.setHeaderEncoding("UTF-8");
		
		// 设置单个文件的大小
		//upload.setFileSizeMax(1024);
		
		// 监听文件上传的进度
		upload.setProgressListener(new ProgressListener() {
			
			public void update(long currentUploadFileSize, long fileSize, int arg2) {
				
				System.out.println("当前剩余"+((fileSize - currentUploadFileSize) / 1024 / 1024)+"M内容还没有上传");
			
			}
		});
		
		// 4、通过ServletFileUpload来去解析请求
		// 1、首先要获取到文件的上传目录
		String filePathDir = this.getServletContext().getRealPath("/WEB-INF/upload");
		
		try {
			List<FileItem> fileItems = upload.parseRequest(request);
			if(fileItems != null && fileItems.size() > 0){
				for(FileItem item : fileItems){
					
					// 5、表单上有普通输入域和文件上传域,如果区分
					if(item.isFormField()){
						// 表示的是普通输入域
						String filedName =item.getFieldName();
						String fileValue = item.getString("UTF-8");
						
						System.out.println(filedName + "--->"+fileValue);
					}else{
						// 表示的是文件上传域
						// 2、获取到文件上传的名称
						String fileName = item.getName(); 
						
						if(fileName == null ||"".equals(fileName.trim())){
							return;
						}
						
						if(fileName.contains("\\")){
							fileName = fileName.substring(fileName.lastIndexOf("\\"));
						}
						
						// 2.1 生成唯一的文件名
						fileName = FileUtils.generateFileName(fileName);
						
						// 2.2 获取文件的扩展名及文件的真实类型
						String ext = FileUtils.getFileExt(fileName);
						//MagicMatch match = Magic.getMagicMatch(item.get());  
						String type = "image/gif";
						
//						boolean result = FileUtils.validateFileTypeIsImage(ext,type);
//						if(!result){
//							System.out.println("您上传的文件不是图片文件");
//							return;
//						}
						
						// 3、获取到此文件对应的输入流
						InputStream is = item.getInputStream();
						
						// 3.1 生成目录
						String realDir = FileUtils.generateDirByDate(filePathDir);
						
						// 4、写入到一个输出流里面去
						FileOutputStream fos = new FileOutputStream(new File(realDir,fileName));
						int len = 0;
						byte[] buffer = new byte[1024];
						while((len = is.read(buffer)) != -1){
							fos.write(buffer, 0, len);
							fos.flush();
						}
						
						is.close();
						fos.close();
						
						// 删除临时文件
						item.delete();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}