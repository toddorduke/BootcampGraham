package org.example;

public class Drink {
    private String sizeOfDrink;

    // Accepts size as 1 (small), 2 (medium), 3 (large)
    public double getPriceForSize(int size) {
        switch (size) {
            case 1:
                sizeOfDrink = "Small".toLowerCase();
                return 2.00;
            case 2:
                sizeOfDrink = "Medium".toLowerCase();
                return 2.50;
            case 3:
                sizeOfDrink = "Large".toLowerCase();
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size. Use 1 (Small), 2 (Medium), or 3 (Large).");
        }
    }

    public String getSizeOfDrink() {
        return sizeOfDrink;
    }
}