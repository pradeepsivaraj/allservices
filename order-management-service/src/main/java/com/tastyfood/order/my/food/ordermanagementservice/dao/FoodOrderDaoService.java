package com.tastyfood.order.my.food.ordermanagementservice.dao;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tastyfood.order.my.food.ordermanagementservice.model.Foodorder;
import com.tastyfood.order.my.food.ordermanagementservice.model.ItemQuantity;

@Repository
@Component
public class FoodOrderDaoService {

	@Autowired
	private EntityManager em;  
	
	@Transactional
	public String insertOrdering(Foodorder forder) {

		long otime = System.currentTimeMillis();
		Date currentDate = new Date(otime);
	    DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
	    String order_time =  df.format(currentDate);
		long dtime = System.currentTimeMillis()+(30*60*1000);
		Date currentDated = new Date(dtime);
	    DateFormat dff = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
	    String delivery_time =  dff.format(currentDated);
		int total_cost = forder.getItems().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum();
		String r_id = forder.getRestaurant_id();
		String r_name = forder.getRestaurant_name();
		String r_location = forder.getRestaurant_location();
		List<ItemQuantity> items = forder.getItems();
		String payment = forder.getPayment();
		String username = forder.getUsername();
		String user_address = forder.getUser_address();
		
		em.createNativeQuery("INSERT INTO foodorder(restaurant_id,restaurant_name,restaurant_location,total_price,user_address,username,order_time,delivery_time,payment) values(?,?,?,?,?,?,?,?,?)")
	    .setParameter(1, r_id)
	    .setParameter(2, r_name)
	    .setParameter(3, r_location)
	    .setParameter(4, total_cost)
	    .setParameter(5, user_address)
	    .setParameter(6, username)
	    .setParameter(7, order_time)
	    .setParameter(8, delivery_time)
	    .setParameter(9, payment)
	    .executeUpdate();
		
		int id = (int) em.createNativeQuery("select max(order_id) from foodorder").getSingleResult();
		
		String deliverer_name = (String) em.createNativeQuery("select deliverer_name from delivery_info").getSingleResult();
		
		BigInteger deliverer_phone =  (BigInteger) em.createNativeQuery("select deliverer_phone from delivery_info").getSingleResult();
		
		for(int i=0;i<items.size();i++) {
			insertQuantiy(items.get(i),id);
		}
		
		return "The order is placed successful order will be Delivered By "+deliverer_name+" "
				+ " Deliverer Phone "+deliverer_phone+" "
				+ " Delivery Address "+user_address+"  "
				+ " Total Cost "+total_cost+" ";
	}

	@Transactional
	private void insertQuantiy(ItemQuantity itemQuantity, int id) {
		
		em.createNativeQuery("INSERT INTO item_quantity(name, price, quantity, forder_order_id)values(?,?,?,?)")
	    .setParameter(1, itemQuantity.getName())
	    .setParameter(2, itemQuantity.getPrice())
	    .setParameter(3, itemQuantity.getQuantity())
	    .setParameter(4, id)
	    .executeUpdate();
	}
}
