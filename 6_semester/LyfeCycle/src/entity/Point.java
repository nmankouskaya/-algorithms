package entity;

/**
 * Created by Настенька on 4/16/2016.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("x=" + x);
        sb.append(" y=" + y);
        return sb.toString();
    }
}
