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

    @Override
    public Employee getEmployeeByUsernameAndPswrd(String username, String pswrd) {
        Employee e = null;
        Set<Employee> employees = this.getAllEmployees();
        for (Employee temp : employees){
            if (temp.getUsername().equals(username) && temp.getPswrd().equals(pswrd)){
                e = temp;
            }
        }
        return e;
    }


}
