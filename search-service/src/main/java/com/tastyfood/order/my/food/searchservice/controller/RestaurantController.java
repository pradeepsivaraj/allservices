package com.tastyfood.order.my.food.searchservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tastyfood.order.my.food.searchservice.dao.RestaurantDaoService;
import com.tastyfood.order.my.food.searchservice.exception.NoRestauarantFound;
import com.tastyfood.order.my.food.searchservice.model.Restaurants;

import javassist.NotFoundException;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantDaoService service;
	
	
	@GetMapping("search/restaurants/distance/hystrix/{distance}")
	@HystrixCommand(fallbackMethod = "fallbackgetByDistance",commandProperties = {
			   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	})
	public ResponseEntity<List<Restaurants>> getByHystrixDistance(@PathVariable long distance) throws InterruptedException, NoRestauarantFound{
			
		Thread.sleep(3000);
		List<Restaurants> rests = service.searchByDistance(distance);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
		
	}
	
	@GetMapping("search/restaurants/distance/{distance}")
	public ResponseEntity<List<Restaurants>> getByDistance(@PathVariable long distance) throws InterruptedException, NoRestauarantFound{
		
		Thread.sleep(3000);
		List<Restaurants> rests = service.searchByDistance(distance);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
		
	}
	
	@GetMapping("search/restaurants/type/{type}")
	public ResponseEntity<List<Restaurants>> getByType(@PathVariable String type) throws NoRestauarantFound{
		
		List<Restaurants> rests = service.searchByType(type);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
	}
	
	@GetMapping("search/restaurants/budget/{budget}")
	public ResponseEntity<List<Restaurants>> getByBudget(@PathVariable long budget) throws NoRestauarantFound{
		
		List<Restaurants> rests = service.searchByBudget(budget);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
	}
	
	@GetMapping("search/restaurants/rating/{rating}")
	public ResponseEntity<List<Restaurants>> getByRating(@PathVariable double rating) throws NoRestauarantFound{
		
		List<Restaurants> rests = service.searchByRating(rating);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
		
	}
	
	@GetMapping("search/restaurants/expuser/{expuser}")
	public ResponseEntity<List<Restaurants>> getByExpUser(@PathVariable String expuser) throws NoRestauarantFound{
		
		List<Restaurants> rests = service.searchByExpUser(expuser);
		
		if(!rests.isEmpty()) {
			return ResponseEntity.ok().body(rests);
		} else {
			throw new NoRestauarantFound();
		}
	}
	
	
	public ResponseEntity<List<Restaurants>> fallbackgetByDistance(long distance){
		List ls = new ArrayList<>();
		ls.add("Cannot fetch the result. Request fails. Due to response timeout");
		return ResponseEntity.ok().body(ls);
	}
	
/*	public ResponseEntity<List<Restaurants>> fallbackgetByType(String type){
		return ResponseEntity.ok().body(service.getAllRestaurants());
	}
	
	public ResponseEntity<List<Restaurants>> fallbackgetByBudget(long budget){
		return ResponseEntity.ok().body(service.getAllRestaurants());
	}
	
	public ResponseEntity<List<Restaurants>> fallbackgetByRating(double rating){
		return ResponseEntity.ok().body(service.getAllRestaurants());
	}
	
	public ResponseEntity<List<Restaurants>> fallbackgetByExpuser(String expuser){
		return ResponseEntity.ok().body(service.getAllRestaurants());
	}*/
	
}
