package com.zrgj.util;

public class EmptyUtil {
	
	
	/**
	 * �ж�value�ǲ��ǿգ��Ǿͷ���true,���ǿվͷ���false
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
