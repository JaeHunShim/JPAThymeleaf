package com.jpa.shop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jpa.shop.domain.item.Item;

@Entity
@Table(name="CATEGORY")
public class Category {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private long id;
	
	@Column(name="CATEGORY_NAME")
	private String name;
	
	@ManyToMany
	@JoinTable(name="CATEGORY_ITEM", joinColumns = @JoinColumn(name="CATEGORY_ID"),
			inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
	private List<Item> items = new ArrayList<Item>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID")
	private Category parent;
	
	@OneToMany(mappedBy="parent")
	private List<Category> child = new ArrayList<Category>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public List<Category> getChild() {
		return child;
	}

	public void setChild(List<Category> child) {
		this.child = child;
	}
	
	
	
}
