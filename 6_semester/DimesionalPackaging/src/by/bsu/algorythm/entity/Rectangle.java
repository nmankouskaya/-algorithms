package by.bsu.algorythm.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 5/16/2016.
 */
public class Rectangle {

    private int width;
    private int length;

    public Rectangle() {
        this.width = 0;
        this.length = 0;
    }

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Rectangle: ");
        sb.append(" width: " +  width);
        sb.append(" length: " + length);
        return sb.toString();
    }

}
