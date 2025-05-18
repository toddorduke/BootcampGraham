package org.example;

import java.util.ArrayList;

public class Vehicle {
public Vehicle(){

}
    private int vin;
    private int year;
    private String make;
    private String model;
    private VehicleType vehicleType;
    private String color;
    private double odometer;
    private double price;

    public Vehicle(int vin, int year,String make, String model, VehicleType vehicleType, String color, double odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String getMake(){
        return make;
    }
    public void setMake(String make){
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String mode) {
        this.model = mode;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return String.format("%d|%d|%s|%s|%s|%s|%f|%f",
                vin,
                year,
                make,
                model,
                vehicleType,
                color,
                odometer,
                price);
    }
}
