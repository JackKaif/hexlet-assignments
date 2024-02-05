package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String sequence;
    public ReversedSequence(String sequence) {
        var reversedSequence = new StringBuilder(sequence);
        this.sequence = reversedSequence.reverse().toString();
    }

    @Override
    public int length() {
        return this.sequence.length();
    }

    @Override
    public char charAt(int index) {
        return this.sequence.toCharArray()[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.sequence.substring(start, end);
    }

    @Override
    public String toString() {
        return this.sequence;
    }
}
// END
