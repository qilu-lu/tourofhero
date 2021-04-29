package com.angular.demo.heros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.angular.demo.heros.models.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer> {
	List<Hero> findAll();

	@Query("SELECT a FROM Hero a where a.name like  '%' || :name || '%'")
	List<Hero> findByName(String name);

}
