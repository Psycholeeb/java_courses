package com.courses.spalah.mvc.request;

/**
 * @author Ievgen Tararaka
 */
public class PlaneRequest {
    private String name;
    private int businessSeats;
    private int economSeats;

    public PlaneRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomSeats() {
        return economSeats;
    }

    public void setEconomSeats(int economSeats) {
        this.economSeats = economSeats;
    }

    @Override
    public String toString() {
        return "PlaneRequest{" +
                "name='" + name + '\'' +
                ", businessSeats=" + businessSeats +
                ", economSeats=" + economSeats +
                '}';
    }
}
