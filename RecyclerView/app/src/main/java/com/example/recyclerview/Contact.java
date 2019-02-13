package com.example.recyclerview;

import java.util.ArrayList;

/**
 * Model class for contact.
 */
public class Contact {

    private String name;
    private boolean isOnline;

    private static int lastID = 0;

    /**
     * Unique constructor.
     * @param name
     * @param isOnline
     */
    public Contact(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    /**
     * Get the name of the contact.
     * @return The name of the contact.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the online state of the contact.
     * @return The online state of the contact.
     */
    public boolean getOnline() {
        return isOnline;
    }

    /**
     * Create the contact list for the view.
     * @param numContacts The number of contacts to create.
     * @return A contact list.
     */
    public static ArrayList<Contact> createContactList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<>();
        for(int i = 0; i < numContacts; i++)
            contacts.add(new Contact("Contact " + (++lastID), i < numContacts / 2));

        return contacts;
    }

}
