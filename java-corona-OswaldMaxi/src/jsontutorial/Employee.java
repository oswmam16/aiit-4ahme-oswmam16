/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial;

import java.util.Date;
import java.util.List;

/**
 *
 * @author maxio
 */
public class Employee {
   
    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> roles;
    
    public Employee(){      
    }
    
    public Employee(Integer id, String firstName, String lastName, Date birthDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", " + "lastName=" + lastName + ", roles=" + roles + "]";
    }
}

