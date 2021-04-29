package com.angular.demo.heros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.angular.demo.heros.models.People;
import com.angular.demo.heros.services.PeopleService;

@RestController()
public class PeopleController {
	@Autowired
	private PeopleService peopleService;

	@GetMapping("{idHero}")
	public ResponseEntity<List<People>> getPeoples(@PathVariable("idHero") int idHero) {
		List<People> liste = peopleService.findByHeroId(idHero);
		liste.forEach(e -> e.getHero().setPeople(null));
		return ResponseEntity.ok(liste);

	}

	@GetMapping("people/peoples")
	public ResponseEntity<List<People>> getAllPeoples() {
		List<People> liste = peopleService.findall();
		liste.stream().filter(e -> e.getHero() != null).forEach(e -> e.getHero().setPeople(null));
		return ResponseEntity.ok(liste);

	}

	@GetMapping("people/detail/{idPeople}")
	public ResponseEntity<People> getPeople(@PathVariable("idPeople") int idPeople) {
		People people = peopleService.findById(idPeople);
		Optional.ofNullable(people.getHero()).ifPresent(e -> e.setPeople(null));
		return ResponseEntity.ok(people);

	}

	@PostMapping("people/peoples")
	public ResponseEntity<People> addPeople(@RequestBody People people) {
		peopleService.save(people);
		return ResponseEntity.ok(people);

	}

	@PostMapping("people/detail/{idPeople}")
	public void updatePeople(@PathVariable("idPeople") int id, @RequestBody People people) {
		peopleService.modifierPeople(id, people);
	}

	@DeleteMapping("people/{id}")
	public void deleteHero(@PathVariable("id") int id) {
		peopleService.remove(id);
	}
}