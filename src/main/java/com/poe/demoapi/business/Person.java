
package com.poe.demoapi.business;


public class Person {
    
    private int id;
    private String firstname;
    private String lastname;
    
    
    // Constructor 

    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    
    
    
    // GETTERS AND SETTERS 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
    
    
}