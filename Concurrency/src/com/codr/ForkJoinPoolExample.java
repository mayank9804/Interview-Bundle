package com.codr;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * An implementation of ExecutorService, suitable for efficient processing when most tasks spawn other subtasks.
 * It is different from other implementations in a way that here each worker thread holds worker queue,
 * where subtasks are pushed, if not pool's global queue. Threads also attempts stealing tasks from other worker queues.
 */
public class ForkJoinPoolExample {
    public void execute() throws Exception {
        int proc = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of available core in the processor is: " + proc);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        System.out.println("Active threads before invoking : " + pool.getActiveThreadCount());
        System.out.println("Main thread - " + Thread.currentThread().getName());
        Fibonnaci f = new Fibonnaci(7);
        pool.submit(f);
        while(!f.isDone()) {
            System.out.println("Running threads : " + pool.getRunningThreadCount());
            System.out.println("Active threads after invoking : " + pool.getActiveThreadCount());
            System.out.println("Common Pool Size is: " + pool.getPoolSize());
        }
        Integer number = f.get();
        System.out.println("8th fibonnaci is : " + number);
    }
}

/**
 * Class that computes nth fibonacci number.
 */
class Fibonnaci extends RecursiveTask<Integer> {
    private int n;

    public Fibonnaci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n < 2)
            return n;
        System.out.println(Thread.currentThread().getName() + " for n = " + n);
        Fibonnaci f1 = new Fibonnaci(n-1);
        f1.fork();
        Fibonnaci f2 = new Fibonnaci(n-2);
        f2.fork();
        return f1.join() + f2.join();
    }
}