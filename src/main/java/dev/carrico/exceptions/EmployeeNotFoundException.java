package dev.carrico.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id){
        super("Employee " + id + " not found");
    }
}
