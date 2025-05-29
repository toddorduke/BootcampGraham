package org.example;

public class Cheese extends Topping {
    private TypeOfCheese typeOfCheese;

    public Cheese(TypeOfCheese typeOfCheese) {
        super("cheese");
        this.typeOfCheese = typeOfCheese;
    }

    public TypeOfCheese getTypeOfCheese() {
        return typeOfCheese;
    }

    public void setTypeOfCheese(TypeOfCheese typeOfCheese) {
        this.typeOfCheese = typeOfCheese;
    }

    @Override
    public double getTotal(Size size) {

        if (size == Size.small) {
            return .75;

        } else if (size == Size.medium) {
            return 1.50;

        } else {
            return 2.25;
        }
    }

    @Override
    public String toString() {
        return typeOfCheese.name();
    }
}
