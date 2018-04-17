package com.haochen.hc0407crm.entity;

/**
 * 商品表
 * 
 * @author lzm
 *
 */
public class Product {
	
	/**
	 * 商品编号
	 */
	private Integer prodId;		
	
	/**
	 * 商品名称
	 */
	private String prodName; 	
	
	/**
	 * 商品类型
	 */
	private String prodType;	
	
	/**
	 * 批号
	 */
	private String prodBatch;	
	
	/**
	 * 单位
	 */
	private String prodUnit;	
	
	/**
	 * 价格
	 */
	private Double prodPrice;	
	
	/**
	 * 备注
	 */
	private String prodMemo;
	
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdBatch() {
		return prodBatch;
	}
	public void setProdBatch(String prodBatch) {
		this.prodBatch = prodBatch;
	}
	public String getProdUnit() {
		return prodUnit;
	}
	public void setProdUnit(String prodUnit) {
		this.prodUnit = prodUnit;
	}
	public Double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdMemo() {
		return prodMemo;
	}
	public void setProdMemo(String prodMemo) {
		this.prodMemo = prodMemo;
	}
	public Product(Integer prodId, String prodName, String prodType, String prodBatch, String prodUnit,
			Double prodPrice, String prodMemo) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodBatch = prodBatch;
		this.prodUnit = prodUnit;
		this.prodPrice = prodPrice;
		this.prodMemo = prodMemo;
	}
	public Product() {
		super();
	}
	
	
	
	
	
	

}
