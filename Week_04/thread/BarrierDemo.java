package week4.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: week3
 * @description: Barrier线程测试方法
 * @author: zhxy
 * @create: 2021-02-06 00:44
 **/
public class BarrierDemo {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start = System.currentTimeMillis();
        AtomicInteger result = new AtomicInteger();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        // 1.变换结果
        CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                result.set( result.get()+1);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        barrier.await();
        //这是得到的返回值
        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        // 然后退出main线程
    }
}
