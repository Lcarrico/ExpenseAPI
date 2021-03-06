package dev.carrico.controllers;

import dev.carrico.daos.EmployeeDaoPostgres;
import dev.carrico.daos.ManagerDaoPostgres;
import dev.carrico.entities.Employee;
import dev.carrico.entities.Manager;
import dev.carrico.services.EmployeeService;
import dev.carrico.services.EmployeeServiceImpl;
import dev.carrico.services.ManagerService;
import dev.carrico.services.ManagerServiceImpl;
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
