package com.jpa.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jpa.shop.enumtype.OrderStatus;

@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	private Long orderId;
	
	@JoinColumn(name="MEMBER_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;
	
	@OneToMany(mappedBy="order", cascade= CascadeType.ALL)
	private List<OrderItem> orderItem = new ArrayList<OrderItem>();
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="DELIVERY_ID")
	private Delivery delevery;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Delivery getDelevery() {
		return delevery;
	}

	public void setDelevery(Delivery delevery) {
		this.delevery = delevery;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
}
