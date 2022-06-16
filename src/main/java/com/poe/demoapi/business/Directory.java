
package com.poe.demoapi.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;


public class Directory {
    
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
            return Optional.empty(); // if 
    }   
    
  
     public Person addPerson(Person newPerson){
        newPerson.setId(nextId);
        nextId++;
        people.add(newPerson);
        return newPerson;
    }

   
 /*   // obligated to have a loop to look through and find the person wish to update 
    public void updatePerson(Person person){
        for(Person p : people){
            if(p.getId().equals(person.getId())){
                people.remove(p);
                people.add(person);
            }
        }
    }
*/
       public void updatePerson(Person person){
        Iterator <Person>iterator = people.iterator();
        int index =0;
            while(iterator.hasNext()&& index == 0){
                Person p =iterator.next();
                if(p.getId().equals(person.getId())){
                    index = people.indexOf(p);
                //people.remove(p);
               // people.add(person);
            }
        }
            people.set(index, person);
       }
       
       
       // obligated to have a loop to look through and find the person wish to delete
    public void deletePerson(long id){
        /* for(Person p : people){
            if(p.getId().equals(id)){
                people.remove(p);
            }
        }*/
        
  
        Iterator<Person> it = people.iterator();
        int index = 0;
        while (it.hasNext() && index == 0) {
            Person p = it.next();
            if (p.getId().equals(id)) {
                index = people.indexOf(p);
            }
        }

        people.remove(index);
    }
    
        
    }
    



