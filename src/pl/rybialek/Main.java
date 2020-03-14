package pl.rybialek;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int N_THREADS = 2;

    public static void main(String[] args) {
	    Buffer buffer = new Buffer();
	    Producer producer = new Producer(buffer);
	    Consumer consumer = new Consumer(buffer);

        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        executorService.submit(producer);
        executorService.submit(consumer);
        executorService.shutdown();
    }
}
