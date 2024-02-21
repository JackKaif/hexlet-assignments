package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private final int[] array;

    private int min;

    public MinThread(int[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        min = Arrays.stream(array)
                .min()
                .orElse(0);
        System.out.println("Thread " + this.getName() + " finished");
    }

    public int getMin() {
        return min;
    }
}
// END
