package week4.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @program: week3
 * @description: countDown线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:52
 **/
public class CountDownLatchDemo {

    private static int num;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            num = 1;
            countDownLatch.countDown();
        }).start();

        countDownLatch.await();

        System.out.println("child thread：" + num);

        System.out.println("curr：" + Thread.currentThread().getName());

    }


}
