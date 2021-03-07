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
import dev.carrico.utils.JwtUtil;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.apache.log4j.Logger;

public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());


    private EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDaoPostgres());
    private ManagerService managerService = new ManagerServiceImpl(new ManagerDaoPostgres());


    public Handler loginHandler = (Context ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Manager manager = gson.fromJson(body, Manager.class);
        if (manager == null){
            ctx.status(400);
            return;
        }
        manager = managerService.getManagerByUsernameAndPswrd(manager.getUsername(), manager.getPswrd());
        Employee employee = gson.fromJson(body, Employee.class);
        if (employee == null){
            ctx.status(400);
            return;
        }
        employee = employeeService.getEmployeeByUsernameAndPswrd(employee.getUsername(), employee.getPswrd());

        if (manager != null){
            String token = JwtUtil.generate("manager", manager.getUsername());
            ctx.cookie("Authorization", token, 86400);
            logger.info("Manager " + manager.getUsername() + " successfully logged in.");
            ctx.status(200);
        }
        else if (employee != null){
            String token = JwtUtil.generate("employee", employee.getUsername());
            ctx.cookie("Authorization", token, 86400);
            logger.info("Employee " + employee.getUsername() + " successfully logged in.");
            ctx.status(200);
        }
        else {
            logger.error("Unsuccessful login attempt for " + manager.getUsername());
            ctx.status(404);
        }
    };

}
