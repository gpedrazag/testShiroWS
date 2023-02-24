/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.services;

import co.edu.unipiloto.ws.testws.Person;
import co.edu.unipiloto.ws.testws.Company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author DIEGO
 */
@Path("/service")
public class Service {
    
    private static Map<Integer,Person> persons = new HashMap<Integer,Person>();
    private static Company salaryCompany = new Company();
    //Insert test data in simulated database
    static {
        Company company=new Company();
        int count=0;
        for (int i=0;i<10;i++){
            Person person=new Person();
            int id=i+1;
            count++;
            person.setId(id);
            person.setFullName("My wonder person "+id);
            person.setAge(new Random().nextInt(40)+1);
            person.setSalario(person.getAge()*700/3);
            company.setSalarySum(company.getSalarySum()+person.getSalario());
            persons.put(id,person);
        }
        company.setSalaryAverage(company.getSalarySum()/count);
    }
    
    //method which should return a single person object in XML format
    @GET
    @Path("/getPersonByIdXML/{Id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam ("Id") int id){
        return persons.get(id);
    }
    
    
    
    //method which should return a single person object in XML format
    @GET
    @Path("getPersonByIdJSON/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam ("Id") int id){
        return persons.get(id);
    }
    
       //method which should return a single person object in XML format
    @GET
    @Path("getAllPersonsInXML/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
        return new ArrayList <Person>(persons.values());
    }
    
    @GET
    @Path("getAllPersonsInJSON/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJSON(){
        return new ArrayList <Person>(persons.values());
    }
    
    
    
    
    
    
    
    
    
    
    @GET
    @Path("getAverageSalaryInXML/")
    @Produces(MediaType.APPLICATION_XML)
    public Company getAverageSalaryInXML(){
        // Iterating over values only
        int values=0;
        int count=0;
        for (Person value : persons.values()) {
            values+=value.getSalario();
            count++;
        }
        int resp=values/count;
        System.out.println("valor promedio "+resp);
        Company company=new Company();
        company.setSalaryAverage(resp);
        company.setSalarySum(values);
        return company;
    }
    
    @GET
    @Path("getAverageSalaryInJSON/")
    @Produces(MediaType.APPLICATION_JSON)
    public Company getAverageSalaryInJSON(){
        // Iterating over values only
        int values=0;
        int count=0;
        for (Person value : persons.values()) {
            values+=value.getSalario();
            count++;
        }
        int resp=values/count;
        System.out.println("valor promedio "+resp);
        Company company=new Company();
        company.setSalaryAverage(resp);
        company.setSalarySum(values);
        return company;
    }
    
    @POST
    @Path("agregar/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Person> agregarPersonas(List<Person> pr) {
        System.out.println("Adicionar");
        for (Person persona : pr) {
            System.out.println(persona.getId());
            persons.put(persona.getId(),persona);
        }
                return new ArrayList <Person>(persons.values());
    }
    
    @POST
    @Path("agregarPeople/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean agregar(List<Person> pr) {
        System.out.println("Adicionar");
        for (Person persona : pr) {
            System.out.println(persona.getId());
            persons.put(persona.getId(),persona);
        }
                return true;
    }
}
