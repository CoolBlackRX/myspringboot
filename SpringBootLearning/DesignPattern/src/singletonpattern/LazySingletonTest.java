package singletonpattern;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/17
 */
public class LazySingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ExecutorThread());
        Thread thread2 = new Thread(new ExecutorThread());

        thread1.start();
        thread2.start();
        System.out.println("END");
    }
}
