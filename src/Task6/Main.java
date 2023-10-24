package Task6;


public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = addAnnotations();
        AnnotatedImage annotatedImage = new AnnotatedImage("some path", annotations);
        System.out.println(annotatedImage.findByLabel("Second comment"));
        System.out.println(annotatedImage.findByPoint(5, 8));
        Annotation annotation = annotatedImage.findByLabel("Second comment");
        annotation.moveFigure(4, 8);
    }

    public static Annotation[] addAnnotations() {
        Annotation[] annotations = new Annotation[]{new Annotation("First comment", new Circle(4, 7, 8)),
                new Annotation("Second comment", new Rectangle(3, 7, 2, 8)),
                new Annotation("Some changes", new Rectangle(4, 8, 1, 4)),
                new Annotation("Final changes", new Circle(5, 8, 2))};
        return annotations;
    }
}
