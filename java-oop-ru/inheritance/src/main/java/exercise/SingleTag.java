package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    public SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    public String toString() {
        return String.format("<%s%s>", getTag(), getAttributesLine());
    }
}
// END
