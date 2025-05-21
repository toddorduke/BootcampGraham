package org.example;


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
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                foundvehicles.add(vehicle);
            }

        }
        return foundvehicles;

    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().toUpperCase().contains(make.toLowerCase()) && vehicle.getModel().toUpperCase().contains(model.toLowerCase()))
                foundvehicles.add(vehicle);
        }
        return foundvehicles;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory)
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                foundvehicles.add(vehicle);
            }
        return foundvehicles;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().toLowerCase().contains(color)) {
                foundvehicles.add(vehicle);
            }
        }
        return foundvehicles;
    }

    public List<Vehicle> getVehicleByMileage(double min, double max) {
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                foundvehicles.add(vehicle);
            }
        }
        return foundvehicles;
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
        List<Vehicle> foundvehicles = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            foundvehicles.add(vehicle);

        }
        return foundvehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle) {

        this.inventory.remove(vehicle);

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
