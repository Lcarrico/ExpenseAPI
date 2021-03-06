package carrico.dev.exceptions;

public class BadFormatException extends RuntimeException{
    public BadFormatException(){
        super("Response body contained incorrect format");
    }
}
