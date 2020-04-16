package com.tastyfood.order.my.food.ordermanagementservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menus implements Serializable {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

	    private String name;
	    private int price;
	    private int restaurant_id;
	    
		public Menus() {
			
		}

		public Menus(long id, String name, int price, int restaurant_id) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.restaurant_id = restaurant_id;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getRestaurant_id() {
			return restaurant_id;
		}

		public void setRestaurant_id(int restaurant_id) {
			this.restaurant_id = restaurant_id;
		}

		@Override
		public String toString() {
			return "Menus [id=" + id + ", name=" + name + ", price=" + price + ", restaurant_id=" + restaurant_id + "]";
		}
	    
	    
	    
}
