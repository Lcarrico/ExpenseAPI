package dev.carrico.daotests;

import dev.carrico.daos.EmployeeDAO;
import dev.carrico.daos.EmployeeDaoPostgres;
import dev.carrico.entities.Employee;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeDaoTests {
    private EmployeeDAO employeeDAO = new EmployeeDaoPostgres();


    @Order(1)
    @Test
    void get_employee_by_id(){
        Employee e = this.employeeDAO.getEmployeeById(1);
        Assertions.assertEquals(e.getUsername(), "jessie1");
        Assertions.assertEquals(e.getEmployeeId(), 1);
    }

    @Order(2)
    @Test
    void get_all_employees(){
        Set<Employee> employees = this.employeeDAO.getAllEmployees();
        System.out.println(employees);
        Assertions.assertTrue(employees.size() >= 1);
    }


}
