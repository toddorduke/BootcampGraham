package org.example;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DealershipFileManager {

    public DealershipFileManager() {
    }

    public static DealerShip getDealership() {
        DealerShip dealerShip = new DealerShip("","","");
        Vehicle vehicle = new Vehicle();
        String inputFilePath = "src/main/resources/inventory.csv"; // CSV file to read
        String outputFilePath = "src/main/resources/inventory.txt"; // Text file to write to


        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            boolean firstLine = true;
            String line;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    //todo get the line extract name,phone,address
                    String[] dealership = line.split("\\|");
                    //D & B Used Cars|111 Old Benbrook Rd|817-555-5555
                    System.out.println(Arrays.toString(dealership));
                    //asging values to the class properties
                    dealerShip.setName(dealership[0]);
                    dealerShip.setAddress(dealership[1]);
                    dealerShip.setPhone(dealership[2]);
                    System.out.println(dealerShip.getAddress());
                    firstLine = false;
                }
                else{
                    //for inventory
                    //Todo fix asign properties
                    List<Vehicle> vehicles = new ArrayList<>();
                    String[] inventory = line.split("\\|");
                  //10112|1993|Ford|Explorer|SUV|Red|525123|995.00
                    System.out.println(Arrays.toString(inventory));
                    //asging values to the class properties
                    vehicle.setVin(vehicles[0]);
                    vehicle.setYear(Integer.parseInt(inventory[1]));
                    vehicle.setMake(inventory[2]);
                    vehicle.setModel(inventory[3]);
                    vehicle.setVehicleType(VehicleType.valueOf(inventory[4].toUpperCase()));
                    vehicle.setColor(inventory[5]);
                    vehicle.setOdometer(Double.parseDouble(inventory[6]));
                    vehicle.setPrice(Double.parseDouble(inventory[7]));

                    vehicles.add(vehicle);
                    dealerShip.addVehicle(vehicle);

                    System.out.println(vehicle);
                }
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
        return dealerShip;
    }

    public List<DealerShip> saveDealership(DealerShip dealerShip) {

        return null;
    }
}
