package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String file) {
        var fileStringsList = Arrays.asList(file.split("\\r\n"));
        return fileStringsList.stream()
                .filter(string -> string.startsWith("environment"))
                .map(string -> string.replaceAll("environment=\"", ""))
                .map(string -> string.replaceAll("\"", ""))
                .flatMap(string -> Arrays.stream(string.split(",")))
                .filter(string -> string.startsWith("X_FORWARDED_"))
                .map(string -> string.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
