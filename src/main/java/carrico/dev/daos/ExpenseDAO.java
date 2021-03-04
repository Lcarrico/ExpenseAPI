package carrico.dev.daos;

import carrico.dev.entities.Expense;

import java.util.Set;

public interface ExpenseDAO {

    public Expense createExpense(Expense expense);

    public Expense getExpenseById(int expenseId);
    public Set<Expense> getAllExpenses();

    public Expense updateExpense(Expense expense);

    public boolean deleteExpenseById(int expenseId);
}
