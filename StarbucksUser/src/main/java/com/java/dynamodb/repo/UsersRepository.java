package com.java.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.java.dynamodb.model.Useers;

@EnableScan
public interface UsersRepository extends CrudRepository<Useers, String> {

	List<Useers> findByid(String id);
	List<Useers> findByName(String name);
}
