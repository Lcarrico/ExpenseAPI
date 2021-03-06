package dev.carrico.exceptions;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(int id){
        super("No Expense " + id + " Found");
    }
}
