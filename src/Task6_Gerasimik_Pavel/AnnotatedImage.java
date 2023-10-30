package Task6_Gerasimik_Pavel;

import Task6_Gerasimik_Pavel.Figures.Circle;
import Task6_Gerasimik_Pavel.Figures.Figure;
import Task6_Gerasimik_Pavel.Figures.Rectangle;

public class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int pointX, int pointY) {
        for (Annotation annotation : annotations) {
            Figure figure = annotation.getFigure();
            if ((figure instanceof Rectangle r)) {
                if (isPointInsideRectangle(r.getX(), r.getY(), r.getX1(), r.getY1(), pointX, pointY)) {
                    return annotation;
                }
            } else if (figure instanceof Circle c) {
                if (isPointInsideCircle(c.getX(), c.getY(), c.getRadius(), pointX, pointY)) {
                    return annotation;
                }
            }
        }
        return new Annotation("Такой аннотации не существует:(", new Figure(0,0) {
            @Override
            public String toString() {
                return "Я несуществующая фигура!";
            }
        });
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.getLabel().contains(label)) {
                return annotation;
            }
        }
        return null;
    }

    public static boolean isPointInsideRectangle(int x, int y, int x1, int y1, int pointX, int pointY) {
        return (pointX >= x && pointX <= x1) && (pointY >= y && pointY <= y1);
    }

    public static boolean isPointInsideCircle(int cx, int cy, int r, int x, int y) {
        int distance = (x - cx) * (x - cx) + (y - cy) * (y - cy);
        return distance <= r * r;
    }
}

