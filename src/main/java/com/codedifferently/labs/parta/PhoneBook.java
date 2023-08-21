package com.codedifferently.labs.parta;

public class PhoneBook {
    private PhoneBookEntry[] entries;
    private int currentSize;

    public PhoneBook() {
        this.entries = new PhoneBookEntry[100];
        this.currentSize = 0;
    }

    public void displayAll() {
        for (int i = 0; i < currentSize; i++) {
            System.out.println(i + ". " + entries[i]);
        }
    }

    public void displayAtIndex(int index) {
        if (index >= 0 && index < currentSize) {
            System.out.println(entries[index]);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public boolean addEntry(String firstName, String lastName, String phoneNumber) {
        if (currentSize < entries.length) {
            entries[currentSize++] = new PhoneBookEntry(firstName, lastName, phoneNumber);
            return true;
        } else {
            return false;
        }
    }

    public void removeAtIndex(int index) {
        if (index >= 0 && index < currentSize) {
            System.arraycopy(entries, index + 1, entries, index, currentSize - index - 1);
            currentSize--;
        } else {
            System.out.println("Invalid index.");
        }
    }

    public PhoneBookEntry getAtIndex(int index) {
        if (index >= 0 && index < currentSize) {
            return entries[index];
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    public PhoneBookEntry findByName(String firstName, String lastName) {
        for (int i = 0; i < currentSize; i++) {
            if (entries[i].getFirstName().equals(firstName) && entries[i].getLastName().equals(lastName)) {
                return entries[i];
            }
        }
        return null;
    }
}
