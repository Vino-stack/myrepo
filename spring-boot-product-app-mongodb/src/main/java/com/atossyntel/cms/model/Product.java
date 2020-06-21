package com.atossyntel.cms.model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PRODUCT")
public class Product {

	@Id // pk
	 //@Column(name="ID") // gives a diff name in the RDBMS table
	 private int pid;
	
	 private String pname;	 
	 private int qty;
	 private String pbrand;	 
	 private int pprice;

	 public Product() {
		 this.pid=new Random().nextInt(100000);
		}

	 public Product(String pname, int qty, String pbrand,int pprice) {
			this.pid=new Random().nextInt(100000);
			this.pname=pname;
			this.qty=qty;
			this.pbrand=pbrand;
			this.pprice=pprice;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getPbrand() {
		return pbrand;
	}

	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + ", pbrand=" + pbrand + ", pprice=" + pprice
				+ "]";
	}

	

	
	 
}
