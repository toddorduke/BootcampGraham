package org.example;

import java.io.*;

public class ContractFileManager {

    private final String filePath = "src/main/resources/Contract.csv";

    // Append a contract (vehicle data) to the CSV file

    //
    public void appendContractToFile(Contract contract) {
        Vehicle vehicle = contract.getvehicle();

        try {
            FileWriter fw = new FileWriter(filePath, true);

            if (contract instanceof SalesContract) {

                ((SalesContract) contract).getTotalPrice();


                //20210928|Dana Wyatt|dana@texas.com|10112|1993|
                //Ford|Explorer|SUV|Red|525123|995.00|
                //49.75|100.00|295.00|1439.75|NO|0.00

                fw.write("Sale" + "|"+ contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "| +" + vehicle.getVin() +
                        "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|"  + vehicle.getVehicleType() + "|" + vehicle.getColor()
                + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee()
                + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + 0.00 + "\n");

                fw.close();

            } else {
                //LEASE|20210928|Zachary Westly|zach@texas.com|37846|2021|
                //Chevrolet|Silverado|truck|Black|2750|31995.00|
                //15997.50|2239.65|18337.15|541.39
                ((LeaseContract) contract).getMonthlyPayment();
                fw.write("Sale" + "|"+ contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "| +" + vehicle.getVin() +
                        "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getMake() + "|"  + vehicle.getVehicleType() + "|" + vehicle.getColor()
                        + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + ((LeaseContract) contract).getEndingValue()
                        + "|" + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment() + "\n");
                fw.close();
            }

        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    // Optional: Read and display contracts
    public void readContractsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Contracts List:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
