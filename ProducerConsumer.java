import java.util.LinkedList;

public class ProducerConsumer {
    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 2;

        // Producer thread
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    synchronized (buffer) {
                        while (buffer.size() == capacity) buffer.wait();
                        buffer.add(i);
                        System.out.println("Produced: " + i);
                        buffer.notify();
                    }
                }
            } catch (InterruptedException ignored) {}
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    synchronized (buffer) {
                        while (buffer.isEmpty()) buffer.wait();
                        System.out.println("Consumed: " + buffer.removeFirst());
                        buffer.notify();
                    }
                }
            } catch (InterruptedException ignored) {}
        }).start();
    }
}