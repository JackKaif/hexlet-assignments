package exercise;

import static exercise.App.take;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        var list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        var actual1 = take(list, 2);
        assertThat(actual1.equals(Arrays.asList(1, 2))).isTrue();

        var actual2 = take(list, 5);
        assertThat(actual2.equals(Arrays.asList(1, 2, 3, 4))).isTrue();

        var actual3 = take(list, -1);
        assertThat(actual3.equals(List.of())).isTrue();

        var actual4 = take(List.of(), 2);
        assertThat(actual4.equals(List.of())).isTrue();
        // END
    }
}
