package exercise;

import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(gender -> gender.get("gender").equals("male"))
                .sorted((map1, map2) -> {
                    var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    var date1 = LocalDate.parse(map1.get("birthday"), dateFormatter);
                    var date2 = LocalDate.parse(map2.get("birthday"), dateFormatter);
                    return date1.compareTo(date2);
                })
                .map(name -> name.get("name"))
                .toList();
    }
}
// END
