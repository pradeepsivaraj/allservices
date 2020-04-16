package com.tastyfood.order.my.food.usermanagementservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/api/test")
public class TestRestAPIs {
	
  
  @GetMapping("/user")
  @PreAuthorize("hasRole('USER')")
  public String userAccess() {
    return ">>> User Contents";
  }
  
  
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return ">>> Admin Contents";
  }

	
  
}
