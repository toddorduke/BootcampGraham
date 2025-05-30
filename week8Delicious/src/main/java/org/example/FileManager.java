package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class FileManager {
    public FileManager() {
    }

    public static void writeReciept(Order order) {
//fileWriter
        //local date.now


        String dir = "src/main/resources/receipts/";

        File filePath = new File(dir,createFileName());
        try (FileWriter writer = new FileWriter(filePath)){


         writer.write(String.valueOf(LocalDate.now()) + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) );
         for(OrderItem item: order.getItems()){
             writer.write(item.printToReceipt() + "\n");
         }

       //  write.close();
         //order.getitems loop through items
            //print

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String createFileName(){

        LocalDateTime currentDate = LocalDateTime.now();

        StringBuilder fileName = new StringBuilder();

        System.out.println(currentDate.toLocalDate());

        //date
        for (String dateString: currentDate.toLocalDate().toString().split("-")){
            fileName.append(dateString);
        }

        fileName.append("-");

        //time
        for (String timeString: currentDate.toLocalTime().truncatedTo(ChronoUnit.SECONDS).toString().split(":")){
            fileName.append(timeString);
        }
        fileName.append(".txt");

        return fileName.toString();
    }
}

