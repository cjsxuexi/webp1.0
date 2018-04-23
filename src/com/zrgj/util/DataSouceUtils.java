package com.zrgj.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public final class DataSouceUtils {
	
	private DataSouceUtils(){
		
	}
	
	private static DataSource ds = null;
	
	static{
		InputStream is = null;
		try {
			is = DataSouceUtils.class.getClassLoader().getResourceAsStream("com/zrgj/table/dbcp.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
}