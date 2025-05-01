package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello welcome banking farm.");
            System.out.println("choose your options:\n" +
                    "A.) Make a depsoit\n" +
                    "B.) Make a payment\n" +
                    "C.) Show ledger\n" +
                    "D.) Exit System");

            String userInput = scanner.nextLine().toUpperCase();
            switch (userInput) {
                case "A": {
                    addDeposit();
                    break;
                }
                case "B": {
                    doPayment();
                    break;
                }
                case "C": {
                    reportList();
                    break;
                }
                case "D": {
                    System.exit(0);
                    break;
                }
            }

        }
    }

    public static void addDeposit() {
        Scanner scanner = new Scanner(System.in);
        TransactionFIleManager fIleManager = new TransactionFIleManager();

        System.out.println("How much would you like  to deposit?");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the descripition?");
        String description = scanner.nextLine();
        System.out.println("Who is the vendor?");
        String vendor = scanner.nextLine();
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        String entry = transaction.toString();
        System.out.println(entry);
        System.out.println("Thank you for your deposit");

        fIleManager.appendTransaction(transaction);
    }

    public static void doPayment() {
        Scanner scanner = new Scanner(System.in);
        TransactionFIleManager fIleManager = new TransactionFIleManager();

        System.out.println("How much is your payment");
        double payment = Double.parseDouble(scanner.nextLine());
        System.out.println("What is the descripition?");
        String description = scanner.nextLine();
        System.out.println("Who is the vendor?");
        String vendor = scanner.nextLine();
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        Transaction transaction = new Transaction(date, time, description, vendor, payment * -1);
        String entry = transaction.toString();
        System.out.println(entry);


        System.out.println("Your Payment was sent.");
        fIleManager.appendTransaction(transaction);

    }

    public List<Transaction> vendorSearch(List<Transaction> transactions) {
        Scanner scanner = new Scanner(System.in);
        for (Transaction transaction : transactions) {
            System.out.println("Please enter the vendor name.");
            String vendor = scanner.nextLine();
            if (transaction.getVendor().toLowerCase().contains(vendor.toLowerCase())) {
                String row = transaction.toString();
                System.out.println(row);
            } else {
                System.out.println("Sorry vendor not found");
            }
        }
        return transactions;

    }

    public static List<Transaction> reportList() {
        TransactionFIleManager fIleManager = new TransactionFIleManager();
        Ledger ledger = new Ledger();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello welcome to your ledger");
            System.out.println("choose your option:\n" +
                    "A.) Display all entries \n" +
                    "B.) Display your deposits\n" +
                    "C.) Display your payments\n" +
                    "D.)reports\n");

            String userinput = scanner.nextLine().toUpperCase();
            switch (userinput) {
                case "A": {
                    List<Transaction> transaction = TransactionFIleManager.readFile();
                    ledger.showAllEntries(transaction);
                    break;
                }
                case "B": {
                    List<Transaction> transaction = fIleManager.readFile();
                    ledger.showDeposit(transaction);
                    break;
                }
                case "C": {
                    List<Transaction> transaction = fIleManager.readFile();
                    Ledger.showPayments(transaction);
                    break;
                }
                case "D": {
boolean found = false;
                    while (true) {
                        System.out.println("These are your report options");
                        System.out.println("A: last seven days\n" +
                                "B: last month\n" +
                                "C: last year\n" +
                                "D: search by vendor\n" +
                                "E: back to last menu\n");
                        String userin = scanner.nextLine().toUpperCase();
                        switch (userin) {
                            case "A": {
                                ledger.getLastSevenDays();
                                break;
                            }
                            case "B": {
                                ledger.getMonthToDate();
                            }
                            case "C": {
                                ledger.getYearToDate();
                            }
                            case "D": {
                                System.out.println("Please provide the vendors name");
                                String name = scanner.nextLine();
                                ledger.vendorSearch(name);
                                break;
                            }
                            case "E": {
                             found =false;
                            }

                        }
                    }
                }
            }
        }
    }
}



