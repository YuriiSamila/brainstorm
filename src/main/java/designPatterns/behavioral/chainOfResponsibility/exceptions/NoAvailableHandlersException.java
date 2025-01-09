package designPatterns.behavioral.chainOfResponsibility.exceptions;

public class NoAvailableHandlersException extends RuntimeException {

    public NoAvailableHandlersException(String message) {
        super(message);
    }

}
