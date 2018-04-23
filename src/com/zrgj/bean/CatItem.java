package com.zrgj.bean;

import java.math.BigDecimal;

public class CatItem {
//	每种商品的信息
	private Product product;
//	商品数量
	private int number = 1;
//	该种商品的总价格
	private BigDecimal subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		this.setSubtotal(product.getPricate().multiply(new BigDecimal(number+"")));
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	
	
	
	

}
