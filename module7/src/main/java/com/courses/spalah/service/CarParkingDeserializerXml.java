package com.courses.spalah.service;

import com.courses.spalah.model.CarParking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class CarParkingDeserializerXml implements CarParkingDeserializer {
    @Override
    public CarParking deserialize(String serializedCarParking) throws JAXBException {
        CarParking carParking;

        JAXBContext jaxbContext = JAXBContext.newInstance(CarParking.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        carParking = (CarParking) jaxbUnmarshaller.unmarshal(new StringReader(serializedCarParking));
        return carParking;
    }
}
