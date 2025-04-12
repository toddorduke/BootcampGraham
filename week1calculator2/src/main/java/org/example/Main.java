package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Accept the initial deposit (P), annual interest rate (r), and number of years (t) from the user as input.
        Scanner scanner = new Scanner(System.in);

        float userInputP;
            while (true) {
                System.out.println("Input deposit amount");
               if (scanner.hasNextFloat()) {
                   userInputP = scanner.nextFloat();
                   break;
               }
            }
        double userInputr;
            while (true) {
            System.out.println("Input your annual interset rate.") ;
            if (scanner.hasNextDouble()) {
                userInputr = scanner.nextDouble() / 100;
                break;
            }
        }
        float userInputT;
            while (true) {
                System.out.println("Input the number of years");
                if (scanner.hasNextFloat());
                userInputT = scanner.nextFloat();
                break;
            }
            //FV = P × (1 + (r / 365))^(365 × t)
        //Future Value (FV)
        // Days Per Year: Daily compounding assumes 365 days per year.
        //Total Number of Days: This is 365 × t (because there are 365 days per year).
        //• Total Interest Earned = FV - P
        //        double futureValue = principal * Math.pow((1 + (annualRate / 365)), (365 * years));
        double futureValue =userInputP * Math.pow((1+(userInputr/365)), (365 * userInputT));
            double totalInterestEarned = futureValue - userInputP;

        System.out.printf("Your future %1f", futureValue);
        System.out.printf("Your total interest earned %2f",totalInterestEarned);
        //Example: If you deposit $1,000 in a CD that earns 1.75%
        //interest and matures in 5 years, your CD's ending balance will
        //be $1,092.62 and you would have earned $92.62 in interest
    }
}