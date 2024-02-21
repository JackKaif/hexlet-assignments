package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread{
    private final int[] array;

    private int max;

    public MaxThread(int[] array) {
        this.array = array;
    }
    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");
        max = Arrays.stream(array)
                .max()
                .orElse(0);
        System.out.println("Thread " + this.getName() + " finished");
    }

    public int getMax() {
        return max;
    }
}
// END
