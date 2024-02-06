package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filepath, Car car) throws Exception {
        Files.writeString(filepath, car.serialize(), StandardOpenOption.CREATE);
    }

    public static Car extract(Path filepath) throws Exception {
        return Car.unserialize(Files.readString(filepath));
    }
}
// END
