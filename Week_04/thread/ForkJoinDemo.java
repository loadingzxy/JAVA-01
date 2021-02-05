package week4.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @program: week3
 * @description: ForkJoinDemo 线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:54
 **/
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(1);
        ForkJoinTask<String> forkJoinTask = (ForkJoinTask<String>) forkJoinPool.submit(() -> {
            return "test";
        });

        System.out.println("child thread：" + forkJoinTask.get());
        System.out.println("curr：" + Thread.currentThread().getName());
    }

}
