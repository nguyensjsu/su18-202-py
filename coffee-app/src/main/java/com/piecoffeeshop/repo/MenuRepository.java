package com.piecoffeeshop.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.piecoffeeshop.model.Menu;

@EnableScan
public interface MenuRepository  extends CrudRepository<Menu, String>  {

	 public List<Menu> findByProdName(String ProdName);
	 public List<Menu> findAll();
}
