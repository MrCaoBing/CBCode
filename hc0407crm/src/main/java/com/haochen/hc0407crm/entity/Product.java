package com.haochen.hc0407crm.entity;

/**
 * ��Ʒ��
 * 
 * @author lzm
 *
 */
public class Product {
	
	/**
	 * ��Ʒ���
	 */
	private Integer prodId;		
	
	/**
	 * ��Ʒ����
	 */
	private String prodName; 	
	
	/**
	 * ��Ʒ����
	 */
	private String prodType;	
	
	/**
	 * ����
	 */
	private String prodBatch;	
	
	/**
	 * ��λ
	 */
	private String prodUnit;	
	
	/**
	 * �۸�
	 */
	private Double prodPrice;	
	
	/**
	 * ��ע
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
