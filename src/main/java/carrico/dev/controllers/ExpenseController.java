package carrico.dev.controllers;

import carrico.dev.daos.ExpenseDaoPostgres;
import carrico.dev.entities.Expense;
import carrico.dev.exceptions.BadFormatException;
import carrico.dev.exceptions.ExpenseNotFoundException;
import carrico.dev.services.*;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.Set;

public class ExpenseController {

    // TODO add logger

    private ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDaoPostgres());

    public Handler createExpenseHandler = (Context ctx) -> {
        try {
            String body = ctx.body();
            Gson gson = new Gson();
            Expense expense = gson.fromJson(body, Expense.class);
            Expense resultExpense = expenseService.createExpense(expense);
            String resultExpenseJSON = gson.toJson(resultExpense);
            ctx.result(resultExpenseJSON);
            ctx.status(201);
        } catch (BadFormatException e){
            ctx.status(400);
        }
    };

    public Handler getAllExpensesHandler = (Context ctx) -> {
        Set<Expense> expenses = expenseService.getAllExpenses();
        Gson gson = new Gson();
        String expensesJSON = gson.toJson(expenses);
        ctx.result(expensesJSON);
        ctx.status(200);
    };

    public Handler getExpenseByIdHandler = (Context ctx) -> {
        try {
            int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
            Expense expense = expenseService.getExpenseById(expenseId);
            Gson gson = new Gson();
            String expenseJSON = gson.toJson(expense);
            ctx.result(expenseJSON);
            ctx.status(200);
        } catch (ExpenseNotFoundException e){
            ctx.status(404);
        } catch (NumberFormatException e){
            ctx.status(400);
        }
    };

    public Handler updateExpenseHandler = (Context ctx) -> {
        try {
            int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
            String body = ctx.body();
            Gson gson = new Gson();
            Expense expense = gson.fromJson(body, Expense.class);
            expense.setExpenseId(expenseId);

            String originalStatus = expenseService.getExpenseById(expenseId).getStatus();
            String newStatus = expense.getStatus();
            if (!originalStatus.equals(newStatus)) {
                if (newStatus.equals("approved")) {
                    expense = expenseService.approveExpense(expenseId, expense.getManagerId(), expense.getManagerReason());
                }
                if (newStatus.equals("denied")) {
                    expense = expenseService.denyExpense(expenseId, expense.getManagerId(), expense.getManagerReason());
                }
                ctx.result(gson.toJson(expense));
            }
            else {
                ctx.result(gson.toJson(expenseService.getExpenseById(expenseId)));
            }

        } catch (ExpenseNotFoundException e){
            ctx.status(404);
        } catch (NumberFormatException e){
            ctx.status(400);
        } catch (BadFormatException e){
            ctx.status(400);
        }

    };
    
    public Handler deleteExpenseHandler = (Context ctx) -> {
        try {
            int expenseId = Integer.parseInt(ctx.pathParam("expenseId"));
            if (expenseService.deleteExpense(expenseId))
                ctx.status(204);
            else
                ctx.status(400);
        } catch (ExpenseNotFoundException e){
            ctx.status(404);
            ctx.status(404);
        }

    };



}
