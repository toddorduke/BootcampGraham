package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeToppingsTest {
@Test
    public void pricetest(){
        double price = 0;

        assertEquals(price,FreeToppings.getPrice());
    }
}