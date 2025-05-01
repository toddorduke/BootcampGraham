package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Ledger {
    Scanner scanner = new Scanner(System.in);


    public Ledger() {

    }

    //         reports run custom search
    public List<Transaction> vendorSearch(String vendor) {
        List<Transaction> transactions = TransactionFIleManager.readFile();
        boolean foundVendor = false;

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().toLowerCase().contains(vendor.toLowerCase())) {
                foundVendor = true;
                String row = transaction.toString();
                System.out.println(row);
            }
        }if (!foundVendor){
            System.out.println("vendor not found");
        }
        return transactions;
    }

    //todo show all payments only negative
    public static void showPayments(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                String row = transaction.toString();

                //todo add remove payment.
                System.out.println(row);
            }
        }
    }


    public void showDeposit(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                String row = transaction.toString();
                System.out.println(row);
            }
        }
    }


    public List<Transaction> showAllEntries(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {

            String row = transaction.toString();

            System.out.println(row);
        }
        return transactions;
    }

    //get transcation1yeartodate
    public void getMonthToDate() {
        List<Transaction> transactions = TransactionFIleManager.readFile();
        LocalDate now = LocalDate.now();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(now.minusMonths(1))) {
                String row = transaction.toString();
                System.out.println(row);
            }
        }
    }

    public void getLastSevenDays() {
        List<Transaction> transactions = TransactionFIleManager.readFile();
        LocalDate now = LocalDate.now();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(now.minusDays(7))) {
                String row = transaction.toString();
                System.out.println(row);
            }
        }
    }


    public void getYearToDate() {
        List<Transaction> transactions = TransactionFIleManager.readFile();
        LocalDate now = LocalDate.now();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(now.minusYears(1))) ;
            String row = transaction.toString();
            System.out.println(row);
        }
    }
    public void userVendorSearch(String vendor, String name){
        List<Transaction> transactions = TransactionFIleManager.readFile();
        for (Transaction transaction : transactions){
            if (transaction.getVendor().toLowerCase().contains(vendor.toLowerCase())){
                if (transaction.getVendor().toLowerCase().contains(name.toLowerCase()))
                vendorSearch(name);
                transactions.toString();
                System.out.println(vendor);
            }
        }
    }

}


