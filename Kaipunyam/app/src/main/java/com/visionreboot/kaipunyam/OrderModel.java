package com.visionreboot.kaipunyam;

/**
 * Created by BincyBaby on 29/07/18.
 * Copyright (c) 2018 Padath Infotainment
 */
public interface OrderModel {
    class OrderModelData {
        String userName;
        String location;
        String photo;
        String time;
        String food;
        String quantity;

        public OrderModelData(String userName, String location, String photo, String time, String food, String quantity) {
            this.userName = userName;
            this.location = location;
            this.photo = photo;
            this.time = time;
            this.food = food;
            this.quantity = quantity;
        }
    }
}
