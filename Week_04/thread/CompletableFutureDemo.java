package week4.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @program: week3
 * @description: completefuture线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:48
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Integer num = CompletableFuture.supplyAsync(() -> {
            return 1;
        }).get();

        System.out.println("child thread：" + num);
        System.out.println("curr：" + Thread.currentThread().getName());

    }


}
