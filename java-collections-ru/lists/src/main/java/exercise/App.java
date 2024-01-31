package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word){
        List<String> wordLetters = new ArrayList<String>(Arrays.asList(word.toLowerCase().split("")));
        List<String> scrabbleLetters = new ArrayList<String>(Arrays.asList(letters.toLowerCase().split("")));
        for (var letter: wordLetters) {
            if (!scrabbleLetters.contains(letter)) {
                return false;
            }
            scrabbleLetters.remove(letter);
        }
        return true;
    }
}
//END
