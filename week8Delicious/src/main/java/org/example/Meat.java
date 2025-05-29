package org.example;

public class Meat extends Topping {
    private TypeOfMeat typeOfMeat;

    public Meat(TypeOfMeat typeOfMeat) {
        super("meat");
        this.typeOfMeat = typeOfMeat;
    }

    public TypeOfMeat getTypeOfMeat() {
        return typeOfMeat;
    }

    public void setTypeOfMeat(TypeOfMeat typeOfMeat) {
        this.typeOfMeat = typeOfMeat;
    }

    @Override
    public double getTotal(Size size) {
        if (size == Size.small) {
            return 1.00;
        } else if (size == Size.medium) {
            return 2.00;
        } else {
            return 3.00;
        }
    }

    @Override
    public String toString() {
        return typeOfMeat.name();
    }
}
