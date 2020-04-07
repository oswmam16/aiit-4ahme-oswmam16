/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsontutorial;

import com.google.gson.Gson;
import java.util.Arrays;

/**
 *
 * @author maxio
 */
public class EmployeeTest {
    
    public static void main(String[] args) {
        Employee employee = new Employee();
        
        employee.setId(21);
        employee.setFirstName("Maxi");
        employee.setLastName("Oswald");
        employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
        
        Gson gson2 = new Gson();
        
        System.out.println(gson2.toJson(employee));
    }
}
