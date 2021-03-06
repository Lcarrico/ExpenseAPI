package dev.carrico.exceptions;

public class ManagerNotFoundException extends RuntimeException{
    public ManagerNotFoundException(int id){
        super("Manager " + id + " not found");
    }
}
