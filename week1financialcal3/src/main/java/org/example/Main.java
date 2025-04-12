package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get monthly payment from user
        System.out.print("Enter the monthly payout amount: ");
        double PMT = scanner.nextDouble();

        // Get annual interest rate from user (e.g., 2.5 for 2.5%)
        System.out.print("Enter the annual interest rate (in %): ");
        double annualRate = scanner.nextDouble() / 100;

        // Get number of years from user
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate number of months and monthly interest rate
        // n = total month payment
        int n = years * 12;
        double r = annualRate / 12;

        // Calculate present value
        double presentValue = PMT * (1 - Math.pow(1 + r, -n)) / r;

        // Display result
        System.out.printf("Present value of the annuity: $%.2f%n", presentValue);
    }
}
import java.math.BigDecimal;
import java.util.Scanner;

class AnnuityCalculatorSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input from user
        System.out.println("Enter monthly payout amount (e.g., 3000):");
        BigDecimal monthlyPayout = scanner.nextBigDecimal();

        System.out.println("Enter annual interest rate (e.g., 2.5 for 2.5%):");
        BigDecimal annualRate = scanner.nextBigDecimal().divide(BigDecimal.valueOf(100));

        System.out.println("Enter number of years:");
        int years = scanner.nextInt();
        int months = years * 12;

        // Monthly interest rate
        BigDecimal monthlyRate = annualRate.divide(BigDecimal.valueOf(12));

        // Calculate (1 + r)^-n
        double base = BigDecimal.ONE.add(monthlyRate).doubleValue();
        double powerResult = Math.pow(base, -months); // (1 + r)^-n

        // (1 - (1 + r)^-n) / r
        BigDecimal numerator = BigDecimal.valueOf(1 - powerResult);
        BigDecimal denominator = monthlyRate;

        BigDecimal presentValue = monthlyPayout.multiply(numerator.divide(denominator));

        // Show result
        System.out.printf("You would need to invest: $%.2f today.%n", presentValue);
//    }
//}