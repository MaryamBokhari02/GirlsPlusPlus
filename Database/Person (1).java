package com.example.myapplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.*;
import java.util.*;
import java.net.*;
public class Person {
    public String lastname;
    public String firstname;

    public Person() {
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Person(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }
}
