package com.angular.demo.heros.services;

import java.util.List;

import com.angular.demo.heros.models.Hero;

public interface HeroService {
//	Hero hero1 = new Hero(1, "lu");
//	Hero hero2 = new Hero(2, "lui");
//	Hero hero3 = new Hero(3, "lup");
//
//	List<Hero> liste = new ArrayList<>(Arrays.asList(hero1, hero2, hero3));

//	public Hero findById(int i) {
//		
//		for (Hero hero : liste) {
//			if (hero.getId() == i) {
//				return hero;
//			}
//		}
//		return null;
//
//	}
	Hero findById(Integer id);

	List<Hero> findAll();

	void save(Hero hero);

	void remove(Integer id);

	void modifierHero(Integer id, Hero hero);

	List<Hero> findByNom(String nom);

}
