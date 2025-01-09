package designPatterns.behavioral.chainOfResponsibility;

public class SecondHandler extends Handler {
    @Override
    protected boolean canHandle(String request) {
        return request.length() >= 5;
    }

    @Override
    protected void process(String request) {
        System.out.println("Medium request handler is used");
    }
}
