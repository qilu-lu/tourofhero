package com.angular.demo.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.angular.demo.user.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT fav from User fav  where fav.username = :name")
	User findByName(String name);

}
