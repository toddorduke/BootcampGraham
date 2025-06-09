package org.example;

import java.util.Scanner;

public class UserInterface {
    static Scanner sc = new Scanner(System.in);
    static Order newOrder;

    public static void main(String[] args) {

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
                    System.exit(0);
                default:
                    System.out.println("Re-type entry");
                    break;
            }
        }

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

                    break;
                case "2":
                    //  todo add drinks
                    newOrder.addToOrder(display());
                    System.out.println("Drink added to order");
                    break;
                case "3":
                    System.out.println("what type of chips would you like?\n" +
                            "1) Lays\n" +
                            "2) Doritos\n" +
                            "3) sunChips\n");
                    String userChoice = sc.nextLine();
                    if (userChoice.equals("1")) {
                        Chips chips = new Chips("lays");
                        newOrder.addToOrder(chips);
                        System.out.println("your " + chips.toString() + " have been added");
                    } else if (userChoice.equals("2")) {
                        Chips chips = new Chips("Doritos");
                        newOrder.addToOrder(chips);
                        System.out.println("your " + chips.toString() + " have been added");
                    } else {
                        Chips chips = new Chips("Sunchips");
                        newOrder.addToOrder(chips);
                        System.out.println("your " + chips.toString() + " have been added");
                    }

                    break;
                case "4": {
                    checkOut();
                    isOrdering = false;
                    break;

                }
//                case "5":{
//                    OrderItem item = newOrder.removeFromOrder();
//                }
            }
        }
    }


    static void checkOut() {


        for (OrderItem item : newOrder.getItems()) {
            // FileManager.writeReciept(newOrder);
            // System.out.println(item);

            if (item.getClass().getName().equalsIgnoreCase("org.example.sandwich")) {
                Sandwich sand = (Sandwich) item;
                System.out.println("bread type: " + sand.getBreadType());
                System.out.println("bread size: " + sand.getBreadSize());
                for (Topping topping : sand.getAllToppings()) {
                    System.out.print(topping + ", ");
                }
                //  System.out.println(sand.displaySandwich());
            } else {
                   System.out.println(item);
            }
        }
        System.out.println("Total: " + newOrder.calculateOrderTotal());


        System.out.println("Does your order look correct if so type: " +
                "\n1) check out" +
                "\n2) exit");
        int user = Integer.parseInt(sc.nextLine());
        if (user == 1) {
            FileManager.writeReciept(newOrder);
            System.out.println("Thank you for your support till next time human :)");
        } else {
            newOrder = new Order();
        }


    }
}

