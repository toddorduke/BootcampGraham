package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeatTest {
    @Test
    public void getprice(){
        Meat meat = new Meat(TypeOfMeat.roastBeef);
       // meat.getMeatPrice(4);
        double small = 3;
//assertEquals(small,meat.getMeatPrice(12));

    }

}