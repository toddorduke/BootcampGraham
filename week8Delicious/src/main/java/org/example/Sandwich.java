package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Sandwich {
    Topping topping;
    Meat meat;
    Cheese cheese;
    FreeToppings freeToppings;
    Scanner scanner = new Scanner(System.in);

    private String breadType;
    private int breadSize;
    private ArrayList<TypeOfMeat> meatChoice = new ArrayList<TypeOfMeat>();
    private ArrayList<TypeOfCheese> cheeseChoice;
    private ArrayList<Sauce> sauceChoice;
    private ArrayList<FreeToppings> freeToppingChoice;
    private double sandwichTotal;

    public Sandwich(String breadType, int breadSize, ArrayList<TypeOfMeat> meatChoice, ArrayList<TypeOfCheese> cheeseChoice, ArrayList<Sauce> sauceChoice, ArrayList<FreeToppings> freeToppingChoice, double sandwichTotal) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.meatChoice = meatChoice;
        this.cheeseChoice = cheeseChoice;
        this.sauceChoice = sauceChoice;
        this.freeToppingChoice = freeToppingChoice;
        this.sandwichTotal = sandwichTotal;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public int getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(int breadSize) {
        this.breadSize = breadSize;
    }

    public void setSandwichTotal(double sandwichTotal) {
        this.sandwichTotal = sandwichTotal;
    }

    public void addFreeTopping() {
        System.out.println("What would you like your toppings to be?");
        System.out.println("1.) lettuce,\n" + " 2.)peppers,\n" + " 3.)onions,\n" + " 4.)tomatoes,\n" +
                " 5.)jalapenos,\n" + " 6.)cucumbers,\n" + " 7.)pickles,\n" + " 8.)guacamole,\n" + " 9.)mushrooms;\n");
        Integer userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice){
            case 1:{
                freeToppingChoice.add(FreeToppings.lettuce);
            }
            case 2:{
                freeToppingChoice.add(FreeToppings.peppers);
            }
            case 3:{
                freeToppingChoice.add(FreeToppings.onions);
            }
            case 4:{
                freeToppingChoice.add(FreeToppings.tomatoes);
            }
            case 5:{
                freeToppingChoice.add(FreeToppings.jalapenos);
            }
            case 6:{
                freeToppingChoice.add(FreeToppings.cucumbers);
            }
            case 7:{
                freeToppingChoice.add(FreeToppings.pickles);
            }
            case 8: {
                freeToppingChoice.add(FreeToppings.guacamole);
            }
            case 9:{
                freeToppingChoice.add(FreeToppings.mushrooms);
            }
        }
        setSandwichTotal(FreeToppings.getPrice());
    }

    public void addMeat(int breadSize) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What kind of meat would you like?");
        System.out.println("choose your option");
        System.out.println("1.)steak\n " + "2.) salami\n" + "3.)ham \n " + "4.)bacon\n " + "5.)chicken\n " + "6.)roast beef\n ");
        int userchoice = Integer.parseInt(scanner.nextLine());
        switch (userchoice) {
            case 1: {
                meatChoice.add(TypeOfMeat.steak);
                break;
            }
            case 2: {
                meatChoice.add(TypeOfMeat.salami);
                break;
            }
            case 3: {
                meatChoice.add(TypeOfMeat.ham);
                break;
            }
            case 4: {
                meatChoice.add(TypeOfMeat.bacon);
                break;
            }
            case 5: {
                meatChoice.add(TypeOfMeat.chicken);
                break;
            }
            case 6: {
                meatChoice.add(TypeOfMeat.roastBeef);
                break;
            }
        }
        setSandwichTotal(getTotalPrice() + meat.getMeatPrice(breadSize));
    }

    public void addCheese(int breadSize) {

        System.out.println("choose your type of Cheese you'd like");
        System.out.println("1.) American\n " + "2.) Provoline\n" + "3.) Chedder\n" + "4.) Swiss \n");
        int userinput = Integer.parseInt(scanner.nextLine());

        switch (userinput) {
            case 1: {
                cheeseChoice.add(TypeOfCheese.american);
                break;
            }
            case 2: {
                cheeseChoice.add(TypeOfCheese.provolone);
                break;
            }
            case 3: {
                cheeseChoice.add(TypeOfCheese.cheddar);
                break;
            }
            case 4: {
                cheeseChoice.add(TypeOfCheese.swiss);
                break;
            }
        }
        setSandwichTotal(cheese.getCheesePrice(breadSize));
    }

    public void addSauce() {

        System.out.println("what type of sauce would you look?");
        System.out.println("1.)mayo,\n" + " 2.) mustard,\n" + " 3.)ketchup,\n" + " 4.)ranch,\n" + " 5.)thousand islands,\n" + " 6.)vinaigrette;\n");
        int userChoice = Integer.parseInt(scanner.nextLine());
        switch (userChoice){
            case 1:{
                sauceChoice.add(Sauce.mayo);
                break;
            }
            case 2:{
                sauceChoice.add(Sauce.mustard);
                break;
            }
            case 3:{
                sauceChoice.add(Sauce.ketchup);
                break;
            }
            case 4:{
                sauceChoice.add(Sauce.ranch);
                break;
            }
            case 5: {
                sauceChoice.add(Sauce.thousandIslands);
                break;
            }
            case 6:{
                sauceChoice.add(Sauce.vinaigrette);
            }
        }
        setSandwichTotal(0);
    }

    public void removeTopping(String topping) {

    }

    public double getTotalPrice() {

        return 0;
    }
}
