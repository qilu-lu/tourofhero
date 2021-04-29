package com.angular.demo.heros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.angular.demo.heros.models.People;

public interface PeopleRepository extends CrudRepository<People, Integer> {

	@Query("SELECT c FROM People c WHERE c.hero.id = :idHero")
	List<People> findByHeroId(int idHero);

	List<People> findAll();
}
