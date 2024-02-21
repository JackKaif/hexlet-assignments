package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        var maxThread = new MaxThread(array);
        var minThread = new MinThread(array);
        var result = new HashMap<String, Integer>();
        maxThread.start();
        minThread.start();
        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var max = maxThread.getMax();
        var min = minThread.getMin();
        result.put("max", max);
        result.put("min", min);
        return result;
    }
    // END
}
