package org.example;

public class Cheese extends Topping {
    private TypeOfCheese typeOfCheese;

    public Cheese(String toppingType, TypeOfCheese typeOfCheese) {
        super(toppingType);
        this.typeOfCheese = typeOfCheese;
    }

    public TypeOfCheese getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(TypeOfCheese typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    public double getCheesePrice(int size) {

        if (size == 4) {
            return .75;

        } else if (size == 8) {
            return 1.50;

        } else {
            return 2.25;
        }
    }

}
