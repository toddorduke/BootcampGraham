package org.example;


import org.example.DAO.DataManager;

import java.util.ArrayList;
import java.util.List;


public class DealerShip {


    private String name;
    private String phone;
    private String address;

    private List<Vehicle> inventory = new ArrayList<>();

    public DealerShip(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        DataManager dataManager = new DataManager();

        return dataManager.priceRange(min, max);
    }

    //todo fix make/model
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        DataManager dataManager = new DataManager();
        return dataManager.make();
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        DataManager dataManager = new DataManager();
        return dataManager.year(min, max);
    }

    public List<Vehicle> getVehicleByColor(String color) {
        DataManager dataManager = new DataManager();
        return dataManager.color(color);
    }

    public List<Vehicle> getVehicleByMileage(double min, double max) {
        DataManager dataManager = new DataManager();

        return dataManager.mileage(min, max);
    }

    public List<Vehicle> getVehicleByType(VehicleType vehicleType) {
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType() == vehicleType) {
                foundvehicles.add(vehicle);
            }
        }
        return foundvehicles;
    }

    public List<Vehicle> getAllVehicles() {
        DataManager dataManager = new DataManager();

        return dataManager.getAll();
    }

    public void addVehicle(Vehicle vehicle) {
        DataManager dataManager = new DataManager();

        dataManager.create(vehicle);
    }

    public void removeVehicle(int vin) {
        DataManager dataManager = new DataManager();
        dataManager.delete(vin);
    }

    public Vehicle searchByVin(int vin) {
        List<Vehicle> vehicles = this.inventory;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
