package com.learn.juc;

import java.util.concurrent.Semaphore;

/**
 * @author: luzhiqing
 * @date: 2021/3/11
 * @version:
 */
public class SemaphoreTest {


    public static void main(String args[]) {

        //16. 创建PrintQueue对象名为printQueue。
        PrintQueue printQueue = new PrintQueue();

        //17. 创建10个threads。每个线程会执行一个发送文档到print queue的Job对象。
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        //18. 最后，开始这10个线程们。
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }

    }

}


class PrintQueue {


    private final Semaphore semaphore;


    public PrintQueue() {
        semaphore = new Semaphore(1);
    }


    public void printJob(Object document) {


        try {

            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}


class Job implements Runnable {


    private PrintQueue printQueue;


    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {

        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());

        printQueue.printJob(new Object());

        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}

