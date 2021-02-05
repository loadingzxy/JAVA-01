package week4.thread;

import java.util.concurrent.Semaphore;

/**
 * @program: week3
 * @description: SemphereDemo线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:57
 **/
public class SemphereDemo {
    public static String test;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(0);
        new Thread(() -> {
            test = "test";
            semaphore.release();
        }).start();

        try {
            semaphore.acquire();
            System.out.println("child thread：" + test);
            System.out.println("curr：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
