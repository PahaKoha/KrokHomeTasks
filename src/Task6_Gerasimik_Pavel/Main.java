package Task6_Gerasimik_Pavel;


import Task6_Gerasimik_Pavel.Figures.Circle;
import Task6_Gerasimik_Pavel.Figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Annotation[] annotations = getAnnotations();
        AnnotatedImage annotatedImage = new AnnotatedImage("some path1", annotations);
        System.out.println("---------------");
        Annotation annotation1 = annotatedImage.findByPoint(5,15);
        System.out.println(annotation1.toString());
        annotation1.moveFigure(4, 8);
        System.out.println(annotation1.toString());
        System.out.println("---------------");
        Annotation annotation2 = annotatedImage.findByLabel("First comment");
        System.out.println(annotation2.toString());
        annotation1.moveFigure(10, 2);
        System.out.println(annotation2.toString());
    }

    public static Annotation[] getAnnotations() {
        return new Annotation[]{new Annotation("First comment", new Circle(4, 7, 8)),
                new Annotation("Second comment", new Rectangle(3, 7, 5, 15)),
                new Annotation("Some changes", new Rectangle(4, 8, 1, 4)),
                new Annotation("Final changes", new Circle(5, 8, 2))};
    }
}
