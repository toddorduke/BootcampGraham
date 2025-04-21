package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float p;
        while (true) {
            System.out.println("what is the principle amount");
            if (scanner.hasNextFloat()) {
                p = scanner.nextFloat();
                break;
            }
        }
        float r;
        while (true) {
            System.out.println("what is your annual interest rate?");
            if (scanner.hasNextFloat()) {
                r = scanner.nextFloat();
                break;
            }
        }
        int years;
        while (true) {
            System.out.println("Enter the loan term in years");
            if (scanner.hasNextInt()) {
                years = scanner.nextInt();
                break;

            }
        }
        int n = years * 12;
        float i = ((r / 12) / 100);

        System.out.println("Your monthly Intrest is $" + i);

        double numerator = i * Math.pow(1 + i, n);
        double denominator = Math.pow(1 + i, n)-1;
        double monthlyPayment = p * (numerator / denominator);

        double totalPayment = monthlyPayment * n;
        double totalInterest = totalPayment - p ;
        System.out.printf("Your monthly payment is: $%.2f\n", monthlyPayment);
        System.out.printf("Your total interest over the loan is: $%.2f\n", totalInterest);

        scanner.close();
    }
}
//Example: A $53,000 loan at 7.625% interest for 15 years would
//have a $495.09/mo payment with a total interest of $36,115.99