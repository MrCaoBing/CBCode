package com.haochen.hc0407crm.entity;


/**
 * �ֿ��
 * 
 * @author lzm
 *
 */
public class Storage {

	
	/**
	 * �ֿ���
	 */
	private Integer stkId;		
	
	/**
	 * ��Ʒ���
	 */
	private Product product;	
	
	/**
	 * �ֿ�����
	 */
	private String stkWarehouse;	
	
	/**
	 * ��λ
	 */
	private String stkWare;		
	
	/**
	 * ����
	 */
	private Integer stkCount;	
	
	/**
	 * ��ע
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
