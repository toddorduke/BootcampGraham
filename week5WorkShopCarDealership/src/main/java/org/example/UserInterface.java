package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    DealerShip dealership;

    public UserInterface() {
    init();
    }

    public static void main(String[] args) {

        System.out.println();
    }

    //todo init
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership();
    }

    public String display() {



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
                    "8. End Session\n");

            String userInput = scanner.nextLine();
            switch (userInput) {

                case "1": {System.out.println("What is your min?");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("What is your max");
                    double max = Double.parseDouble(scanner.nextLine());
                    processGetByPriceRequest(min,max);
                }
                break;

                case "2": {

                    processGetByMakeModelRequest();
                    break;
                }
                case "3": {
                    processGetByYearRequest();
                    break;
                }
                case "4": {
                    processGetByColorRequest();
                    break;
                }
                case "5": {
                    processGetByMileageRequest();
                    break;
                }
                case "6": {
                    processGetByVehicleTypeRequest();
                    break;
                }
                case "7": {
                    processGetAllVehiclesRequest();
                    break;
                }
                case "8": {
                    System.exit(0);
                }
            }
        }
    }

    public void processGetByPriceRequest(double min, double max) {
        dealership.getVehiclesByPrice(min,max);
    }

    public static void processGetByMakeModelRequest() {

    }

    public static void processGetByYearRequest() {


    }

    public static void processGetByColorRequest() {

    }

    public static void processGetByMileageRequest() {


    }

    public static void processGetByVehicleTypeRequest() {


    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public static void processAddVehicleRequest() {


    }

    public static void processRemoveVehicleRequest() {


    }
}
