package pl.rybialek;

public class Buffer {

    private int content;
    private boolean isEmpty = true;

    public synchronized void put(int value) throws InterruptedException {
        while (!isEmpty) {
            wait();
        }
        content = value;
        isEmpty = false;
        notify();
    }

    public synchronized int get() throws InterruptedException {
        while (isEmpty) {
            wait();
        }
        isEmpty = true;
        notify();

        return content;
    }
}
