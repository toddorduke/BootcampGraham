package org.example;

import java.util.Objects;
import java.util.Scanner;

public class SandWichScreen {
    static Scanner sc = new Scanner(System.in);

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("""
//                "Welcome to build a bear SandWich shop!
//                 Thank you for supporting
//                 now start your order.
//                """);
//        buildSandwich();
//    }

    public static Size breadSize(Size size) {
        //Scanner sc = new Scanner(System.in);
        System.out.println("your size has been added: " + size);
        return size;
    }

    public static String breadType() {
        // Scanner sc = new Scanner(System.in);
        String[] breadTypes = {"white", "wheat", "rye", "wrap"};

        System.out.println("What type of bread would you like?");
        for (int i = 0; i < breadTypes.length; i++) {
            System.out.println((i + 1) + ") " + breadTypes[i]);
        }

        int userInput = Integer.parseInt(sc.nextLine());

        if (userInput < 1 || userInput > breadTypes.length) {
            System.out.println("Invalid selection. Defaulting to white.");
            return "white";
        }

        String selectedBread = breadTypes[userInput - 1];
        System.out.println("You have added: " + selectedBread);
        return selectedBread;

    }

    public static TypeOfMeat addMeatTopping() {

        //   Scanner sc = new Scanner(System.in);
        System.out.println("For your first meat what would you like?\n" +
                """
                         1)steak,
                         2)ham,
                         3)salami,
                         4)roastBeef,
                         5)chicken,
                         6)bacon
                        """);
        int userInput = Integer.parseInt(sc.nextLine());
        TypeOfMeat selected;
        if (userInput == 1) {
            selected = TypeOfMeat.steak;
        } else if (userInput == 2) {
            selected = TypeOfMeat.ham;
        } else if (userInput == 3) {
            selected = TypeOfMeat.salami;
        } else if (userInput == 4) {
            selected = TypeOfMeat.roastBeef;
        } else if (userInput == 5) {
            selected = TypeOfMeat.chicken;
        } else {
            selected = TypeOfMeat.bacon;

        }
        System.out.println("You have chosen: " + selected);

        System.out.println("would you like to add extra Meat?");
        int userchoice = Integer.parseInt(sc.nextLine());

        return selected;
    }

