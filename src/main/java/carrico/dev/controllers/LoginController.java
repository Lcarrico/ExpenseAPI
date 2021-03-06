package carrico.dev.controllers;

import carrico.dev.daos.EmployeeDaoPostgres;
import carrico.dev.daos.ManagerDaoPostgres;
import carrico.dev.entities.Employee;
import carrico.dev.entities.Manager;
import carrico.dev.services.EmployeeService;
import carrico.dev.services.EmployeeServiceImpl;
import carrico.dev.services.ManagerService;
import carrico.dev.services.ManagerServiceImpl;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LoginController {

    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres());
    private ManagerService managerService = new ManagerServiceImpl(new ManagerDaoPostgres());


    public Handler loginHandler = (Context ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Manager manager = gson.fromJson(body, Manager.class);
        manager = managerService.getManagerByUsernameAndPswrd(manager.getUsername(), manager.getPswrd());
        Employee employee = gson.fromJson(body, Employee.class);
        employee = employeeService.getEmployeeByUsernameAndPswrd(employee.getUsername(), employee.getPswrd());

        if (manager != null){
            System.out.println(manager);
            ctx.status(200);
        }
        else if (employee != null){
            System.out.println(employee);
            ctx.status(200);
        }
        else {
            ctx.status(404);
        }
    };

}
