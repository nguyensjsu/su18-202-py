package com.piecoffeeshop.model;

import java.util.List;

public interface MenuService {
	public List<Menu> getCostbyMenuName(String prodName);
	 public List<Menu> listMenu();
}
