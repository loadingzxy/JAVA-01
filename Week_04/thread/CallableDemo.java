package week4.thread;

import java.util.concurrent.Callable;

/**
 * @program: week3
 * @description: 线程实现方法callable
 * @author: zhxy
 * @create: 2021-02-06 00:40
 **/
public class CallableDemo {

    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "test callable";
            }
        };

        System.out.println("子线程的值：" + callable);
        System.out.println("当前线程：" + Thread.currentThread().getName());
    }
}
