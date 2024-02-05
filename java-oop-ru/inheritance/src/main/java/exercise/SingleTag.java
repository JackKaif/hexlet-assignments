package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    public SingleTag(String tag, Map<String, String> attributes) {
        super(tag, attributes);
    }

    public String toString() {
        var result = new StringBuilder(String.format("<%s", this.getTag()));
        this.getAttributes().forEach((k, v) -> result.append(String.format(" %s=\"%s\"", k, v)));
        result.append(">");
        return result.toString();
    }
}
// END
