package com.sjsu.payments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImplementation implements MenuService {
	
	  @Autowired
	private MenuRepository menuRepository;


	@Override
	public List<Menu> getCostbyMenuName(String prodName) {
		// TODO Auto-generated method stub
		List<Menu> menuObj = (List<Menu>) menuRepository.findByProdName(prodName);
		return menuObj;
	}


	@Override
	public List<Menu> listMenu() {
		// TODO Auto-generated method stub
		   List<Menu> result = (List<Menu>) menuRepository.findAll();
		return result;
	}

}