    public static TypeOfCheese addCheese() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("choose your type of Cheese you'd like");
        System.out.println("1.) American\n " + "2.) Provoline\n" + "3.) Chedder\n" + "4.) Swiss \n");
        int userinput = Integer.parseInt(scanner.nextLine());
        TypeOfCheese seleteced;
        switch (userinput) {
            case 1: {
                seleteced = TypeOfCheese.american;
                Cheese cheese = new Cheese(seleteced);
                System.out.println("you chosen: " + cheese);
                return seleteced;
            }
            case 2: {
                seleteced = TypeOfCheese.provolone;
                Cheese cheese = new Cheese(seleteced);
                System.out.println("you chosen: " + cheese);
                return seleteced;
            }
            case 3: {
                seleteced = TypeOfCheese.cheddar;
                Cheese cheese = new Cheese(seleteced);
                System.out.println("you chosen: " + cheese);
                return seleteced;
            }
            case 4: {
                seleteced = TypeOfCheese.swiss;
                Cheese cheese = new Cheese(seleteced);
                System.out.println("you chosen: " + cheese);
                return seleteced;
            }
        }
        return null;
    }

    public static TypeOfFreeToppings addFreeTopping() {
        Scanner sc = new Scanner(System.in);
        TypeOfFreeToppings selected;
        System.out.println("what kind of topping would you like?" +
                """
                        1)lettuce,
                        2)peppers,
                        3)onions,
                        3)tomatoes,
                        4)jalapenos,
                        5)cucumbers,
                        6)pickles,
                        7)guacamole,
                        8)mushrooms;
                        """);
        int userInput = Integer.parseInt(sc.nextLine());

        if (userInput == 1) {
            selected = TypeOfFreeToppings.lettuce;

        } else if (userInput == 2) {
            selected = TypeOfFreeToppings.peppers;
        } else if (userInput == 3) {
            selected = TypeOfFreeToppings.onions;
        } else if (userInput == 4) {
            selected = TypeOfFreeToppings.jalapenos;
        } else if (userInput == 5) {
            selected = TypeOfFreeToppings.cucumbers;
        } else if (userInput == 6) {
            selected = TypeOfFreeToppings.pickles;
        } else if (userInput == 7) {
            selected = TypeOfFreeToppings.guacamole;
        } else {
            selected = TypeOfFreeToppings.mushrooms;
        }
        return selected;
    }

    public static TypeOfSauce addSauce() {
        TypeOfSauce selected;
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                    1)mayo
                
                    2)mustard
                
                    3)ketchup
                
                    4)ranch
                
                    5)thousand Islands
                 
                    6)vinaigrette
                
                """);
        int userInput = Integer.parseInt(sc.nextLine());
        if (userInput == 1) selected = TypeOfSauce.mayo;
        else if (userInput == 2) selected = TypeOfSauce.mustard;
        else if (userInput == 3) selected = TypeOfSauce.ketchup;
        else if (userInput == 4) selected = TypeOfSauce.ranch;
        else if (userInput == 5) selected = TypeOfSauce.thousandIslands;
        else {
            selected = TypeOfSauce.vinaigrette;

            System.out.println("you selected: " + selected);

        }
        return selected;
    }
    public static double getExtraCheese(Size size){
        System.out.println("""
                small
                medium
                large
                """);
        String userInput = sc.nextLine();
        size = Size.valueOf(userInput);
        return switch (size) {
            case small -> .30;
            case medium -> .60;
            case large -> .90;
        };
    }

    public static double getExtraMeatPrize(Size size) {
        System.out.println("""
                small\n
                medium\n
                large\n
                """);
        String userSize = sc.nextLine();
        size = Size.valueOf(userSize);
        switch (size) {
            case small:
                return .50;
            case medium:
                return 1.00;
            case large:
                return 1.50;
            default: break;
        }

        return 0;
    }

    public static Sandwich buildSandwich() {
        Sandwich sandwich = null;

        Scanner sc = new Scanner(System.in);
        boolean isBuildingSandwich = true;

        while (isBuildingSandwich) {
            System.out.println("what size bread would you like: " +
                    " small medium large");
            String input = sc.nextLine();
            Size size = Size.valueOf(input);
            Size sizeToAdd = breadSize(size);

            String breadType = breadType();

            sandwich = new Sandwich(breadType, sizeToAdd);

            boolean stillHungry = true;

            while (stillHungry) {

                System.out.println("lets build your sandwich\n");
                System.out.println("""
                        1) choose your meat\n
                        2) choose your cheese\n
                        3) add your vegetable's\n
                        4) add your sauce\n
                        5) Go back to main\n
                        6) show all toppings\n
                        7) add extra meat\n
                        8) add extra cheese\n
                        """);
                int userInput = Integer.parseInt(sc.nextLine());
                switch (userInput) {
                    case 1: {
                        TypeOfMeat meat = addMeatTopping();
                        // todo add topping to sandwich
                        Meat meatToAdd = new Meat(meat);
                        sandwich.addTopping(meatToAdd);
                        break;

                    }
                    case 2: {

                        TypeOfCheese cheese = addCheese();
                        Cheese addcheese = new Cheese(cheese);
                        sandwich.addTopping(addcheese);
                        break;
                    }
                    case 3: {
                        TypeOfFreeToppings freeTop = addFreeTopping();
                        FreeTopping addFree = new FreeTopping(freeTop);
                        sandwich.addTopping(addFree);
                        ;
                        break;
                    }
                    case 4: {

                        TypeOfSauce sauceToAdd = addSauce();
                        Sauce addSauce = new Sauce(sauceToAdd);
                        sandwich.addTopping(addSauce);
                        break;
                    }
                    case 5: {
                        // System.exit(0);
                        stillHungry = false;
                        isBuildingSandwich = false;
                        break;
                    }
                    case 6: {
                        sandwich.getAllToppings();
                    }
                    case 7: {
                        getExtraMeatPrize(size);
                    }
                    case 8:{
                        getExtraCheese(size);
                    }
                }
            }
        }
        return sandwich;
    }
}


////                    case 1: {
////                        System.out.println("what size bread would you like: " +
////                                " small medium large");
////                        String input = sc.nextLine();
////                        Size size = Size.valueOf(input);
////                        Size sizeToAdd = breadSize(size);
////                        sandwich.setBreadSize(sizeToAdd);
////
////                        break;
////                    }
////                    case 2: {
////                        String breadType = breadType();
////                        //add topping to sandWich
////                        sandwich.setBreadType(breadType);
////                        break;
////                    }
//                    case 3: {
//
//                        break;
//                    }
