package carrico.dev.controllers;

import carrico.dev.daos.EmployeeDaoPostgres;
import carrico.dev.daos.ExpenseDaoPostgres;
import carrico.dev.daos.ManagerDaoPostgres;
import carrico.dev.services.*;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ExpenseController {

    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoPostgres());

    // TODO implement handlers
    public Handler createExpenseHandler = (Context ctx) -> {

    };

    public Handler getAllExpensesHandler = (Context ctx) -> {

    };

    public Handler getExpenseByIdHandler = (Context ctx) -> {

    };

    public Handler updateExpenseHandler = (Context ctx) -> {

    };

    public Handler deleteExpenseHandler = (Context ctx) -> {

    };



}
