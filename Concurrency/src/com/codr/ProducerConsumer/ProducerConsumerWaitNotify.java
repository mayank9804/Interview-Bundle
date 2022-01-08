package com.codr.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Implementation of Producer Consumer using wait-notify.
 * Wait/Notify/Notify all should be invoked by thread that is owner of the object's monitor, on which it is invoked.
 * A thread becomes owner of object's monitor in below ways :
 * 1. By executing a synchronized instance method of that object.
 * 2. By executing the body of a {synchronized} statement that synchronizes on the object.
 *
 * Check the usage of this keyword in synchronized keyword below. If you had to use some other object's monitor, you should have
 * passed that object reference in place of this.
 */
public class ProducerConsumerWaitNotify {

    public void enact() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        PCQueue pcQueue = new PCQueue();
        executorService.submit(() -> {
            try {
                pcQueue.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                pcQueue.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String...args) throws Exception {
        new ProducerConsumerWaitNotify().enact();
    }
}

class PCQueue {
    private Queue<Integer> queue = new LinkedList<>();
    public static int MAX_CAPACITY = 5;
    public void produce() throws Exception {
        while (true) {
            synchronized (this) {
                while(queue.size() == MAX_CAPACITY) {
                    System.out.println("Thread named : " + Thread.currentThread().getName()
                            + " going to wait for consumer thread to tell the queue is not full");
                    wait();
                }
                int randInt = new Random().nextInt();
                queue.add(randInt);
                System.out.println("Producer thread named : " + Thread.currentThread().getName()
                        + " produced " + randInt);
                notifyAll();
                System.out.println("Gonna sleep");
                Thread.sleep(1);
            }
        }
    }

    public void consume() throws Exception {
        while (true) {
            synchronized (this) {
                while(queue.isEmpty()) {
                    System.out.println("Thread named : " + Thread.currentThread().getName()
                            + " going to wait for producer thread to tell the queue is not empty");
                    wait();
                    System.out.println("Got a signal");
                }
                System.out.println("Consumer thread named : " + Thread.currentThread().getName()
                        + " consumed " + queue.poll());
                notifyAll();
            }
        }
    }
}

