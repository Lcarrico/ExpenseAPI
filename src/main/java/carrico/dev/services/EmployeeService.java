package carrico.dev.services;

import carrico.dev.entities.Employee;

import java.util.Set;

public interface EmployeeService {

    public Set<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId);

}
