package com.zrgj.bean;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



/**
 * ���ﳵ
 * @author Administrator
 *
 */
public class Car {
//	�ܽ��
	private BigDecimal totalSum = new BigDecimal("0");
//	���ﳵ�ܱ� ��String�����Ʒ��
	private Map<String,CatItem> catMap = new HashMap<String,CatItem>() ;
	
	public Map<String, CatItem> getCatMap() {
		return catMap;
	}

	public void setCatMap(CatItem catItem) {
		
//		��ȡ��Ʒ����
		String name = catItem.getProduct().getPname();
//		�жϹ��ﳵ�Ƿ����������Ʒ
		if(catMap.containsKey(name)){
//			����������ڸ��嵥�жԸ���Ʒ��������1
			CatItem item = catMap.get(name);
			item.setNumber(item.getNumber()+1);
		}
//		����������������Ӹ��������Ʒ������ʼ����Ʒ����Ϊ1
		else {
			catMap.put(name, catItem);
		}
		
	}

	public BigDecimal getTotalSum() {
		/*// �ۼƵñ���
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
/*//		�������ﳵ�е���Ʒ
//		��ȡ��Ʒ��
		Iterator<String> keySet =  this.getCatMap().keySet().iterator();
//		��ÿ����ƷС�ƽ����ۼ�
		while(keySet.hasNext()){
//			��ȡ��ǰ��Ʒ��
			String pname = keySet.next();
//			��ȡ������Ʒ������Ϣ
			CatItem catItem = catMap.get(pname);
//			totalSum.add(catMap.get(keySet.next()).getSubtotal());
			totalSum.add(catItem.getSubtotal());
		}*/
		return totalSum;
	}
	
}
