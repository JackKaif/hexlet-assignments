package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Tag {
    private final String tag;
    private final Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String getAttributesLine() {
        return attributes.keySet().stream()
                .map(key -> {
                    var value = attributes.get(key);
                    return String.format(" %s=\"%s\"", key, value);
                })
                .collect(Collectors.joining(""));
    }

    public String getTag() {
        return tag;
    }
}
// END
