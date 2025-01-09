package designPatterns.behavioral.chainOfResponsibility;

public class ThirdHandler extends Handler {
    @Override
    protected boolean canHandle(String request) {
        return !request.isEmpty();
    }

    @Override
    protected void process(String request) {
        System.out.println("Short request handler is used");
    }
}
