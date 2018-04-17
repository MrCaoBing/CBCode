package com.haochen.hc0407crm.entity;

/**
 * 订单明细表
 * 
 * @author lzm
 *
 */
public class OrdersLine {
	
	/**
	 * 明细编号
	 */
	private Integer oddId;		
	
	/**
	 * 订单编号
	 */
	private Orders orders;	
	
	/**
	 * 商品编号
	 */
	private Product product;	
	
	/**
	 * 数量
	 */
	private Integer oddCount;	
	
	/**
	 * 单位
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
