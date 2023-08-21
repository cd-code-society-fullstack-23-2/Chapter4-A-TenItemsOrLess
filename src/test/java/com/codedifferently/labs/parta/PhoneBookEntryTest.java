package com.codedifferently.labs.parta;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookEntryTest {
    @Test
    public void testConstructorAndGetters() {
        String firstName = "John";
        String lastName = "Doe";
        String phoneNumber = "123-456-7890";

        PhoneBookEntry entry = new PhoneBookEntry(firstName, lastName, phoneNumber);

        assertEquals(firstName, entry.getFirstName(), "First name should match the provided value.");
        assertEquals(lastName, entry.getLastName(), "Last name should match the provided value.");
        assertEquals(phoneNumber, entry.getPhoneNumber(), "Phone number should match the provided value.");
    }

    @Test
    public void testToString() {
        PhoneBookEntry entry = new PhoneBookEntry("Jane", "Doe", "987-654-3210");
        String expectedString = "Jane Doe: 987-654-3210";
        assertEquals(expectedString, entry.toString(), "toString() should return the formatted string.");
    }
}