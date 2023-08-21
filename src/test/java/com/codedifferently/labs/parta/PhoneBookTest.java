package com.codedifferently.labs.parta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    public void setUp() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testAddEntry() {
        assertTrue(phoneBook.addEntry("John", "Doe", "123-456-7890"));
        assertEquals("123-456-7890", phoneBook.getAtIndex(0).getPhoneNumber());
    }

    @Test
    public void testAddEntryToFullPhoneBook() {
        for (int i = 0; i < 100; i++) {
            phoneBook.addEntry("John" + i, "Doe" + i, "123-456-7" + (890 + i));
        }
        assertFalse(phoneBook.addEntry("Jane", "Doe", "987-654-3210"));
    }

    @Test
    public void testRemoveAtIndex() {
        phoneBook.addEntry("John", "Doe", "123-456-7890");
        phoneBook.removeAtIndex(0);
        assertNull(phoneBook.getAtIndex(0));
    }

    @Test
    public void testGetAtIndex() {
        phoneBook.addEntry("John", "Doe", "123-456-7890");
        PhoneBookEntry entry = phoneBook.getAtIndex(0);
        assertNotNull(entry);
        assertEquals("John", entry.getFirstName());
        assertEquals("Doe", entry.getLastName());
    }

    @Test
    public void testFindByName() {
        phoneBook.addEntry("John", "Doe", "123-456-7890");
        PhoneBookEntry entry = phoneBook.findByName("John", "Doe");
        assertNotNull(entry);
        assertEquals("123-456-7890", entry.getPhoneNumber());
    }
}
