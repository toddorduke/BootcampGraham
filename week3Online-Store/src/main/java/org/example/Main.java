package org.example;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Product> products = FileLoader.readFile();

        while (true) {
            System.out.println("welcome to Duke Electro supplies");
            System.out.println("choose your option");
            System.out.println("Welcome to the store! Choose an option:");
            System.out.println("1. View all products");
            System.out.println("2. Search by SKU");
            System.out.println("3. Search by price range");
            System.out.println("4. Search by name");
            System.out.println("5. Remove from cart");
            System.out.println("6. View cart");
            System.out.println("7. Checkout");
            System.out.println("8. Exit");
            int userOption = Integer.parseInt(scanner.nextLine());


            switch (userOption) {
                case 1:
                    displayAllProduct(products);
                    break;
                case 2:
                    System.out.println("please enter the name of the product your looking for.");
                    String name = scanner.nextLine();
                    List<Product> results = searchProduct(products, name);
                    displayAllProduct(results);
                    break;
                case 3:
                    System.out.println("what is your product sku");
                    String sku = scanner.nextLine();
                    Product foundProduct = searchSku(products, sku);
                    if (foundProduct != null) {
                        shoppingCart.addProductToCart(foundProduct);
                        System.out.println("your item has been added to the cart");
                    } else {
                        System.out.println("product not found!");
                    }
                    break;
                case 4:
                    System.out.println("what is your minimum budget");
                    double min = Double.parseDouble(scanner.nextLine());
                    System.out.println("wahat is your maximum");
                    double max = Double.parseDouble(scanner.nextLine());
                    List<Product> range = searchByPriceRange(products, min, max);
                    displayAllProduct(range);
                    break;

                case 5:
                    System.out.println("To return your product enter sku");
                    String returnSku = scanner.nextLine();
                    shoppingCart.removeProduct(returnSku);
                    System.out.println("Item returned");
                    break;
                case 6:
                    displayAllProduct(shoppingCart.getProductsInList());
                    break;
                case 7:
                    shoppingCart.getCartTotal();
                    break;
                case 8:
                   checkOut(shoppingCart, scanner);
                    break;
                case 9:
                    System.exit(0);

            }
        }
    }

    public static void displayAllProduct(List<Product> product) {
        for (Product inventory : product) {
            System.out.println(inventory.getProductName() + "|" + inventory.getsku() + "|" + inventory.getDepartment() + "|" + inventory.getPrice());
        }

    }

    public static List<Product> searchProduct(List<Product> products, String name) {
        List<Product> foundProduct = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                foundProduct.add(product);
            }
        }
        return foundProduct;
    }

    public static Product searchSku(List<Product> products, String sku) {

        for (Product product : products) {
            if (product.getsku().equals(sku)) {
                System.out.println(product.getsku());
                return product;

            }
        }
        return null;
    }

    public static List<Product> searchByPriceRange(List<Product> products
            , double min, double max) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public static void checkOut(ShoppingCart cart, Scanner scanner) {
        System.out.println("your total is:" + cart.getCartTotal() + " please pay NOW!");
        double userbalance = Double.parseDouble(scanner.nextLine());


        while (userbalance < cart.getCartTotal()) {
            System.out.println("Insufficient payment. You still owe $" + String.format("%.2f", cart.getCartTotal() - userbalance));
            System.out.print("Please enter more money: ");
            userbalance += Double.parseDouble(scanner.nextLine());
        }
        if (userbalance == cart.getCartTotal()) {
            System.out.println("Payment complete. Thank you for your purchase!");
        } else {
            double change = userbalance - cart.getCartTotal();
            System.out.println("Payment complete. Your change is: $" + String.format("%.2f", change));
        }
    }
}

//get items from shopping list
//get total form items in list
// take payment from the client


