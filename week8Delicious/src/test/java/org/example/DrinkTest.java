package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {
    Drink drink = new Drink();
@Test
    public void testDrinksmall() {

        //arrange
        double price = drink.getPriceForSize(1);

        //assert
        assertEquals(price, 2.00);

    }

    @Test
    public void drinkMedium(){
    double price = drink.getPriceForSize(2);

    assertEquals(price,2.50);
    }

    @Test
    public void drinkLarge(){
    double price = drink.getPriceForSize(3);

    assertEquals(price,3.00);
    }
}