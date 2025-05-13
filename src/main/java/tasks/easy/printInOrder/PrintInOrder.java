package tasks.easy.printInOrder;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread firstThread = new Thread(() -> {
            try {
                foo.first(() -> System.out.println("First"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread secondThread = new Thread(() -> {
            try {
                foo.second(() -> System.out.println("Second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thirdThread = new Thread(() -> {
            try {
                foo.third(() -> System.out.println("Third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thirdThread.start();
        firstThread.start();
        secondThread.start();
        Semaphore semaphore = new Semaphore(1);
        semaphore.acquire();
        semaphore.release(1);

    }


}
