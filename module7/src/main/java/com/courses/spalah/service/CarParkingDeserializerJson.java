package com.courses.spalah.service;

import com.courses.spalah.model.CarParking;
import com.google.gson.Gson;

public class CarParkingDeserializerJson implements CarParkingDeserializer {
    @Override
    public CarParking deserialize(String serializedCarParking) {
        Gson gson = new Gson();
        CarParking carParking = gson.fromJson(serializedCarParking, CarParking.class);
        return carParking;
    }
}
