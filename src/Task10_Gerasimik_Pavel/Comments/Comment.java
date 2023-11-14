package Task10_Gerasimik_Pavel.Comments;

public class Comment {
    private String label;

    public Comment(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "label='" + label + '\'' +
                '}';
    }
}
