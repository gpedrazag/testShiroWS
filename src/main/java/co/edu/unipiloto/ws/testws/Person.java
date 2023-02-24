/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DIEGO
 */
@XmlRootElement(name = "person")
@XmlType(propOrder = {"id","fullName","age","salario"})
public class Person{
    private int id;
    private String fullName;
    private int age;
    private int salario;

    

    /**
     * @return the id
     */
    @XmlElement
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fullName
     */
    @XmlElement
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the age
     */
    @XmlElement
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the salario
     */
    @XmlElement
    public int getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }
    
}
