package pl.rybialek;

import java.util.stream.IntStream;

public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            try {
                long sleepTime = (long) (Math.random() * 1000);
                buffer.get();
                System.out.println("Consumer has received: " + i + ", waiting " + sleepTime + "ms");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
