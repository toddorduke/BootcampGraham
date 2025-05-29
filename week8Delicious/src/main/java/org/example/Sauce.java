package org.example;

public class Sauce extends Topping{

    private TypeOfSauce typeOfSauce;

    public Sauce(TypeOfSauce typeOfSauce) {
        super("sauce");
        this.typeOfSauce = typeOfSauce;
    }

    public TypeOfSauce getTypeOfSauce() {
        return typeOfSauce;
    }

    public void setTypeOfSauce(TypeOfSauce typeOfSauce) {
        this.typeOfSauce = typeOfSauce;
    }

    @Override
    public double getTotal(Size size) {
        return 0;
    }

    @Override
    public String toString() {
        return "Sauce: " +  typeOfSauce;
    }
}
