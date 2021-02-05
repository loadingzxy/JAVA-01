package week4.thread;

import java.util.concurrent.*;

/**
 * @program: week3
 * @description: completeService线程方法
 * @author: zhxy
 * @create: 2021-02-06 00:50
 **/
public class CompletionServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executorService);
        Future<String> submit = executorCompletionService.submit(() -> {
            return "child";
        });

        System.out.println("child thread：" + submit.get());
        System.out.println("curr：" + Thread.currentThread().getName());
    }
}
