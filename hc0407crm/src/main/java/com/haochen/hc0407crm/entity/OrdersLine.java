package com.haochen.hc0407crm.entity;

/**
 * ������ϸ��
 * 
 * @author lzm
 *
 */
public class OrdersLine {
	
	/**
	 * ��ϸ���
	 */
	private Integer oddId;		
	
	/**
	 * �������
	 */
	private Orders orders;	
	
	/**
	 * ��Ʒ���
	 */
	private Product product;	
	
	/**
	 * ����
	 */
	private Integer oddCount;	
	
	/**
	 * ��λ
	 */
	private String oddUnit;		

	public Integer getOddId() {
		return oddId;
	}

	public void setOddId(Integer oddId) {
		this.oddId = oddId;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getOddCount() {
		return oddCount;
	}

	public void setOddCount(Integer oddCount) {
		this.oddCount = oddCount;
	}

	public String getOddUnit() {
		return oddUnit;
	}

	public void setOddUnit(String oddUnit) {
		this.oddUnit = oddUnit;
	}

	public OrdersLine(Integer oddId, Orders orders, Product product, Integer oddCount, String oddUnit) {
		super();
		this.oddId = oddId;
		this.orders = orders;
		this.product = product;
		this.oddCount = oddCount;
		this.oddUnit = oddUnit;
	}

	public OrdersLine() {
		super();
	}

}
