package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private final String label;
    private final TagInterface taggedText;

    public LabelTag(String label, TagInterface taggedText) {
        this.label = label;
        this.taggedText = taggedText;
    }

    public String render() {
        return String.format("<label>%s%s</label>", label, taggedText.render());
    }
}
// END
