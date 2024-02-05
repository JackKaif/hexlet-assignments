package exercise;

import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String tag;
    private final Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public abstract String toString();

    public String getTag() {
        return tag;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
// END
