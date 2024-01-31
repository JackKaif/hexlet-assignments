package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var wordsFrequency = new HashMap<String, Integer>();
        if (sentence.isEmpty()) {
            return wordsFrequency;
        }
        var words = sentence.split(" ");
        for (var word : words) {
            var count = wordsFrequency.getOrDefault(word, 0);
            wordsFrequency.put(word, count + 1);
        }
        return wordsFrequency;
    }
    public static String toString(Map<String, Integer> map) {
        var result = new StringBuilder();
        if (map.isEmpty()) {
            result.append("{}");
            return result.toString();
        }
        result.append("{\n");
        map.forEach((key, value) -> {
            result.append("  ");
            result.append(key);
            result.append(": ");
            result.append(value);
            result.append("\n");
        });
        result.append("}");
        return result.toString();
    }
}
//END
