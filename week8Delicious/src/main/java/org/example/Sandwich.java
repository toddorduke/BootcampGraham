package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem {

    private String breadType;
    private Size breadSize;
    private List<Topping> toppings;


    public Sandwich(String breadType, Size breadSize) {
        this.breadType = breadType;
        this.breadSize = breadSize;
        this.toppings = new ArrayList<>();
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public Size getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(Size breadSize) {
        this.breadSize = breadSize;
    }

    public List<Topping> getAllToppings() {
for(Topping topping : toppings)
    System.out.println(topping.toString());
        return toppings;
    }

    public void addTopping(Topping topping) {

        this.toppings.add(topping);

    }

    public void removeTopping(Topping topping) {

        this.toppings.remove(topping);
    }

    public double getPrice(Size size) {
        double totalTop = 0;
        for (Topping topping : toppings) {
            totalTop += topping.getTotal(size);
        }
        return totalTop;
    }

    public double getBreadPrice() {
        if (breadSize == Size.small) {
            return 5.50;
        } else if (breadSize == Size.medium) {
            return 7.00;
        } else {
            return 8.5;
        }
    }

    @Override
    public double calculateCost() {
        double total = 0;
        total += getBreadPrice(); //initial price
        for(Topping topping: toppings){
            total+=topping.getTotal(breadSize);
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Sandwich");
        sb.append("\n");
        sb.append(breadType);
        sb.append(" ");
        sb.append(breadSize);
        sb.append("\n");

        for(Topping topping: toppings){
            sb.append(topping);
            sb.append(" ");
        }

        return sb.toString();
    }

    public String displaySandwich(){

        StringBuilder sb = new StringBuilder();

        sb.append("Sandwich");
        sb.append("\n");
        sb.append(breadType);
        sb.append(" ");
        sb.append(breadSize);
        sb.append("\n");

        for(Topping topping: toppings){
            sb.append(topping);
            sb.append(" ");
        }

        return sb.toString();
    }
}
