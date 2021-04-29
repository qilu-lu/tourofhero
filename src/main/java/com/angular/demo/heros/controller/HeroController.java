package com.angular.demo.heros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.angular.demo.heros.models.Hero;
import com.angular.demo.heros.services.HeroService;

@RestController
public class HeroController {
	@Autowired
	private HeroService heroService;

	@GetMapping("/")
	public ResponseEntity<List<Hero>> getHeros() {
		List<Hero> liste = heroService.findAll();
		liste.forEach(e -> e.getPeople().forEach(e2 -> e2.setHero(null)));
		return ResponseEntity.ok(liste);

	}

	@PostMapping("/")
	public ResponseEntity<Hero> addHero(@RequestBody Hero hero) {
		heroService.save(hero);
		return ResponseEntity.ok(hero);
	}

	@DeleteMapping("/{id}")
	public void deleteHero(@PathVariable("id") int id) {
		heroService.remove(id);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Hero> getHero(@PathVariable("id") int id) {
		Hero heroamodifer = heroService.findById(id);
		heroamodifer.getPeople().forEach(e -> e.setHero(null));
		return ResponseEntity.ok(heroamodifer);

	}

	@PostMapping("/detail/{id}")
	public void modifierHero(@PathVariable("id") int id, @RequestBody Hero hero) {
		heroService.modifierHero(id, hero);
	}

	@GetMapping("/")
	public ResponseEntity<List<Hero>> searchHero(@RequestParam String name) {
		List<Hero> herorecherche = null;
		List<Hero> herorecherche2 = heroService.findByNom(name);
		if (herorecherche2 != null) {
			herorecherche = herorecherche2;
			for (Hero hero : herorecherche2) {

				hero.getPeople().forEach(e -> e.setHero(null));
			}
		}
		return ResponseEntity.ok(herorecherche);
	}

}
