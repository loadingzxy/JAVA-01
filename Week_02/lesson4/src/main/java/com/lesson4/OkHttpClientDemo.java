package com.lesson4;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class OkHttpClientDemo {

    private static final String URL = "http://localhost:8801";
    private static final int TIME_OUT = 1000;
    private static final long RUN_SECONDS = Runtime.getRuntime().availableProcessors() * 5;
    private static final int THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        long startMillis = System.currentTimeMillis();
        long timeoutMillis = TimeUnit.SECONDS.toMillis(RUN_SECONDS);
        long endMillis = startMillis + timeoutMillis;
        AtomicInteger count = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            executorService.execute(() -> {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)//设置连接超时时间
                        .readTimeout(TIME_OUT, TimeUnit.SECONDS)//设置读取超时时间
                        .build();
                Request.Builder builder = new Request.Builder().url(URL);
                Call call = client.newCall(builder.build());
                try (
                        Response response = call.execute()) {
                    while (System.currentTimeMillis() < endMillis && !Thread.interrupted()) {
                        System.out.printf("status:%s content:%s%n", response.isSuccessful(), response.body().string());
                        count.incrementAndGet();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // 循环
//        executorService.shutdown();

        try {
            if (executorService.awaitTermination(RUN_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("所有线程执行结束");
            } else {
                System.out.println("任务没执行完，时间到");
                // 给所有在执行的线程中断信号
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("总共%d次请求", count.get());
    }
}