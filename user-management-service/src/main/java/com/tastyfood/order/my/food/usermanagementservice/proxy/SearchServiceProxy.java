package com.tastyfood.order.my.food.usermanagementservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tastyfood.order.my.food.usermanagementservice.model.Foodorder;
import com.tastyfood.order.my.food.usermanagementservice.model.Restaurants;


@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="search-service")
public interface SearchServiceProxy {
		
	@GetMapping("/search-service/search/restaurants/distance/{distance}")
	public ResponseEntity<List<Restaurants>> getByDistance(@PathVariable("distance") long distance);
	
	@GetMapping("/search-service/search/restaurants/type/{type}")
	public ResponseEntity<List<Restaurants>> getByType(@PathVariable("type") String type);

	@GetMapping("/search-service/search/restaurants/budget/{budget}")
	public ResponseEntity<List<Restaurants>> getByBudget(@PathVariable("budget") long budget);

	@GetMapping("/search-service/search/restaurants/rating/{rating}")
	public ResponseEntity<List<Restaurants>> getByRating(@PathVariable("rating") double rating);

	@GetMapping("/search-service/search/restaurants/expuser/{expuser}")
	public ResponseEntity<List<Restaurants>> getByExpUser(@PathVariable("expuser") String expuser);
	
	@PostMapping("/order-management-service/create/order")
	public Foodorder createOrder(@RequestBody Foodorder forder);
}
