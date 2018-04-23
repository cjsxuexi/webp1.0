package com.zrgj.util;

import org.apache.commons.beanutils.Converter;

public class StringConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		StringBuffer sBuffer = new StringBuffer();
		
		if (value instanceof String[]) {
			String[] values = (String[])value;
			
			for(String s : values){
				
				sBuffer.append(s).append("_");
			}
			sBuffer.deleteCharAt(sBuffer.length()-1);
			return sBuffer;
		}
		
		return value;
		
	}

}
