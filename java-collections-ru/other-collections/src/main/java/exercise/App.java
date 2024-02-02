package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

// BEGIN
class App {
    public static <T> LinkedHashMap<String, String> genDiff(Map<String, T> firstMap, Map<String, T> secondMap) {
        var keySet = new TreeSet<String>();
        firstMap.forEach((k, v) -> keySet.add(k));
        secondMap.forEach((k, v) -> keySet.add(k));
        var result = new LinkedHashMap<String, String>();
        keySet.forEach(key -> {
            var keyInFirstMap = firstMap.containsKey(key);
            var keyInSecondMap = secondMap.containsKey(key);
            if (keyInFirstMap && keyInSecondMap) {
                if (firstMap.get(key).equals(secondMap.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (keyInFirstMap) {
                    result.put(key, "deleted");
            } else if (keyInSecondMap) {
                result.put(key, "added");
            }
        });
        return result;
    }
}
//END
