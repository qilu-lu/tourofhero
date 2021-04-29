package com.angular.demo.heros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.demo.heros.models.People;
import com.angular.demo.heros.repository.PeopleRepository;

@Service
public class PeopleServiceImp implements PeopleService {
	@Autowired
	private PeopleRepository peopleRepo;

	@Override
	public List<People> findByHeroId(int heroId) {
		return peopleRepo.findByHeroId(heroId);

	}

	@Override
	public People findById(int idPeople) {
		return peopleRepo.findById(idPeople).get();

	}

	@Override
	public void modifierPeople(int id, People people) {
		People peopleAModifier = peopleRepo.findById(id).get();
		peopleAModifier.setNom(people.getNom());
		peopleAModifier.setHero(people.getHero());
		peopleRepo.save(peopleAModifier);

	}

	@Override
	public List<People> findall() {
		// TODO Auto-generated method stub
		return peopleRepo.findAll();

	}

	@Override
	public void save(People people) {
		peopleRepo.save(people);

	}

	@Override
	public void remove(int id) {
		People people = peopleRepo.findById(id).get();
		peopleRepo.delete(people);

	}

}
