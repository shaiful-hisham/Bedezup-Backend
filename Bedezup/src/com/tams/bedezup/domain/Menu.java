package com.tams.bedezup.domain;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu implements Serializable, BaseDTOInterface {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Menu parent;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parent")
	private Set <Menu> menuList = new LinkedHashSet <Menu>();
	
	public static final String ROOT = "Root";
	
	
	public Menu() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public Set <Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(Set<Menu> menuList) {
		this.menuList = menuList;
	}

	@Override
	public Long getKey() {
		return id;
	}

	@Override
	public void setKey(Long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return title;
	}

	@Override
	public void setName(String name) {
		this.title = name;
	}
	
	@Override
	public String toString() {
		return id + ": " + title;
	}
}
