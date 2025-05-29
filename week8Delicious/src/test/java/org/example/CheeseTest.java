package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {
    @Test
    public void testprice() {
        Cheese cheese = new Cheese(TypeOfCheese.provolone);

        String size = "medium";
        double small = 2.25;
      //  assertEquals(small, cheese.getCheesePrice(12));
    }

}