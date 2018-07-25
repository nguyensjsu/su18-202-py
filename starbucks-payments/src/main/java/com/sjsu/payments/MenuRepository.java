package com.sjsu.payments;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface MenuRepository  extends CrudRepository<Menu, String>  {

	 public List<Menu> findByProdName(String ProdName);
	 public List<Menu> findAll();
}
