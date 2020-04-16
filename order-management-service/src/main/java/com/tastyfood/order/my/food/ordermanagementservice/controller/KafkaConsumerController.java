/*package com.tastyfood.order.my.food.ordermanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.google.gson.Gson;
import com.tastyfood.order.my.food.ordermanagementservice.model.Foodorder;

 
@RestController
public class KafkaConsumerController {
 
    @Autowired
    private Gson gson;
 
    @KafkaListener(topics = { "test" })
    public void getTopics(@RequestBody String foodorder) {
        System.out.println("Kafka event consumed is: " + foodorder);
        String model = gson.fromJson(foodorder, String.class);
        System.out.println("Model converted value: " + model.toString());
    }
}*/