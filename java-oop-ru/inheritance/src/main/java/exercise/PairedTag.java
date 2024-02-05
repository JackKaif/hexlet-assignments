package exercise;

import java.util.Map;
import java.util.List;

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
        var result = new StringBuilder(String.format("<%s", this.getTag()));
        this.getAttributes().forEach((k, v) -> result.append(String.format(" %s=\"%s\"", k, v)));
        result.append(">");
        singleTags.forEach(tag -> result.append(tag.toString()));
        result.append(body);
        result.append(String.format("</%s>", this.getTag()));
        return result.toString();
    }
}
// END
