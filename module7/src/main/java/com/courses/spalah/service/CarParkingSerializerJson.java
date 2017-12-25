package com.courses.spalah.service;

import com.courses.spalah.model.CarParking;
import com.google.gson.Gson;

public class CarParkingSerializerJson implements CarParkingSerializer {
    @Override
    public String serialize(CarParking carParking) {
        Gson gson = new Gson();
        String json = gson.toJson(carParking);
        return json;
    }
}
