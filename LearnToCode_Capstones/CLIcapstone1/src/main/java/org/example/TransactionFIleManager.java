package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//todo Cap CSV
public class TransactionFIleManager {
    public TransactionFIleManager () {};

    public static List<Transaction> readFile() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        try {

            FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //skip the first line
            bufferedReader.readLine();

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");
                // index 0 is sku, index 1 is proudctname, index 2 is the price, index 3 is department
                LocalDate date = LocalDate.parse(row[0]);
                LocalTime time = LocalTime.parse(row[1]);
                String description = row[2];
                String vendor = row[3];
                double amount = Double.parseDouble(row[4]);
                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactions.add(transaction);
            }
            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("File not transfered");
        }
        return transactions;
    }

    public static void appendTransaction(Transaction transactions) {
        String filePath = "src/main/resources/transactions.csv";
        File file = new File(filePath);

        try {
            //step 1: make sure the folder exists
            File folder = file.getParentFile();
            if (!folder.exists()) {
                folder.mkdirs();
            }
// step 2 check if ht file exist and is empty
            boolean fileExists = file.exists();
            boolean isEmpty = !fileExists || file.length() == 0;

            // step 3 open file in append mode
            FileWriter writer = new FileWriter(file, true);

            //step 4: Write header if its's a ne or empty file
            if (isEmpty) {
                writer.write("date|time|description|vendor|amount\n");
            }

            //step 5: Write the transaction
            writer.write(transactions.toString() + "\n");

            //step 6: close the writer
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't write to file.");

        }
    }

}

