package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("what is your favorite number");

        Scanner scanner = new Scanner(System.in);

        int userFirst = scanner.nextInt();
        System.out.println("what is your second favorite number");
        int  userSecond = scanner.nextInt();
        scanner.nextLine();
        System.out.println("what operation would you like to perform?");
String sign = scanner.nextLine();
        switch (sign.toLowerCase()){
            case("A"):
                System.out.println(userFirst+userSecond);
                break;
            case("B"):
                System.out.println(userFirst-userSecond);
                break;
            case("c"):
                System.out.println(userFirst*userSecond);
                break;
            case"d":
                System.out.println(userFirst/userSecond);
                break;

//        int sub = userFirstsub - userSecondSub;
//
//        System.out.println("Give me a number");
//        Scanner scanner1 = new Scanner(System.in);
//        int userFirstsub = scanner.nextInt();
//        System.out.println( "let's do another number");
//        int userSecondSub = scanner.nextInt();
//        System.out.println("now lets subtract the numbers = " + Math.subtractExact(userFirstsub, userSecondSub));

//       // int multiply = userMul * userMul2;

//        System.out.println("give me a number between 1-100");
//        Scanner scanner2 =  new Scanner(System.in);
//        int  userMul = scanner.nextInt();
//        System.out.println("now lets do one between 1 - 50");
//        int  userMul2 = scanner.nextInt();
//        System.out.println("lets multipy the number = " + (userMul * userMul2));
////
//       // int divide = userDiv userDiv2;

//        System.out.println("what is your least favorite number");;
//        Scanner scanner3 = new Scanner(System.in);
//        float userDiv = scanner.nextFloat();
//        System.out.println("give me another number");
//        float userDiv2 = scanner.nextFloat();
//        System.out.println("lets divid your number = " + userDiv / userDiv2);
//
//     String Sign = "Add";
//    switch (sign){
//        case("Add"):
//            System.out.println("you have chose to do addititon your answer is"+ userFirst+userSecond);
//            break;
//        case("B"):
//            break;
//        case("C"):
//            break;
//        case"D":
//            break;

        }
    }





