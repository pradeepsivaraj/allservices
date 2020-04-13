package com.tastyfood.order.my.food.searchservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_type;
	private long budget_range;
	private double delivery_rating;
	private long restaurant_distance;
	private String restaurant_location;
	
	public Restaurants() {
	}

	public Restaurants(int restaurant_id, String restaurant_name, String restaurant_type, long budget_range,
			double delivery_rating, long restaurant_distance, String restaurant_location) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_type = restaurant_type;
		this.budget_range = budget_range;
		this.delivery_rating = delivery_rating;
		this.restaurant_distance = restaurant_distance;
		this.restaurant_location = restaurant_location;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_type() {
		return restaurant_type;
	}

	public void setRestaurant_type(String restaurant_type) {
		this.restaurant_type = restaurant_type;
	}

	public long getBudget_range() {
		return budget_range;
	}

	public void setBudget_range(long budget_range) {
		this.budget_range = budget_range;
	}

	public double getDelivery_rating() {
		return delivery_rating;
	}

	public void setDelivery_rating(double delivery_rating) {
		this.delivery_rating = delivery_rating;
	}

	public long getRestaurant_distance() {
		return restaurant_distance;
	}

	public void setRestaurant_distance(long restaurant_distance) {
		this.restaurant_distance = restaurant_distance;
	}

	public String getRestaurant_location() {
		return restaurant_location;
	}

	public void setRestaurant_location(String restaurant_location) {
		this.restaurant_location = restaurant_location;
	}

	@Override
	public String toString() {
		return "Restaurants [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name
				+ ", restaurant_type=" + restaurant_type + ", budget_range=" + budget_range + ", delivery_rating="
				+ delivery_rating + ", restaurant_distance=" + restaurant_distance + ", restaurant_location="
				+ restaurant_location + "]";
	}

	
	
	
}
