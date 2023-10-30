package Task6_Gerasimik_Pavel.Figures;

public class Circle extends Figure{
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public String toString() {
        return "Circle (" + x + ", " + y + "), " + radius;
    }
}
