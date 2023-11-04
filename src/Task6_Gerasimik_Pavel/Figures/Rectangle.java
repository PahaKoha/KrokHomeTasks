package Task6_Gerasimik_Pavel.Figures;

public class Rectangle extends Figure{
    private int x1;
    private int y1;

    public Rectangle(int x, int y, int x1, int y1) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void move(int dx, int dy) {
        super.move(dx, dy);
        x1 += dx;
        y1 += dy;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
    @Override
    public boolean containsPoint(int x, int y) {
        return (x >= this.x && x <= this.x1) && (y >= this.y && y <= this.y1);
    }

    @Override
    public String toString() {
        return "Rectangle (" + x + ", " + y + "), (" + (x1) + ", " + (y1) + ")";
    }
}
