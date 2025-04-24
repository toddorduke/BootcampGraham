package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = FileLoader.readFile();


    }
    private static void searchByPriceRange(List<Product> products) {
    }

    public static void displayAllProduct(List<Product> product) {
        for (Product inventory : product) {
            System.out.println(inventory.getProductName());
        }

    }

    public static List<Product> searchProduct(List<Product> products) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(products.toString()))
                foundProducts.add(product);
        }
        return foundProducts;
    }

    public static List<Product> searchSku(List<Product> products) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getSKU().equalsIgnoreCase(products.toString())) {
                foundProducts.add(product);

            }
        }
        return foundProducts;
    }

    public static List<Product> searchByPriceRange(List<Product> products
            , int min, int max) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}

