package com.jpa.shop.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jpa.shop.domain.Category;

@Entity
@Table(name="ITEM")
@DiscriminatorColumn(name= "DTType") // 여기서 정의한대로 컬럼이 하나 생성된다.이렇게하면 자식 테이블에 해당하는 값이 해당  Entity가 된다.
public abstract class Item {
	
	@Id
	@GeneratedValue
	@Column(name="ITEM_ID")
	private Long itemId;
	
	@Column(name="ITEM_NAME")
	private String name;
	
	@Column(name="PRICE")
	private Integer price;
	
	@Column(name="STOCK_QUANTITY")
	private Integer stockQuantity;
	
	@ManyToMany(mappedBy="items")
	private List<Category> category = new ArrayList<Category>();

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	
}
