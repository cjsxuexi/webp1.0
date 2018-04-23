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
	 * 	随机生成唯一的文件名
	*/
	public static String generateFileName(String fileName){
		return UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
	}
	
	/**
	 * 	生成目录
	 * 		根据一个文件名来去计算这个文件名的hash值(根据一个字符串来去计算一个字符串的hash值)
	 * 
	 * 		1、通过文件名计算hashcode
	 * 		2、我拿hashcode值的低4位作为一级目录
	 * 		3、我拿hashcode值的5-8位作为二级目录
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
	 * 	生成目录
	 * 		通过日期
	 * 			年
	 * 				月
	 * 					日
	 * 						时
	*/
	public static String generateDirByDate(String filePathDir){
		
		// 当前时间
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
	 * 	根据文件名获取扩展名 
	 * 		xxx.txt
	*/
	public static String getFileExt(String fileName){
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		return ext;
	}
	
	/**
	 * 	校验上传的文件是图片文件
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
