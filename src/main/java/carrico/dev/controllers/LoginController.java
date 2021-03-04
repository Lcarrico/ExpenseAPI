package carrico.dev.controllers;

import carrico.dev.daos.EmployeeDaoPostgres;
import carrico.dev.daos.ManagerDaoPostgres;
import carrico.dev.services.EmployeeService;
import carrico.dev.services.EmployeeServiceImpl;
import carrico.dev.services.ManagerService;
import carrico.dev.services.ManagerServiceImpl;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LoginController {

    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres());
    private ManagerService managerService = new ManagerServiceImpl(new ManagerDaoPostgres());


    public Handler loginHandler = (Context ctx) -> {
        // TODO implement login handler
    };

}
