package by.bsu.algorythm.utils;

import by.bsu.algorythm.entity.Rectangle;

import java.util.Comparator;


/**
 * Created by Настенька on 5/16/2016.
 */
public class RectangleComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if (o1.getLength() > o2.getLength()) {
            return -1;
        } else if (o1.getLength() == o2.getLength()) {
            return 0;
        } else {
            return 1;
        }
    }
}
