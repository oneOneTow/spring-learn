package com.learn.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: luzhiqing
 * @date: 2021/3/11
 * @version:
 */
public class CountDownLatchTest {
    public static void main(String[] args) {

        Videoconference conference = new Videoconference(10);

        Thread threadConference = new Thread(conference);

        threadConference.start();

        for (int i = 0; i < 10; i++) {
//            Participant p = new Participant(conference);
//            Thread t = new Thread(p);
//            t.start();
        }
    }
}

class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {

        System.out.printf("");

        controller.countDown();

        System.out.printf("");
    }

    @Override
    public void run() {
        try {
            controller.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


class Participant implements Runnable {

    private Videoconference conference;

    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

