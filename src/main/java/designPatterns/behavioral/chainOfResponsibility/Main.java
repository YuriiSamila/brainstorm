package designPatterns.behavioral.chainOfResponsibility;

public class Main {

    public static void main(String[] args) {
        Handler handler = new FirstHandler()
                .setNextHandler(new SecondHandler()
                        .setNextHandler(new ThirdHandler()));
        handler.handleRequest("");
    }

}
