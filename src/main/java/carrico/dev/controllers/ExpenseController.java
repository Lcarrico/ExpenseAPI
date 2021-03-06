package carrico.dev.controllers;

import carrico.dev.daos.EmployeeDaoPostgres;
import carrico.dev.daos.ExpenseDaoPostgres;
import carrico.dev.daos.ManagerDaoPostgres;
import carrico.dev.entities.Expense;
import carrico.dev.services.*;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Set;

public class ExpenseController {

    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoPostgres());

    public Handler createExpenseHandler = (Context ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        Expense resultExpense = expenseService.createExpense(expense);
        String resultExpenseJSON = gson.toJson(resultExpense);
        ctx.result(resultExpenseJSON);
        ctx.status(201);
    };

    public Handler getAllExpensesHandler = (Context ctx) -> {
        Set<Expense> expenses = expenseService.getAllExpenses();
        Gson gson = new Gson();
        String expensesJSON = gson.toJson(expenses);
        ctx.result(expensesJSON);
        ctx.status(200);
    };

    public Handler getExpenseByIdHandler = (Context ctx) -> {
        int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
        Expense expense = expenseService.getExpenseById(expenseId);
        Gson gson = new Gson();
        String expenseJSON = gson.toJson(expense);
        ctx.result(expenseJSON);
        ctx.status(200);
    };

    public Handler updateExpenseHandler = (Context ctx) -> {
        int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
        String body = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(body, Expense.class);
        expense.setExpenseId(expenseId);

        String originalStatus = expenseService.getExpenseById(expenseId).getStatus();
        String newStatus = expense.getStatus();
        if (!originalStatus.equals(newStatus)){
            if (newStatus == "approved"){
                expenseService.approveExpense(expenseId, expense.getManagerId(), expense.getManagerReason());
            }
            if (newStatus == "denied"){
                expenseService.denyExpense(expenseId, expense.getManagerId(), expense.getManagerReason());
            }
        }
        ctx.result(gson.toJson(expense));

    };
    
    public Handler deleteExpenseHandler = (Context ctx) -> {
        int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
        if (expenseService.deleteExpense(expenseId))
            ctx.status(204);
        else ctx.status(400);

    };



}
