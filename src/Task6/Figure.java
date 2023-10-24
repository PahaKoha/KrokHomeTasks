package Task6;

public abstract class Figure implements Movable {
    protected int x;
    protected int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

class Rectangle extends Figure {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
    }

    @Override
    public String toString() {
        return "Rectangle (" + x + ", " + y + "), (" + (x + width) + ", " + (y + height) + ")";
    }
}

class Circle extends Figure {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
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
