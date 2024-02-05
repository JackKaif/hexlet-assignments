package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversedSequenceTest {
    CharSequence sequence = new ReversedSequence("abcdef");

    @Test
    public void testReversedSequence() {
        assertEquals("fedcba", sequence.toString());
        assertEquals('e', sequence.charAt(1));
        assertEquals(6, sequence.length());
        assertEquals("edc", sequence.subSequence(1, 4).toString());
    }
}
