package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final HashMap<String, String> data;

    public InMemoryKV(Map<String, String> data) {
        this.data = new HashMap<>(data);
    }

    public void set(String key, String value) {
        this.data.put(key, value);
    }

    public void unset(String key) {
        this.data.remove(key);
    }

    public String get(String key, String defaultValue) {
        return this.data.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return new HashMap<>(this.data);
    }
}
// END
