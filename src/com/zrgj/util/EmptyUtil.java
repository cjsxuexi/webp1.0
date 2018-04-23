package com.zrgj.util;

public class EmptyUtil {
	
	
	/**
	 * 判断value是不是空，是就返回true,不是空就返回false
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		if (value == null ||value.equals("")) {
			return true;
		}
		return false;
	}
	
	
	public static boolean isEmpty(String[] value) {
		if (value == null) {
			return true;
		}else {
			for(String s :value){
				if(isEmpty(s)){
					return true;
				}
			}			
		}
		return false;
	}

}
