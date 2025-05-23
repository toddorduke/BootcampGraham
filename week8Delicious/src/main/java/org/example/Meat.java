package org.example;

public class Meat extends Topping {
    private TypeOfMeat typeOfMeat;

    public Meat(String toppingType, TypeOfMeat typeOfMeat) {
        super(toppingType);
        this.typeOfMeat = typeOfMeat;
    }

    public TypeOfMeat getTypeOfMeat() {
        return typeOfMeat;
    }

    public void setTypeOfMeat(TypeOfMeat typeOfMeat) {
        this.typeOfMeat = typeOfMeat;
    }

    public double getMeatPrice(int size) {
        if (size == 4) {
            return 1.00;
        } else if (size == 8) {
            return 2.00;
        } else {
            return 3.00;
        }
    }

}
