package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> singleTags;

    public PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> singleTags) {
        super(tag, attributes);
        this.body = body;
        this.singleTags = singleTags;
    }

    public String toString() {
        String value = singleTags.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        return String.format("<%s%s>%s%s</%s>", getTag(), getAttributesLine(), value, body, getTag());
    }
}
// END
