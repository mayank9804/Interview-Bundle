package com.codr.ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class RunnableConsumer implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public RunnableConsumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer thread named : " + Thread.currentThread() +
                        ", consuming item " + blockingQueue.take());
            } catch (InterruptedException e) {
                System.out.println("Consumer thread named : " + Thread.currentThread() + " interrupted.");
                return ;
            }
        }
    }
}
