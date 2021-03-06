package carrico.dev.exceptions;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException(int id){
        super("Manager " + id + " not found");
    }
}
