package org.example;

import java.util.Scanner;

import static org.example.Main.newOrder;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);
    static Order newOrder;

    public static void main(String[] args) {
        //1 SandWichScreen sandWichScreen = new SandWichScreen();

        boolean isRunning = true;
        newOrder = new Order();

        while (isRunning) {

            System.out.println("Welcome! Would you like to place an order?");
            System.out.println("1) Start Order");
            System.out.println("2) Exit");

            String selection = sc.nextLine();

            switch (selection) {
                case "1"://start new order
                    startOrder();
                    break;
                case "2"://exit application
                    System.out.println("Thank you! Have a great day!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Re-type entry");
                    break;
            }
            throw new IllegalArgumentException("Retry the option provided");
            // end if the switch statement


        } // end of the while-loop

    }

    static Drink display() {
        System.out.println("What drink would you like?");
        System.out.println("""
                1)Small
                2)Medium
                3)Large
                
                """);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                return new Drink(Size.small);

            case 2:
                return new Drink(Size.medium);

            case 3:
                return new Drink(Size.large);

            default:
                System.out.println("Defaulting to Medium");
                return new Drink(Size.medium);
        }
    }

    static void startOrder() {

        boolean isOrdering = true;

        while (isOrdering) {
            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    """);

            String selection = sc.nextLine();
            switch (selection) {

                case "1":
                    newOrder.addToOrder(SandWichScreen.buildSandwich());
//                    // we could create a Sandwich view
//                    Sandwich sandwich = new Sandwich("White", Size.medium);
//                    sandwich.addTopping(new Meat(TypeOfMeat.roastBeef));
//                    sandwich.addTopping(new Cheese(TypeOfCheese.provolone));
//                    sandwich.addTopping(new FreeTopping(TypeOfFreeToppings.lettuce));
//                    newOrder.addToOrder(sandwich);
//                    System.out.println("Sandwich Added to order");
                    break;
                case "2":
                    // add drinks
                    newOrder.addToOrder(display());
                    System.out.println("Drink added to order");
                    break;
                case "3":
                    newOrder.addToOrder(chips.Lays);
                    System.out.println("chips added to order");
                    break;
                case "4": {

                    checkOut();
                    // System.out.println(newOrder);
//                    for (OrderItem item : newOrder.getItems()) {
//
////                         we did this to see how we can remove the square bracket from our
////                        list of Toppings on our Sandwich
//                        if (item.getClass().getName().equalsIgnoreCase("org.example.sandwich")) {
//                            Sandwich sand = (Sandwich) item;
//                            System.out.println(sand.getBreadType());
//                            System.out.println(sand.getBreadSize());
//                            for (Topping topping : sand.getAllToppings()) {
//                                System.out.print(topping + ", ");
//                            }
//                            // Sandwich sand = (Sandwich) item;
//                          //  System.out.println(sand.displaySandwich());
//                        } else {
//                            System.out.println(item);
//                        }
//                    }
//                    System.out.println(newOrder.calculateOrderTotal());

                    //case 5 (cancel)
                    //default
                    break;

                } // end of switch statement
            } //end of while loop
        }
    }

    static double checkOut() {
     //   System.out.println(newOrder);
        for (OrderItem item : newOrder.getItems()) {

//                         we did this to see how we can remove the square bracket from our
//                        list of Toppings on our Sandwich
            if (item.getClass().getName().equalsIgnoreCase("org.example.sandwich")) {
                Sandwich sand = (Sandwich) item;
                System.out.println(sand.getBreadType());
                System.out.println(sand.getBreadSize());
                for (Topping topping : sand.getAllToppings()) {
                    System.out.print(topping + ", ");
                }
                // Sandwich sand = (Sandwich) item;
                //  System.out.println(sand.displaySandwich());
            } else {
                System.out.println(item);
            }
        }
        System.out.println(newOrder.calculateOrderTotal());
        return display().calculateCost();
    }
}

