package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    DealerShip dealership;

    public UserInterface() {
        init();
    }

//    public void addcontract(Contract contract) {
//this.contract.add(contract);
//    }


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
                    "10.) remove vehicle\n" +
                    "11.) Purchase a vehicle\n" +
                    "12.) Lease vehicle");


            try {
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
                        System.out.println("What is your make");
                        String make = scanner.nextLine();
                        System.out.println("What is your model");
                        String model = scanner.nextLine();
                        processGetByMakeModelRequest(make, model);
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
                        VehicleType vehicleType = VehicleType.valueOf(name.toUpperCase());
                        processGetByVehicleTypeRequest(vehicleType);
                        break;
                    }
                    case "7": {
                        processGetAllVehiclesRequest();
                        break;
                    }
                    case "8": {
                        System.exit(0);
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
                    case "11": {
                        //todo create sale option
                        System.out.println("What is the vin number?");
                        int vin = Integer.parseInt(scanner.nextLine());
                        Vehicle vehicle = processFindByVin(vin);

                        System.out.println("Today's Date");
                        String date = scanner.nextLine();
                        System.out.println("What is your name?");
                        String name = scanner.nextLine();
                        System.out.println("What is your email?");
                        String email = scanner.nextLine();
                        saleCar(name, date, email, vehicle);

                        break;
                    }
                    case "12": {
                        //todo creat leaes option
                        System.out.println("What is the vin number?");
                        int vin = Integer.parseInt(scanner.nextLine());
                        Vehicle vehicle = processFindByVin(vin);

                        System.out.println("Today's Date");
                        String date = scanner.nextLine();
                        System.out.println("What is your name?");
                        String name = scanner.nextLine();
                        System.out.println("What is your email?");
                        String email = scanner.nextLine();
                        leaseSale(date,name,email,vehicle);
                        //connecto to Leasecontract
                    }
                    default:
                        System.out.println("invalid respond try again choose numbers between 1-12");

                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number provided.");
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

    public Vehicle processFindByVin(int vin) {
        Vehicle foundvehicle = dealership.searchByVin(vin);
        System.out.println(foundvehicle);
        return foundvehicle;
    }

//    public void customerContact(String name, String date, String email, Vehicle vehicle) {
//        SalesContract customer = new SalesContract(date, name, email);
//
//
//    }

    public void saleCar(String name, String date, String email, Vehicle vehicle) {
        ContractFileManager contractFileManager = new ContractFileManager();
        //make sales contract
        //usefile manager to write tot the file
        //send message
        SalesContract salesContract = new SalesContract(date, name, email, vehicle);
        contractFileManager.appendContractToFile(salesContract);
        System.out.println("Thank you for your purchase");
    }

    public void leaseSale(String date, String name, String email, Vehicle vehicle) {
        ContractFileManager contractFileManager = new ContractFileManager();
        LeaseContract leaseContract = new LeaseContract(date, name, email, vehicle);
        contractFileManager.appendContractToFile(leaseContract);
        System.out.println("Thank you for leasing a vehicle with us");
    }


}