package dev.carrico.servicetests;

import dev.carrico.daos.EmployeeDAO;
import dev.carrico.entities.Employee;
import dev.carrico.services.EmployeeService;
import dev.carrico.services.EmployeeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.HashSet;
import java.util.Set;

@MockitoSettings(strictness = Strictness.LENIENT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    private EmployeeService employeeService;

    @Mock
    private EmployeeDAO employeeDao = null;

    @BeforeEach
    void setup(){

        Employee employee = new Employee();
        Mockito.when(this.employeeDao.getEmployeeById(1)).thenReturn(
               new Employee(1, "jessie1", "iwantpikachu")
        );

        Set<Employee> employees = new HashSet<>();
        employees.add(
                new Employee(1, "jessie1", "iwantpikachu")
        );
        employees.add(
                new Employee(2, "james2", "iwantpikachu")
        );

        Mockito.when(this.employeeDao.getAllEmployees()).thenReturn(employees);

        employeeService = new EmployeeServiceImpl(employeeDao);
    }

    @Order(1)
    @Test
    void get_employee_by_id(){
        Employee testEmployee = this.employeeService.getEmployeeById(1);

        Assertions.assertNotNull(testEmployee);
        Assertions.assertEquals(1, testEmployee.getEmployeeId());
        System.out.println(testEmployee);
    }

    @Order(2)
    @Test
    void get_all_employees(){
        Set<Employee> employees = this.employeeService.getAllEmployees();

        Assertions.assertNotNull(employees);
        Assertions.assertTrue(employees.size() > 0);
        System.out.println(employees);
    }

    @Order(3)
    @Test
    void get_employee_by_username_and_pswrd(){
        String username = "jessie1";
        String pswrd = "iwantpikachu";

        Employee e = this.employeeService.getEmployeeByUsernameAndPswrd(username, pswrd);
        Assertions.assertNotNull(e);
        Assertions.assertEquals("jessie1", e.getUsername());
        System.out.println(e);
    }

}
