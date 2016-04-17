package by.bsu.algorithm.domain;

/**
 * Created by Настенька on 12/16/2015.
 */
public class Vertex {
    int v;
    int label;
    int color;
    int time_bigin;
    int time_end;
    int deg;

    public Vertex(int v) {
        this.v = v;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getTime_bigin() {
        return time_bigin;
    }

    public void setTime_bigin(int time_bigin) {
        this.time_bigin = time_bigin;
    }

    public int getTime_end() {
        return time_end;
    }

    public void setTime_end(int time_end) {
        this.time_end = time_end;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return " " + v + " ";
    }
}
