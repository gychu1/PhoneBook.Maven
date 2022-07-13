package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>(); //this is initializing the variable called phonebook
//        this(null);
    }

    public void add(String name, String phoneNumber) {
        List<String> listOfPhoneNumbers = new ArrayList<>();
        listOfPhoneNumbers.add(phoneNumber);
        this.phonebook.put(name, listOfPhoneNumbers);
    }

    public void addAll(String name, String... phoneNumbers) {
//        List<String> listOfPhoneNumbers = new ArrayList<>();
//        List<String> list = Arrays.asList(phoneNumbers);
//        listOfPhoneNumbers.addAll(list);
//        this.phonebook.put(name, listOfPhoneNumbers);

        List<String> list = Arrays.asList(phoneNumbers);
        List<String> listOfPhoneNumbers = new ArrayList<>(list);
        this.phonebook.put(name, listOfPhoneNumbers);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if (phonebook.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        //the test is looking for if the String phoneNumber is in the value, which is a list of string.
        //String is not the same as a List<String>, so we turn the String into a List<String.
        if (phonebook.containsKey(name) && phonebook.containsValue(Collections.singletonList(phoneNumber))) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        //Map.Entry<String, List<String>> -- we are calling the interface Map Entry. This is the TYPE.
        //.entrySet() -- This is all the key and values.
        //for each K-V pair (variable entry), in the list of K-V pairs.
        //to the left of the colon, it is a temporary variable where we store the current iteration of K-V pair in phonebook.
        //for each number in the list of String phoneNumbers
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            //for each key-value pair in phonebook, we are checking .getValue
            for (String number : entry.getValue()) {
                //in this case, .getValue is getting back a LIST of Strings. We are iterating thru the list of string
                //to compare each element in that list of string to phoneNumber.
                if (number.equals(phoneNumber)) {
                    return entry.getKey();
                }
            }
        }
        return null;
        //there is another way that is more efficient that is thru "streams"
    }

    public List<String> getAllContactNames() {
//        List<String> names = new ArrayList<>(this.phonebook.keySet());
        return new LinkedList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
