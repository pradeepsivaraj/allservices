package com.tastyfood.order.my.food.usermanagementservice.exception;

public class NoAvailableRoomsException extends Exception {
    public NoAvailableRoomsException() {
        super("No available rooms!");
    }
}
