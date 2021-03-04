package carrico.dev.daos;

import carrico.dev.entities.Employee;

import java.util.Set;

public interface EmployeeDAO {

    public Set<Employee> getAllEmployees();
    public Employee getEmployeeById(int employeeId);
}
