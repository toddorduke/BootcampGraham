package org.example;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Order newOrder;

    public static void main(String[] args) {

        newOrder = new Order();


        UserInterface userInterface = new UserInterface();
        System.out.println(userInterface);

    }
}