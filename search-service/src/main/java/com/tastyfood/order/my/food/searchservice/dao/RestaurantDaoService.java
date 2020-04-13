package com.tastyfood.order.my.food.searchservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tastyfood.order.my.food.searchservice.model.Restaurants;

@Repository
@Component
@Service
public class RestaurantDaoService {
	
	@Autowired
	private EntityManager em;

	 
	/*Method to search by restaurant distance*/
	public List<Restaurants> searchByDistance(long distance){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		TypedQuery<Restaurants> query = em.createQuery("FROM Restaurants rs  where rs.restaurant_distance='"+distance+"'",Restaurants.class);
		ls = query.getResultList();
		
		 return ls;
	}
	
	/*Method to search by restaurant type*/
	public List<Restaurants> searchByType(String type){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		TypedQuery<Restaurants> query = em.createQuery("FROM Restaurants rs where rs.restaurant_type  like '"+type+"%'",Restaurants.class);
		ls = query.getResultList();
		
		return ls;
	}
	
	/*Method to search by restaurant budget*/
	public List<Restaurants> searchByBudget(long budget){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		TypedQuery<Restaurants> query = em.createQuery("FROM Restaurants rs where rs.budget_range<='"+budget+"'",Restaurants.class);
		ls = query.getResultList();
		
		return ls;
	}
	
	/*Method to search by restaurant rating*/
	public List<Restaurants> searchByRating(double rating){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		TypedQuery<Restaurants> query = em.createQuery("FROM Restaurants rs where rs.delivery_rating='"+rating+"'",Restaurants.class);
		ls = query.getResultList();
		
		return ls;
		
	}
	
	/*Method to search by restaurant experience user*/
	public List<Restaurants> searchByExpUser(String expuser){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		TypedQuery<Restaurants> query = em.createQuery("FROM Restaurants rs where rs.restaurant_type  like '"+expuser+"%' OR rs.restaurant_name like '%"+expuser+"%'",Restaurants.class);
		ls = query.getResultList();
		
		return ls;
		
	}
	
	public List<Restaurants> getAllRestaurants(){
		
		List<Restaurants> ls = new ArrayList<Restaurants>();
		String query = "select * from restaurants";
		ls = em.createNativeQuery(query).getResultList();
		return ls;
	}
	
	  
	
}
