package com.codr.ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This example implements producer consumer problem using JAVA thread safe Blocking Queue.
 */
public class ProducerConsumerBlockingQueue {
    private static int BLOCKING_QUEUE_CAPACITY = 2;

    public void enact() {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);
        // Cached thread pool will create a thread as and when task is submitted,
        // but will try to reuse any previous thread available.
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new RunnableProducer(blockingQueue)); // Producer 1
        executorService.submit(new RunnableProducer(blockingQueue)); // Producer 2
        executorService.submit(new RunnableProducer(blockingQueue)); // Producer 3
        executorService.submit(new RunnableProducer(blockingQueue)); // Producer 4
        executorService.submit(new RunnableConsumer(blockingQueue)); // Consumer 1
        executorService.submit(new RunnableConsumer(blockingQueue)); // Consumer 2

        try {
            Thread.sleep(1);
            executorService.shutdownNow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
