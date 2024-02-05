package exercise;

import java.util.HashMap;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        var tempMap = new HashMap<String, String>();
        data.toMap().forEach((k, v) -> {
            tempMap.put(v, k);
            data.unset(k);
        });
        tempMap.forEach(data::set);
    }
}
// END
