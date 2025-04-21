package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book[] inventory = new Book[20];

        Book book1 = new Book(1, "978-0061120084", "To Kill a Mockingbird", false, "");
        inventory[0] = book1;
        Book book2 = new Book(2, "978-0439023528", "The Hunger Games", true, "Sarah");
        inventory[1] = book2;
        Book book3 = new Book(3, "978-0743273565", "The Great Gatsby", false, "");
        inventory[3] = book3;
        Book book4 = new Book(4, "978-0385472579", "The Alchemist", true, "James");
        inventory[4] = book4;
        Book book5 = new Book(5, "978-0140177398", "Of Mice and Men", false, "");
        inventory[5] = book5;
        Book book6 = new Book(6, "978-0307277671", "The Road", false, "");
        inventory[6] = book6;
        Book book7 = new Book(7, "978-0316769488", "The Catcher in the Rye", true, "Nicole");
        inventory[7] = book7;
        Book book8 = new Book(8, "978-0451524935", "1984", false, "");
        inventory[8] = book8;
        Book book9 = new Book(9, "978-0142437230", "Moby-Dick", false, "");
        inventory[9] = book9;
        Book book10 = new Book(10, "978-0385737951", "Looking for Alaska", true, "Andre");
        inventory[10] = book10;
        Book book11 = new Book(11, "978-0060850524", "Brave New World", true, "Laila");
        inventory[11] = book11;
        Book book12 = new Book(12, "978-0141439600", "Jane Eyre", false, "");
        inventory[12] = book12;
        Book book13 = new Book(13, "978-0307476463", "The Girl with the Dragon Tattoo", true, "Marcus");
        inventory[13] = book13;
        Book book14 = new Book(14, "978-0141439556", "Wuthering Heights", false, "");
        inventory[14] = book14;
        Book book15 = new Book(15, "978-0143127550", "The Goldfinch", false, "");
        inventory[15] = book15;
        Book book16 = new Book(16, "978-0316015844", "Twilight", true, "Bella");
        inventory[16] = book16;
        Book book17 = new Book(17, "978-0140283334", "Life of Pi", false, "");
        inventory[17] = book17;
        Book book18 = new Book(18, "978-0307588371", "Gone Girl", true, "Jordan");
        inventory[18] = book18;
        Book book19 = new Book(19, "978-0544003415", "The Lord of the Rings", false, "");
        inventory[19] = book19;
        Book book20 = new Book(20, "978-0375703768", "Beloved", true, "Maya");
        inventory[2] = book20;

        while (true) {
            System.out.println("welcome to digital library");
            System.out.println("Choose your option");
            System.out.println("A: book availability: \n" + "B: show checked out inventory: \n" + "C: search by book title \n" + "D: Add book \n" + "E: to exit\n");
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                //show book avail = ID & ISBN & title of book & option for check out
                case "A":
                    int counter = 0;
                    while (counter < 20) {
                        // Book at index of counter is available print out informtaion to user
                        if (inventory[counter].isCheckedOut == false) {
                            System.out.println(inventory[counter].getId() + ";" + inventory[counter].getIsbn() + ";" + inventory[counter].getTitle());
                        }
                        counter++;
                    }
                    //check out book
                    System.out.println("Hello pick your choice:What is your name and ID number for book?");
                    String name = scanner.nextLine();
                    int ID = scanner.nextInt();

                    for (int i = 0; i < inventory.length; i++) {
                        Book book = inventory[i];
                        if (ID == book.getId()) {
                            book.checkOut(name);
                            break;
                        }
                    }
                    break;
                // show checked out books & check in books
                case "B":
                    for (int i = 0; i < inventory.length; i++) {
                        Book available = inventory[i];
                        if (available.isCheckedOut) {
                            System.out.println("Books checked out " + inventory[i].getTitle() + " ID" + ":" + inventory[i].getId() + " ISBN" + ":" + inventory[i].getIsbn() + ""
                                    + " rented by" + ": " + inventory[i].getCheckedOutTo());
                        }
                    }

                    System.out.println("Press: \"A\" To Check Book In Provide Name & book ID");
                    System.out.println("Press: \"B\" To go Back to menu Press B.");
                    String option = scanner.nextLine();
                    if (option.equalsIgnoreCase("a")) {
                        System.out.println("Thank you for renting book.");
                        System.out.println("what is your name?");
                        String username = scanner.nextLine();
                        System.out.println("what is your book ID Number?");
                        int userBookID = scanner.nextInt();
                        for (int i = 0; i < inventory.length; i++) {
                            Book accept = inventory[i];
                            //check book id with system ID
                            if (userBookID == accept.getId()) {

                                if (accept.isCheckedOut()) {
                                    // Check if the name matches who rented it
                                    if (accept.getCheckedOutTo().equalsIgnoreCase(username)) {
                                        accept.checkIn();
                                        System.out.println("Thank you, " + username + ", for returning the book.");
                                    } else {
                                        System.out.println("Sorry, this book is checked out to someone else.");
                                    }
                                } else {
                                    System.out.println("This book is already checked in.");
                                }

                                break;
                            }
                        }
                        break;

                    }
                case "C":
                    booksearch(inventory, scanner);
                    break;
                // Assuming this is inside your main loop and the case for adding a book is selected (e.g., case "D")
                case "D":
                    // Ask for the book title and author
                    System.out.println("Please suggest a new book.");
                    System.out.print("Enter the book title: ");
                    String bookRequest = scanner.nextLine();

                    System.out.print("Enter the author of the book: ");
                    String authorRequest = scanner.nextLine();

                    // Check if the book already exists in the inventory (by title and author)
                    boolean bookExists = false;
                    for (int i = 0; i < inventory.length; i++) {
                        Book book = inventory[i];
                        if (book != null && book.getTitle().equals(bookRequest)) {
                            bookExists = true;
                            break;  // Exit the loop if the book is found
                        }
                    }

                    if (bookExists) {
                        System.out.println("This book is already in the inventory.");
                    } else {
                        // If the book doesn't exist, add it to the inventory
                        for (int i = 0; i < inventory.length; i++) {
                            if (inventory[i] == null) {  // Find an empty slot in the inventory
                                Book newBook = new Book(bookRequest, authorRequest);  // Pass the book title and author
                                inventory[i] = newBook;  // Add the new book to the inventory
                                System.out.println("New book added to the inventory: " + bookRequest + " by " + authorRequest);
                                break;
                            }
                        }
                    }
                    break;


                case "E":
                    System.exit(0);
            }

        }

    }

    public static void bookAvailability(Book[] inventory, Scanner scanner) {
        System.out.println("Search by availability");
        scanner.nextLine();
        String bookAvailability = scanner.nextLine();
        for (int i = 0; i < inventory.length; i++) {
            Book book = inventory[i];
            if (bookAvailability.equalsIgnoreCase("Available") && !book.isCheckedOut()) {
                System.out.println("Book Title:" + "Available");
            }
        }
    }

    public static void booksearch(Book[] inventory, Scanner scanner) {
        System.out.println("Type book name in");
        String bookname = scanner.nextLine();
        for (int i = 0; i < inventory.length; i++) {
            Book book = inventory[i];
            if (book.getTitle().equals(bookname.contains(book.getTitle()))) {
                System.out.println("This book is available:");
            }else if (bookname.equalsIgnoreCase(book.getTitle()) == book.getTitle().contains(bookname));
            System.out.println("Sorry book not in archive.");
        }
    }

}








