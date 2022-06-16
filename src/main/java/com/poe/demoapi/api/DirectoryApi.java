/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poe.demoapi.api;

import com.poe.demoapi.business.Directory;
import com.poe.demoapi.business.Person;

import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/people")// only need to write once not for every method since did it here and got all people not just one person 
public class DirectoryApi {
    
@GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public ArrayList<Person> getPeople(@Context HttpServletRequest request) {
        
       Directory directory= (Directory)request.getSession().getAttribute("directory");
        if(directory == null) {
            directory = new Directory();       
        }
        return directory.getPeople();
    }
    
    @POST()
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    public Person postPerson(Person newPerson, @Context HttpServletRequest request) {
        
        Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null) {
            directory = new Directory();       
        }
        Person person = directory.addPerson(newPerson);
        request.getSession().setAttribute("directory", directory);
        return person;
    }
    
      @Path("/{id}")
    @GET()
    @Produces({ MediaType.APPLICATION_JSON })
    public Person getPerson(@PathParam("id") long personneId, @Context HttpServletRequest request) {
        
   Directory directory = (Directory)request.getSession().getAttribute("directory");
        if(directory == null) {
            directory = new Directory();       
        }
        Optional<Person> op = directory.getPerson(personneId);
        if(op.isPresent()){
            return op.get();
        }
        
        // TODO : à améliorer ?
        return new Person();
    }
    
     @Path("/{id}")
       @PUT()
    @Consumes({ MediaType.APPLICATION_JSON })
    public void putPerson(Person person, @Context HttpServletRequest request ){
      Directory directory = (Directory)request.getSession().getAttribute("directory");
     
   if(directory == null) {
            directory = new Directory();       
        }
    directory.updatePerson(person);
     request.getSession().setAttribute("directory", directory);
}
    
    
     @Path("/{id}")
     @DELETE()
    public void deletePerson(@PathParam("id") long personneId, @Context HttpServletRequest request){
         Directory directory = (Directory)request.getSession().getAttribute("directory");
         if(directory == null) {
            directory = new Directory();       
        }
         directory.deletePerson(personneId);
         request.getSession().setAttribute("directory", directory);
    }
}
        // specificity to the optional