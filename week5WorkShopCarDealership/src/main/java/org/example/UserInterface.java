package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    DealerShip dealership;

    public UserInterface() {
        init();
    }

    //todo init
    private void init() {
        this.dealership = DealershipFileManager.getDealership();
    }

    public boolean display() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(❁´◡`❁) Hello chose your option\n" +
                    "1. Get price\n" +
                    "2. Get Make and model\n" +
                    "3. Get Year\n" +
                    "4. Search by color\n" +
                    "5. Search by mileage\n" +
                    "6. Search by vehicle type.\n" +
                    "7. Search by vehicle\n" +
                    "8. End Session\n" +
                    "9. Add vehicle\n" +
                    "10.) remove vehicle\n");

            String userInput = scanner.nextLine();
            switch (userInput) {

                case "1": {
                    System.out.println("What is your min?");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("What is your max");
                    double max = Double.parseDouble(scanner.nextLine());
                    processGetByPriceRequest(min, max);
                    break;
                }

                case "2": {
                    System.out.println("What is your min?");
                    String min = scanner.nextLine();
                    System.out.println("What is your max");
                    String max = scanner.nextLine();
                    processGetByMakeModelRequest(min, max);
                    break;
                }
                case "3": {
                    System.out.println("What is the min year?");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("What is the max year");
                    double max = Double.parseDouble(scanner.nextLine());

                    processGetByYearRequest(min, max);
                    break;
                }
                case "4": {
                    System.out.println("What color vehicle?");
                    String color = scanner.nextLine();
                    processGetByColorRequest(color);
                    break;
                }
                case "5": {
                    System.out.println("What is your min?");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("What is your max");
                    double max = Double.parseDouble(scanner.nextLine());

                    processGetByMileageRequest(min, max);
                    break;
                }
                case "6": {
                    System.out.println("What is ht vehicle type>");
                    String name = scanner.nextLine();
                    VehicleType vehicleType = VehicleType.valueOf(name);
                    processGetByVehicleTypeRequest(vehicleType);
                    break;
                }
                case "7": {
                    processGetAllVehiclesRequest();
                    break;
                }
                case "9": {
                    processAddVehicleRequest(new Vehicle());
                    break;
                }
                case "10": {
                    System.out.println("What is the vin number");
                    int vin = Integer.parseInt(scanner.nextLine());
                    processRemoveVehicleRequest(vin);
                    break;
                }
                case "8": {
                    System.exit(0);
                }
            }
        }
    }

    public void processGetByPriceRequest(double min, double max) {
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehciles(vehicles);
    }

    public void processGetByMakeModelRequest(String make, String model) {
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehciles(vehicles);
    }

    public void processGetByYearRequest(double min, double max) {
        List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
        displayVehciles(vehicles);
    }

    public void processGetByColorRequest(String color) {
        List<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehciles(vehicles);
    }

    public void processGetByMileageRequest(double min, double max) {
        List<Vehicle> vehciles = dealership.getVehicleByMileage(min, max);
        displayVehciles(vehciles);
    }

    public void processGetByVehicleTypeRequest(VehicleType vehicleType) {
        List<Vehicle> vehicles = dealership.getVehicleByType(vehicleType);
        displayVehciles(vehicles);
    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehciles(vehicles);
    }

    public void processAddVehicleRequest(Vehicle vehicle) {

        dealership.addVehicle(vehicle);
    }

    public void processRemoveVehicleRequest(int vin) {
        List<Vehicle> vehicles = dealership.getAllVehicles();

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle with VIN " + vin + " has been removed.");
                return;
            }
        }

        System.out.println("Vehicle with VIN " + vin + " not found.");
    }

    public static void displayVehciles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}



