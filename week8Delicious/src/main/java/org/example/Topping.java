package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Topping {
    private String toppingType;

    public Topping(String toppingType) {
        this.toppingType = toppingType;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public abstract double getTotal(Size size);
}
