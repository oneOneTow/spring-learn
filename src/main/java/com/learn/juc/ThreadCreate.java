package com.learn.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: luzhiqing
 * @date: 2021/3/10
 * @version:
 */
public class ThreadCreate {
    public static void main(String[] args) {
        RunnableTest test = new RunnableTest();
        Thread thread = new Thread(test);
        thread.start();

        CallableTest callableTest = new CallableTest();
        FutureTask<String>  task = new FutureTask<>(callableTest);
        new Thread(task).start();
        try {
            String s = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class RunnableTest implements Runnable{

    @Override
    public void run() {
        System.out.println("lzq");
    }
}

class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "lzq";
    }
}