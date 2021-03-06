package dev.carrico.exceptions;

public class InsufficientPrivilegesException extends RuntimeException{
    public InsufficientPrivilegesException(){
        super("Insufficient privileges to perform this action");
    }
}
