
package com.poe.demoapi.business;

import java.util.ArrayList;
import java.util.Optional;


public class Annuaire {
    
    private Long nextId = 1L;
   private ArrayList<Person> people = new ArrayList<>();
   
    
    // Constructor
   
   
   
   
   // GETTERS AND SETTERS

    public Long getNextId() {
        return nextId;
    }

    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }



   
   
    // method to add personne to annuaire
    

    // want to return one particular person // now its an optional because of the fact that we might not find a particular person
    public Optional<Person> getPerson(Long id){ // return and optional empty or option in the object we found // when we didnt find an element to return instead of returnin null 
        for(Person p: people){
            if(p.getId().equals(id)){
            return Optional.of(p);
            }
        }
            return Optional.empty();
    }   
    
  
     public void addPersonne(Person newPerson){
        newPerson.setId(nextId);
        nextId++;
        people.add(newPerson);
    }

   
    
    public void updatePersonne(Person person){
        for(Person p : people){
            if(p.getId().equals(person.getId())){
                people.remove(p);
                people.add(person);
            }
        }
    }
    
    public void deletePersonne(long id){
        for(Person p : people){
            if(p.getId().equals(id)){
                people.remove(p);
            }
        }
    }
    
    
        
    }
    



