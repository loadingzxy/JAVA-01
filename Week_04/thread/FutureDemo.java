package week4.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: week3
 * @description: FutureDemo  线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:55
 **/
public class FutureDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future = executorService.submit(new Task());

        System.out.println("child：" + future.get());

        System.out.println("curr：" + Thread.currentThread().getName());
    }
}

class Task implements Callable {

    @Override
    public Object call() throws Exception {
        return "test";
    }
}
