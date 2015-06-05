package com.tw.hello.asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 可以尽早的完成计算,而节省了大量的等待时间,在用的时候可以直接 task.get()
 *
 * @author len
 */
public class FutureTaskTest {
    // 创建一个任务,而这个任务可以作为一个线程单独运行
    private static final FutureTask<List<String>> task = new FutureTask<List<String>>(
            new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    return doIt();
                }
            });
    private static List<String> loadResult;

    private static List<String> doIt() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf((char) (65 + i)));
            System.out.println("加载中...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void load() {
        Thread loadThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("加载中...");
                try {
                    task.run();
                    loadResult = task.get();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        loadThread.start();
    }

    public static void main(String args[]) {
        load();
        for (int i = 0; i < 10; i++) {
            System.out.println("google");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

