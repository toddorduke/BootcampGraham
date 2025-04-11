package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Accept the principal (P), interest rate (r), and loan length (n) from the user as input.
        //step 1 strng 'what is the principle amount
        //Calculate the monthly interest rate (r) by dividing the annual interest rate by 12 and then dividing by 100 to convert it to a decimal.
        //step 2 float what is the interest rate
        //step 3 string 'what is the length of yor payment'
        //



       // m = p[r(1+r)^n] / [(1+r)^n-1]


        //
        //Calculate the number of monthly payments (n) by multiplying the loan length in years by 12.
        //
        //Use this formula to calculate the monthly payment (M).

       //M = P[r(1+r)^n] / [(1+r)^n-1]
// M is the monthly payment.
//    P is the principal amount (loan amount). float or double
//    r is the monthly interest rate (annual interest rate divided by 12 and then divided by 100 to convert to a decimal).
        //float
//    n is the number of monthly payments (loan length in years multiplied by 12). int
//Use this formula to calculate the total interest paid:
//
//Total Interest = (M * n) - P

//        String p = "Principle";
//        String r ="Interest Rate";
//        String n = "Loan Length";
//        String m = "Monthly Payment's";

        Scanner scanner = new Scanner(System.in);
        System.out.println("what is the principle amount");
        float principle = scanner.nextFloat();

        System.out.println("what is your interest rate");
        float interstRate = scanner.nextFloat();

        System.out.println("what is the loan length");
        int loanLength = scanner.nextInt();

        // System.out.println("your monthly interest rate is " + (interstRate / 12)/100);

    }
}