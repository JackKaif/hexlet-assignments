package exercise;

// BEGIN
import java.util.List;

public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int numOfElements) {
        return apartments.stream()
                .sorted(Home::compareTo)
                .limit(numOfElements)
                .map(Home::toString)
                .toList();
    }
}
// END
