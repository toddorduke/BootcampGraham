package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Get monthly payment from user
//        System.out.print("Enter the monthly payout amount: ");
//        double PMT = scanner.nextDouble();
//
//        // Get annual interest rate from user (e.g., 2.5 for 2.5%)
//        System.out.print("Enter the annual interest rate (in %): ");
//        double annualRate = scanner.nextDouble() / 100;
//
//        // Get number of years from user
//        System.out.print("Enter the number of years: ");
//        int years = scanner.nextInt();
//
//        // Calculate number of months and monthly interest rate
//        // n = total month payment
//        int n = years * 12;
//        double r = annualRate / 12;
//
//        // Calculate present value
//        double presentValue = PMT * (1 - Math.pow(1 + r, -n)) / r;
//
//        // Display result
//        System.out.printf("Present value of the annuity: $%.2f%n", presentValue);
//    }
//}

//import java.math.BigDecimal;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("what is your monthly payout?");
        BigDecimal MonPay = scanner.nextBigDecimal();

        System.out.println("What is your expected interest?");
        BigDecimal expInt = scanner.nextBigDecimal();

        System.out.println("Year payout ot user");
        int yearpay = scanner.nextInt();
u

        // Convert to months and monthly interest rate
        int n = yearpay * 12;
        BigDecimal monthlyRate = expInt.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);

        // (1 + r)
        BigDecimal onePlusR = BigDecimal.ONE.add(monthlyRate);

        // (1 + r)^-n
        BigDecimal powValue = BigDecimal(onePlusR.doubleValue(10));
        BigDecimal discountFactor = BigDecimal.valueOf(1 - powValue);

        // Present Value = PMT × [1 - (1 + r)^-n] / r
        BigDecimal presentValue = MonPay.multiply(discountFactor).divide(monthlyRate, 2, RoundingMode.HALF_UP);

        // Output
        System.out.printf("Present value of the annuity: $%.2f%n", presentValue);
    }
}
//Example: To fund an annuity that pays $3,000 monthly for 20
//years and earns an expected 2.5% interest, you would need to
//invest $566,141.46 today.

//    }
//}