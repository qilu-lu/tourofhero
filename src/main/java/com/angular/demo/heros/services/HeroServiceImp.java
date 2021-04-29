package com.angular.demo.heros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.demo.heros.models.Hero;
import com.angular.demo.heros.repository.HeroRepository;

@Service
public class HeroServiceImp implements HeroService {
	@Autowired
	private HeroRepository heroRepo;

	@Override
	public Hero findById(Integer id) {

		return heroRepo.findById(id).get();
	}

	@Override
	public List<Hero> findAll() {

		return heroRepo.findAll();
	}

	@Override
	public void save(Hero hero) {
		heroRepo.save(hero);
	}

	@Override
	public void remove(Integer id) {
		Hero hero = heroRepo.findById(id).get();
		heroRepo.delete(hero);
	}

	@Override
	public void modifierHero(Integer id, Hero hero2) {
		Hero hero = heroRepo.findById(id).get();
		hero.setName(hero2.getName());
		heroRepo.save(hero);
	}

	@Override
	public List<Hero> findByNom(String nom) {
		return heroRepo.findByName(nom);

	}

}
