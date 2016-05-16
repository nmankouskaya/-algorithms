package by.bsu.algorythm.entity;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 5/16/2016.
 */
public class Level {
    private List<Rectangle> rectangleList;
    private double height;

    public Level(double height) {
        this.rectangleList = new ArrayList<Rectangle>();
        this.height = height;
    }

    public List<Rectangle> getRectangleList() {
        return rectangleList;
    }

    public void addRectangle(Rectangle rectangle) {
        this.rectangleList.add(rectangle);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Level ( width=" + height + " ):");
        for(Rectangle rec: rectangleList){
            sb.append(" rectangle: width=" + rec.getWidth() + " length=" + rec.getLength());
        }
        return sb.toString();
    }
}
