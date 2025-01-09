package designPatterns.behavioral.chainOfResponsibility;


import designPatterns.behavioral.chainOfResponsibility.exceptions.NoAvailableHandlersException;

import static java.util.Objects.nonNull;

public abstract class Handler {

    private Handler nextHandler;

    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return this;
    }

    public void handleRequest(String request) {
        if (canHandle(request)) {
            process(request);
        } else if (nonNull(nextHandler)) {
            nextHandler.handleRequest(request);
        } else {
            throw new NoAvailableHandlersException("There are no handlers left to process your request");
        }
    }

    protected abstract boolean canHandle(String request);

    protected abstract void process(String request);

}
