
package com.poe.demoapi.business;


public class Person {
    
    private Long id;
    private String firstname;
    private String lastname;
    
    
    // Constructor 

    public Person() {
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }



    public Long getId() {
        return id;
    }

    // GETTERS AND SETTERS
    public void setId(Long id) {
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
