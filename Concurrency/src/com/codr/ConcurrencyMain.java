package com.codr;

public class ConcurrencyMain {
    public static void main(String[]args) throws Exception {
        ForkJoinPoolExample f = new ForkJoinPoolExample();
        f.execute();
    }
}
