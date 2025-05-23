package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chipsTest {

    @Test
    public void testaddchips() {
        double price = 1.50;

        assertEquals(price, chips.addchips.addchips("yes"));

    }
}