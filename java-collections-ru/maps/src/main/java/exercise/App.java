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
}
//END
