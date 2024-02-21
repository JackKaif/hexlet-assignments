package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;

public class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1path, String file2path, String resFilePath) {
        var futureReadFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(file1path).toAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        var futureReadFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Path.of(file2path).toAbsolutePath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return futureReadFile1.thenCombine(futureReadFile2, (line1, line2) -> {
            var resultString = line1.concat(line2);
            try {
                Files.writeString(Path.of(resFilePath).toAbsolutePath(), resultString);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return resultString;
        }).exceptionally(e -> {
            System.out.println("NoSuchFileException");
            return null;
        });
    }
    // END

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // BEGIN
        unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "resultFile.txt").get();
        // END
    }
}

