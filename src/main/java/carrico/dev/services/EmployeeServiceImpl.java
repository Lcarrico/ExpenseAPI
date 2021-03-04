package carrico.dev.services;

import carrico.dev.daos.EmployeeDAO;
import carrico.dev.entities.Employee;

import java.util.Set;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO edao;

    public EmployeeServiceImpl(EmployeeDAO edao){
        this.edao = edao;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return edao.getAllEmployees();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return edao.getEmployeeById(employeeId);
    }
}
