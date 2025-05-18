package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DealershipFileManager {

    public DealershipFileManager() {
    }

    public static DealerShip getDealership() {
        DealerShip dealerShip = new DealerShip("","","");

        String inputFilePath = "src/main/resources/inventory.csv"; // CSV file to read


        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            boolean firstLine = true;
            String line;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    //todo get the line extract name,phone,address
                    String[] dealership = line.split("\\|");
                    //D & B Used Cars|111 Old Benbrook Rd|817-555-5555
                    System.out.println(Arrays.toString(dealership));
                    //asging values to the class properties
                    dealerShip.setName(dealership[0].trim());
                    dealerShip.setAddress(dealership[1].trim());
                    dealerShip.setPhone(dealership[2].trim());

                    firstLine = false;

                }

                else{
                    //for inventory
                    //Todo fix asign properties
                    List<Vehicle> vehicles = new ArrayList<>();
                    String[] inventory = line.split("\\|");
           //         System.out.println(Arrays.toString(inventory));
                    //asging values to the class properties

                    try {
                        Vehicle vehicle = new Vehicle();
                        vehicle.setVin(Integer.parseInt(inventory[0]));
                        vehicle.setYear(Integer.parseInt(inventory[1]));
                        vehicle.setMake(inventory[2]);
                        vehicle.setModel(inventory[3]);
                        vehicle.setVehicleType(VehicleType.valueOf(inventory[4].toUpperCase()));
                        vehicle.setColor(inventory[5]);
                        vehicle.setOdometer(Double.parseDouble(inventory[6]));
                        vehicle.setPrice(Double.parseDouble(inventory[7]));
                        vehicles.add(vehicle);
                        dealerShip.addVehicle(vehicle);

                    }
                    catch(Exception e){
                        System.out.println("error reading line");
                        continue;

                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
        }
        return dealerShip;
    }

    public void saveDealership(DealerShip dealerShip) {

       //  is not in append mode it will overwrite the whole file
        try{
            FileWriter fw = new FileWriter("src/main/resources/inventory.csv");

            fw.write(dealerShip.getName() + "|" + dealerShip.getAddress() + "|" + dealerShip.getPhone());
            //loop thorug dealreship vehciles
            for(Vehicle vehicle : dealerShip.getAllVehicles()){
                fw.write(vehicle.toString());

            }
            fw.close();
        }
        catch(Exception e){
            System.out.println("information was not saved.");
        }


    }
}
