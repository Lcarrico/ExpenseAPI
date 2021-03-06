package dev.carrico.app;

import dev.carrico.controllers.ExpenseController;
import dev.carrico.controllers.LoginController;
import io.javalin.Javalin;

public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create();

        LoginController lc = new LoginController();
        ExpenseController ec = new ExpenseController();

        // Handle expenses
        app.post("/expenses", ec.createExpenseHandler);

        app.get("/expenses", ec.getAllExpensesHandler);
        app.get("/expenses/:expenseId", ec.getExpenseByIdHandler);

        app.put("/expenses/:expenseId", ec.updateExpenseHandler);

        app.delete("/expenses/:expenseId", ec.deleteExpenseHandler);

        // Handle login
        app.get("/login", lc.loginHandler);

        app.start();
    }
}
