package Task6_Gerasimik_Pavel;

import Task6_Gerasimik_Pavel.Figures.Figure;

public class Annotation {
    private String label;
    private Figure figure;

    public Annotation(String label, Figure figure) {
        this.label = label;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + label;
    }

    public String getLabel() {
        return label;
    }

    public Figure getFigure() {
        return figure;
    }

    public void moveFigure(int dx, int dy) {
        figure.move(dx, dy);
    }
}
