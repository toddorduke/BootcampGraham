package org.example;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    //TODO add product to cart method
    public void addProductToCart(Product product) {
        if (product.getProductName().equalsIgnoreCase(product.toString())){
            products.add(product);
            throw new UnsupportedOperationException();
        }
    }

    //TODO remove product from cart method
// you will need the sku for the product you want to move
    //loop through list of product
    //check to see if SKu matches
    //get that product, then use remove method after the loop
    public void removeProduct(String Sku) {
        for (Product product : products) {
            if (product.getSKU().equalsIgnoreCase(Sku)) {
                products.remove(product);
                System.out.println("your item has been removed.");
            } else {
                System.out.println("that sku doesn't existence ");
            }
        }
        throw new UnsupportedOperationException();
    }

    //TODO get cart total method
    public double getCartTotal() {
        for (Product products : products) {
            Double total = 0.0;
            for (Product product : this.products) {
                total += product.getPrice();
            }
            return total;
        }
        throw new UnsupportedOperationException();
    }

    // TODO items in shopping cart
    public List<Product> getProductsInList() {
        return products;
    }
}
