package com.codedifferently.labs.parta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Menu:");
            System.out.println("1. Display all entries");
            System.out.println("2. Display entry at specific index");
            System.out.println("3. Add entry");
            System.out.println("4. Remove entry at specific index");
            System.out.println("5. Get entry at specific index");
            System.out.println("6. Find entry by name");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            switch (choice) {
                case 1:
                    phoneBook.displayAll();
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    phoneBook.displayAtIndex(index);
                    break;
                case 3:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    if (phoneBook.addEntry(firstName, lastName, phoneNumber)) {
                        System.out.println("Entry added successfully.");
                    } else {
                        System.out.println("Failed to add entry. Phonebook might be full.");
                    }
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int idxToRemove = scanner.nextInt();
                    phoneBook.removeAtIndex(idxToRemove);
                    break;
                case 5:
                    System.out.print("Enter index: ");
                    int idxToGet = scanner.nextInt();
                    PhoneBookEntry entry = phoneBook.getAtIndex(idxToGet);
                    if (entry != null) {
                        System.out.println(entry);
                    }
                    break;
                case 6:
                    System.out.print("Enter first name: ");
                    String fName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lName = scanner.nextLine();
                    PhoneBookEntry foundEntry = phoneBook.findByName(fName, lName);
                    if (foundEntry != null) {
                        System.out.println(foundEntry);
                    } else {
                        System.out.println("Entry not found.");
                    }
                    break;
                case 7:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        scanner.close();
    }
}
