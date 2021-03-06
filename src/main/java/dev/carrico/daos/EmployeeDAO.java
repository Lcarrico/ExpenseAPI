package dev.carrico.daos;

import dev.carrico.entities.Employee;

import java.util.Set;

public interface EmployeeDAO {

    public Set<Employee> getAllEmployees();
    public Employee getEmployeeById(int employeeId);
}
