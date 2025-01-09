package designPatterns.behavioral.chainOfResponsibility;

public class FirstHandler extends Handler {
    @Override
    protected boolean canHandle(String request) {
        return request.length() >= 10;
    }

    @Override
    protected void process(String request) {
        System.out.println("Long request handler is used");
    }

}
