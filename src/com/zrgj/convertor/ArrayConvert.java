package com.zrgj.convertor;

import org.apache.commons.beanutils.Converter;

import com.zrgj.util.EmptyUtil;

public class ArrayConvert implements Converter{

	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object array) {
				
		StringBuffer result =new StringBuffer("");
		if(array instanceof String[]){
			
			String[] strings = (String[]) array;
			
			if(!EmptyUtil.isEmpty(strings)){
				for(String i : strings){
					result.append(i).append("_");
				}
				result.deleteCharAt(result.length()-1);
			}
			return result.toString();
		}
		return array;
	}

}
