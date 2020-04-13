package com.tastyfood.order.my.food.searchservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeliveryInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int delivery_id;
	private String deliverer_name;
	private long deliverer_phone;
	
}
