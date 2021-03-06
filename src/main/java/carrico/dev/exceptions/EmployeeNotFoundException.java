package carrico.dev.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(int id){
        super("Employee " + id + " not found");
    }
}
