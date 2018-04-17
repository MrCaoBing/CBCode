package com.haochen.hc0407crm.entity;


/**
 * 仓库表
 * 
 * @author lzm
 *
 */
public class Storage {

	
	/**
	 * 仓库编号
	 */
	private Integer stkId;		
	
	/**
	 * 商品编号
	 */
	private Product product;	
	
	/**
	 * 仓库名称
	 */
	private String stkWarehouse;	
	
	/**
	 * 货位
	 */
	private String stkWare;		
	
	/**
	 * 数量
	 */
	private Integer stkCount;	
	
	/**
	 * 备注
	 */
	private String stkMemo;		

	public Integer getStkId() {
		return stkId;
	}

	public void setStkId(Integer stkId) {
		this.stkId = stkId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStkWarehouse() {
		return stkWarehouse;
	}

	public void setStkWarehouse(String stkWarehouse) {
		this.stkWarehouse = stkWarehouse;
	}

	public String getStkWare() {
		return stkWare;
	}

	public void setStkWare(String stkWare) {
		this.stkWare = stkWare;
	}

	public Integer getStkCount() {
		return stkCount;
	}

	public void setStkCount(Integer stkCount) {
		this.stkCount = stkCount;
	}

	public String getStkMemo() {
		return stkMemo;
	}

	public void setStkMemo(String stkMemo) {
		this.stkMemo = stkMemo;
	}

	public Storage(Integer stkId, Product product, String stkWarehouse, String stkWare, Integer stkCount,
			String stkMemo) {
		super();
		this.stkId = stkId;
		this.product = product;
		this.stkWarehouse = stkWarehouse;
		this.stkWare = stkWare;
		this.stkCount = stkCount;
		this.stkMemo = stkMemo;
	}

	public Storage() {
		super();
	}

	
}
