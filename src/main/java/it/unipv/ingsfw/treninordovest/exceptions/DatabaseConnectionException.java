package it.unipv.ingsfw.treninordovest.exceptions;

public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message,Throwable cause) {
        super(message ,cause);
    }
}
