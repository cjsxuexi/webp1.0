package com.zrgj.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



/**
 * 购物车
 * @author Administrator
 *
 */
public class Car {
//	总金额
	private BigDecimal totalSum = new BigDecimal("0");
//	购物车总表单 ，String存放商品名
	private Map<String,CatItem> catMap = new HashMap<String,CatItem>() ;
	
	public Map<String, CatItem> getCatMap() {
		return catMap;
	}

	public void setCatMap(CatItem catItem) {
		
//		获取商品名称
		String name = catItem.getProduct().getPname();
//		判断购物车是否包含该类商品
		if(catMap.containsKey(name)){
//			如果包含就在该清单中对该商品的数量加1
			CatItem item = catMap.get(name);
			item.setNumber(item.getNumber()+1);
		}
//		如果不包含，就增加该种类的商品，并初始化商品数量为1
		else {
			catMap.put(name, catItem);
		}
		
	}

	public BigDecimal getTotalSum() {
		/*// 累计得变量
				BigDecimal sumPrice = new BigDecimal("0");

				Set<String> keySet = catMap.keySet();
				Iterator<String> iters = keySet.iterator();
				while (iters.hasNext()) {
					String key = iters.next();
					CatItem cartItem = catMap.get(key);
					sumPrice = sumPrice.add(cartItem.getSubtotal());

				}

				this.totalSum = sumPrice;

				return totalSum;*/
		
		Iterator<Map.Entry<String, CatItem>> iterator = catMap.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, CatItem> entry = iterator.next();
			totalSum = totalSum.add(entry.getValue().getSubtotal());
		}
/*//		遍历购物车中的商品
//		获取商品名
		Iterator<String> keySet =  this.getCatMap().keySet().iterator();
//		对每类商品小计进行累加
		while(keySet.hasNext()){
//			获取当前商品名
			String pname = keySet.next();
//			获取该条商品的总信息
			CatItem catItem = catMap.get(pname);
//			totalSum.add(catMap.get(keySet.next()).getSubtotal());
			totalSum.add(catItem.getSubtotal());
		}*/
		return totalSum;
	}
	
}
