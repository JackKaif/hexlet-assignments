package exercise;

// BEGIN
import java.util.Map;

class FileKV implements KeyValueStorage {

    private final String filepath;

    FileKV(String filepath, Map<String, String> initial) {
        this.filepath = filepath;
        Map<String, String> data = loadData();
        data.putAll(initial);
        saveFile(data);
    }

    private Map<String, String> loadData() {
        String content = Utils.readFile(this.filepath);
        Map<String, String> data = Utils.unserialize(content);
        return data;
    }

    private void saveFile(Map<String, String> data) {
        Utils.writeFile(this.filepath, Utils.serialize(data));
    }

    public void set(String key, String value) {
        Map<String, String> data = loadData();
        data.put(key, value);
        saveFile(data);
    }

    public void unset(String key) {
        Map<String, String> data = loadData();
        data.remove(key);
        saveFile(data);
    }

    public String get(String key, String defaultValue) {
        Map<String, String> data = loadData();
        return data.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        return loadData();
    }


}
// END
