package org.example;

public class FreeTopping extends Topping{

private TypeOfFreeToppings typeOfFreeToppings;

    public FreeTopping(TypeOfFreeToppings typeOfFreeToppings) {
        super("free");
        this.typeOfFreeToppings = typeOfFreeToppings;
    }

    public TypeOfFreeToppings getTypeOfFreeToppings() {
        return typeOfFreeToppings;
    }

    public void setTypeOfFreeToppings(TypeOfFreeToppings typeOfFreeToppings) {
        this.typeOfFreeToppings = typeOfFreeToppings;
    }

    @Override
    public double getTotal(Size size) {
        return 0;
    }

    @Override
    public String toString() {
        return typeOfFreeToppings.name();
    }
}
