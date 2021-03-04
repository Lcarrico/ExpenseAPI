package carrico.dev.services;

import carrico.dev.daos.ExpenseDAO;
import carrico.dev.entities.Expense;

import java.util.Set;

public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDAO edao;

    public ExpenseServiceImpl(ExpenseDAO edao){
        this.edao = edao;
    }

    @Override
    public Expense createExpense(Expense expense) {
        long currentTime = System.currentTimeMillis();
        String status = "pending";

        expense.setDateSubmitted(currentTime);
        expense.setStatus(status);

        expense = edao.createExpense(expense);
        return expense;
    }

    @Override
    public Expense getExpenseById(int expenseId) {
        return edao.getExpenseById(expenseId);
    }

    @Override
    public Set<Expense> getAllExpenses() {
        return edao.getAllExpenses();
    }

    @Override
    public Expense approveExpense(int expenseId, int managerId, String reason) {
        Expense expense = edao.getExpenseById(expenseId);
        long currentTime = System.currentTimeMillis();

        expense.setDateReviewed(currentTime);
        expense.setManagerId(managerId);
        expense.setManagerReason(reason);
        expense.setStatus("approved");

        return edao.updateExpense(expense);
    }

    @Override
    public Expense denyExpense(int expenseId, int managerId, String reason) {
        Expense expense = edao.getExpenseById(expenseId);
        long currentTime = System.currentTimeMillis();

        expense.setDateReviewed(currentTime);
        expense.setManagerId(managerId);
        expense.setManagerReason(reason);
        expense.setStatus("denied");

        return edao.updateExpense(expense);
    }

    @Override
    public boolean deleteExpense(int expenseId) {
        return edao.deleteExpenseById(expenseId);
    }

}
