package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Product> readFile() {


        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //skip the first line
            bufferedReader.readLine();

            String input;

            List<Product> productList = new ArrayList<>();
            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");
                // index 0 is sku, index 1 is proudctname, index 2 is the price, index 3 is department
                String sku = row[0];
                String productName = row[1];
                double price = Double.parseDouble(row[2]);
                String department = row[3];
                Product product = new Product(sku, productName, price, department);
                productList.add(product);
            }
            bufferedReader.close();
            return productList;

        } catch (IOException ex) {
            System.out.println("failed to load csv file.");
            return new ArrayList<>();
        }
    }

}
