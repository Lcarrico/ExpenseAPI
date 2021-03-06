package dev.carrico.services;

import dev.carrico.entities.Employee;

import java.util.Set;

public interface EmployeeService {

    public Set<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId);

    public Employee getEmployeeByUsernameAndPswrd(String username, String pswrd);

}
