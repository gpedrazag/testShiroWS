/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author DIEGO
 */
@XmlRootElement(name = "company")
@XmlType(propOrder = {"salaryAverage","salarySum"})
public class Company {
    private int salaryAverage;
    private int salarySum;

    /**
     * @return the salaryAverage
     */
    @XmlElement
    public int getSalaryAverage() {
        return salaryAverage;
    }

    /**
     * @param salaryAverage the salaryAverage to set
     */
    public void setSalaryAverage(int salaryAverage) {
        this.salaryAverage = salaryAverage;
    }

    /**
     * @return the salarySum
     */
    @XmlElement
    public int getSalarySum() {
        return salarySum;
    }

    /**
     * @param salarySum the salarySum to set
     */
    public void setSalarySum(int salarySum) {
        this.salarySum = salarySum;
    }
    
    
}
