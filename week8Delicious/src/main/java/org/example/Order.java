package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //Sandwich sandwich;
    // Topping topping;
    private List<OrderItem> items;
    private double orderTotal;

    public Order() {
        items = new ArrayList<>();
        orderTotal = 0;
    }

    public void addToOrder(OrderItem item) {
        items.add(item);
    }

    public double calculateOrderTotal() {
        for (OrderItem item : items) {
            orderTotal += item.calculateCost();
        }
        return orderTotal;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order Summary: \n" +
                items +
                "\nOrder total = " + calculateOrderTotal();
    }

    public void showCustomerOrder() {
        for (OrderItem orderItem: items){
            System.out.println(orderItem);
        }
    }

    public OrderItem removeFromOrder(int indexForItem){


        //this logic should be in the user interface
        System.out.println("Would you like to remove anything from your order?");
        System.out.println("____________________________________");
        for (int i = 0; i<items.size();i++){

            System.out.println(i+") " + items.get(i));
        }

        //logic we should actually call to remove item:

        return items.remove(indexForItem);
    }

//    public String toString() {
//        return String.format("%s|%d|%s|%s|%s|%s",
//                sandwich,
//                breadSize,
//                meat,
//                cheese,
//                typeOfFreeToppings,
//                sauceChoice);
//    }
}
