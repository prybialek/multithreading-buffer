package pl.rybialek;

import java.util.stream.IntStream;

public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            try {
                long sleepTime = (long) (Math.random() * 1000);
                buffer.put(i);
                System.out.println("Producer has added: " + i + ", waiting " + sleepTime + "ms");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
