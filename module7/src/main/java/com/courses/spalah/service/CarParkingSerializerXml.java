package com.courses.spalah.service;

import com.courses.spalah.model.CarParking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class CarParkingSerializerXml implements CarParkingSerializer {
    @Override
    public String serialize(CarParking carParking) throws JAXBException {
        StringWriter stringWriter = new StringWriter();

        JAXBContext jaxbContext = JAXBContext.newInstance(CarParking.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(carParking, stringWriter);
        //jaxbMarshaller.marshal(carParking, new File("d:\\file.xml"));

        return stringWriter.toString();
    }
}
