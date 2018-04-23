package com.zrgj.view.index;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public final class FileUtils {

	private FileUtils(){
		
	}
	
	/**
	 * 	�������Ψһ���ļ���
	*/
	public static String generateFileName(String fileName){
		return UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
	}
	
	/**
	 * 	����Ŀ¼
	 * 		����һ���ļ�����ȥ��������ļ�����hashֵ(����һ���ַ�����ȥ����һ���ַ�����hashֵ)
	 * 
	 * 		1��ͨ���ļ�������hashcode
	 * 		2������hashcodeֵ�ĵ�4λ��Ϊһ��Ŀ¼
	 * 		3������hashcodeֵ��5-8λ��Ϊ����Ŀ¼
	*/
	public static String generateDirByHashCode(String filePathDir , String fileName){
		
		int hashCode = fileName.hashCode();
		
		int dirLevel1 = hashCode & 0X0F;
		int dirLevel2 = (hashCode & 0XF0) >> 4;
		
		String realDir = filePathDir + "\\" + dirLevel1 + "\\" + dirLevel2;
		File file = new File(realDir);
		if(!file.exists()){
			file.mkdirs();
		}
		return realDir;
	}
	
	
	/**
	 * 	����Ŀ¼
	 * 		ͨ������
	 * 			��
	 * 				��
	 * 					��
	 * 						ʱ
	*/
	public static String generateDirByDate(String filePathDir){
		
		// ��ǰʱ��
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH");
		String formatDate = sdf.format(date);
		
		String realDir = filePathDir + "\\" + formatDate;
		File file = new File(realDir);
		if(!file.exists()){
			file.mkdirs();
		}
		
		return realDir;
	}
	
	/**
	 * 	�����ļ�����ȡ��չ�� 
	 * 		xxx.txt
	*/
	public static String getFileExt(String fileName){
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		return ext;
	}
	
	/**
	 * 	У���ϴ����ļ���ͼƬ�ļ�
	*/
	public static boolean validateFileTypeIsImage(String ext,String type){
		
		boolean flag = true;
		
		List<String> exts = Arrays.asList("gif","png","bmp","jpeg","jpg");
		List<String> types = Arrays.asList("image/gif","image/png","image/bmp","image/jpeg","image/jpeg");
		
		if(!exts.contains(ext)){
			flag = false;
		}
		
		if(!types.contains(type)){
			flag = false;
		}
		
		return flag;
	}
}
