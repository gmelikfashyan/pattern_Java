package pr4;

import static java.lang.Thread.*;

public class Test {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = new MyExecutorService(2);
        myExecutorService.submit(()-> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Первая задача");
        });
        myExecutorService.submit(() -> System.out.println("Вторая задача"));
    }
}
