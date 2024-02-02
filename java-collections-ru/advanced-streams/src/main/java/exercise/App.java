package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App {
    public static String getForwardedVariables(String file) {
        var fileStringsList = Arrays.asList(file.split("\\r\n"));
        return fileStringsList.stream()
                .filter(string -> string.startsWith("environment"))
                .map(string -> {
                    string = string.replaceAll("environment=\"", "");
                    string = string.replaceAll("\"", "");
                    return string;
                })
                .flatMap(string -> Arrays.stream(string.split(",")))
                .filter(string -> string.startsWith("X_FORWARDED_"))
                .map(string -> string.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
