package com.zrgj.bean;

import java.math.BigDecimal;

public class Product {
//	商品id编号
	private int pid;
//	商品名称
	private String pname;
//	商品价格
	private BigDecimal pricate;
//	商品描述
	private String introduce;
//	商品唯一sku
	private String pno;

	public Product() {
		super();
	}
	public Product(int pid, String pname, BigDecimal pricate, String introduce, String pno) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pricate = pricate;
		this.introduce = introduce;
		this.pno = pno;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public BigDecimal getPricate() {
		return pricate;
	}
	public void setPricate(BigDecimal pricate) {
		this.pricate = pricate;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	
	

}
