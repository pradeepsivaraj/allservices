package com.tastyfood.order.my.food.ordermanagementservice.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Foodorder implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int order_id;
    private String restaurant_id;
    private String restaurant_name;
    private String restaurant_location;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="forder",cascade = CascadeType.ALL)
    private List<ItemQuantity> items;
    private int totalPrice;
    private String orderTime;
    private String deliveryTime;
    private String payment;
    private String username;
    private String user_address;

	public Foodorder() {
	}

	public Foodorder(int order_id, String restaurant_id, String restaurant_name, String restaurant_location,
			List<ItemQuantity> items, int totalPrice, String orderTime, String deliveryTime, String payment, String username, String user_address) {
		super();
		this.order_id = order_id;
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_location = restaurant_location;
		this.items = items;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.payment = payment;
		this.username = username;
		this.user_address = user_address;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_location() {
		return restaurant_location;
	}

	public void setRestaurant_location(String restaurant_location) {
		this.restaurant_location = restaurant_location;
	}

	public List<ItemQuantity> getItems() {
		return items;
	}

	public void setItems(List<ItemQuantity> items) {
		this.items = items;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

    
	
	
	
}
