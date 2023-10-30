package Task6_Gerasimik_Pavel.Figures;

import Task6_Gerasimik_Pavel.Movable;

public abstract class Figure implements Movable {
    protected int x;
    protected int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
