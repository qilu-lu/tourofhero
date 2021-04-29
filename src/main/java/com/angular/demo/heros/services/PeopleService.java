package com.angular.demo.heros.services;

import java.util.List;

import com.angular.demo.heros.models.People;

public interface PeopleService {
	List<People> findByHeroId(int heroId);

	List<People> findall();

	People findById(int idPeople);

	void modifierPeople(int id, People people);

	void save(People people);

	void remove(int id);
}
