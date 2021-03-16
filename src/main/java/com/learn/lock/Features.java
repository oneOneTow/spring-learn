package com.learn.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: luzhiqing
 * @date: 2021/3/2
 * @version:
 */
public class Features {
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(()->{
            return "luzhiqing";
        });
        new Thread(task).start();
        try {
            task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



