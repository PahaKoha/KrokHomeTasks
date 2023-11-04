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
            if (figure.containsPoint(pointX,pointY)) {
                return annotation;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for (Annotation annotation : annotations) {
            if (annotation.getLabel().contains(label)) {
                return annotation;
            }
        }
        return null;
    }
}

