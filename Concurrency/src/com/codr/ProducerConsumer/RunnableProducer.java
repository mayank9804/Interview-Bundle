package com.codr.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class RunnableProducer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public RunnableProducer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                int randInt = new Random().nextInt();
                blockingQueue.put(randInt);
                System.out.println("Producer thread named : " + Thread.currentThread() + ", produced item : " + randInt);
            } catch (InterruptedException e) {
                System.out.println("Producer thread named : " + Thread.currentThread() + " interrupted.");
                return;
            }
        }
    }
}
