package org.example;

public class Drink implements OrderItem{
    private Size sizeOfDrink;

    public Drink(Size size){
        this.sizeOfDrink = size;
    }

    // Accepts size as 1 (small), 2 (medium), 3 (large)
    public double getPriceForSize() {
        switch (sizeOfDrink) {
            case small:
              //  sizeOfDrink = Size.small;
                return 2.00;
            case medium:
               // sizeOfDrink = "Medium".toLowerCase();
                return 2.50;
            case large:
               // sizeOfDrink = "Large".toLowerCase();
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size. Use 1 (Small), 2 (Medium), or 3 (Large).");
        }
    }

    public String getSizeOfDrink() {
        return sizeOfDrink.name();
    }


    @Override
    public String toString() {
        return "Drink: " + sizeOfDrink;
    }

    @Override
    public double calculateCost() {
        return getPriceForSize();
    }

    @Override
    public String printToReceipt() {
        return "Drink: " + getSizeOfDrink()  + ":" + getPriceForSize();
    }
}


