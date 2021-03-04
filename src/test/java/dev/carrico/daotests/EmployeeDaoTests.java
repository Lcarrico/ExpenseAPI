package dev.carrico.daotests;

import carrico.dev.daos.EmployeeDAO;
import carrico.dev.daos.EmployeeDaoPostgres;
import carrico.dev.entities.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
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
