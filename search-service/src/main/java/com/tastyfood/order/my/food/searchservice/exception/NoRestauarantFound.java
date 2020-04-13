package com.tastyfood.order.my.food.searchservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoRestauarantFound extends RuntimeException {
	
	public NoRestauarantFound() {
		super("No Restuarant Found");
	}
}
