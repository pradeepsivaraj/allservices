package com.tastyfood.order.my.food.ordermanagementservice.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tastyfood.order.my.food.ordermanagementservice.dao.FoodOrderDaoService;
import com.tastyfood.order.my.food.ordermanagementservice.model.Foodorder;

@RestController
public class FoodOrderController {

	@Autowired
	private FoodOrderDaoService service;
	
/*	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    @Autowired
    private Gson gson;
	
	@PostMapping("create/order")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> createOrder(@RequestBody Foodorder forder) throws InterruptedException, ExecutionException{
		String results = service.insertOrdering(forder);
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("test", gson.toJson(results));
		System.out.println("Result==>"+result);
        return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
		
	}*/
	
	
    @PostMapping("create/order")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> createOrder(@RequestBody Foodorder forder) {
		String results = service.insertOrdering(forder);
		return new ResponseEntity<>(results,HttpStatus.OK);
	}
	
}
