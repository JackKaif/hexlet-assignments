package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> dictionary) {
        var overlaps = new ArrayList<Map<String, String>>();
        for (var book: books) {
            if (book.entrySet().containsAll(dictionary.entrySet())) {
                overlaps.add(book);
            }
        }
        return overlaps;
    }
}
//END
