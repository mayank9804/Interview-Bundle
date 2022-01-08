package com.codr.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Blocking Queue using Reentrant lock.
 */
public class ProducerConsumerReentrantLockConditions {
    public static void main(String...args) throws Exception {
        Queue<Integer> queue = new LinkedList<>();
        Lock lock = new ReentrantLock(); // Lock used for synchronizing critical section.
        Condition notFull = lock.newCondition(); // Condition for queue not being full.
        Condition notEmpty = lock.newCondition(); // Condition for queue not being empty.
        // Consumer
        Thread t2 = new Thread(() -> {
            try {
                new Consumer(queue, lock, notFull, notEmpty).run();
            } catch (InterruptedException e) {}
        });
        // Producer
        Thread t1 = new Thread(() -> {
            try {
                new Producer(queue, lock, notFull, notEmpty).run();
            } catch (InterruptedException e) {}
        });


        t1.start(); t2.start();
        Thread.sleep(2);
        t1.interrupt(); t2.interrupt();
    }
}

class Producer {
    private Queue<Integer> queue;
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    public Producer(Queue<Integer> queue, Lock lock, Condition notFull, Condition notEmpty) {
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    public void run() throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                while (queue.size() == 5) {
                    System.out.println("Thread named : " + Thread.currentThread().getName()
                            + " going to wait for consumer thread to tell the queue is not full");
                    notFull.await();
                }
                int randInt = new Random().nextInt();
                queue.add(randInt);
                System.out.println("Producer thread named : " + Thread.currentThread().getName()
                        + " produced " + randInt);
                notEmpty.signalAll();
            } finally {
                lock.unlock(); // Remember to unlock a thread, to give other chance the thread while this one is waiting.
            }
        }
    }
}

class Consumer {
    private Queue<Integer> queue;
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;

    public Consumer(Queue<Integer> queue, Lock lock, Condition notFull, Condition notEmpty) {
        this.queue = queue;
        this.lock = lock;
        this.notFull = notFull;
        this.notEmpty = notEmpty;
    }

    public void run() throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (queue.isEmpty()) {
                    System.out.println("Thread named : " + Thread.currentThread().getName()
                            + " going to wait for producer thread to tell the queue is not empty");
                    notEmpty.await();
                }
                System.out.println("Consumer thread named : " + Thread.currentThread().getName()
                        + " consumed " + queue.poll());
                notFull.signalAll();
            } finally {
                System.out.println("hello " + Thread.currentThread().getName());
                lock.unlock();
            }
        }
    }
}