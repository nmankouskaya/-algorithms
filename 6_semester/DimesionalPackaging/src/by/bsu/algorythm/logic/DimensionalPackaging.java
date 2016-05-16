package by.bsu.algorythm.logic;

import by.bsu.algorythm.entity.Level;
import by.bsu.algorythm.entity.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 5/16/2016.
 */
public class DimensionalPackaging {

    public static List<Level> positiveContainer(List<Rectangle> rectangleList) {
        double l = rectangleList.get(0).getLength();
        double w = 0;
        List<Level> result = execute(rectangleList, l, w);
        return result;
    }

    public static List<Level> infinityLine(List<Rectangle> rectangleList) {
        double l = 20;
        double w = 0;
        List<Level> result = execute(rectangleList, l, w);
        return result;
    }

    public static List<Level> container(List<Rectangle> rectangleList) {
        double l = 10;
        double w = 10;
        List<Level> result = execute(rectangleList, l, w);
        return result;
    }

    private static List<Level> execute(List<Rectangle> rectangleList, double length, double width) {
        double currentLength = length;
        double currentWidth = width;
        List<Level> levelList = new ArrayList<Level>();
        while( !rectangleList.isEmpty() ){
            currentLength = length;
            currentWidth = ( width != 0 ) ? width : rectangleList.get(0).getWidth() ;
            Level level = new Level(currentWidth);
            for(Rectangle rec : rectangleList){
                if(currentLength >= rec.getLength()){
                    level.addRectangle(rec);
                    currentLength-=rec.getLength();
                }
            }
            rectangleList.removeAll(level.getRectangleList());
            levelList.add(level);
        }

        return levelList;
    }

    private static double calculateLength(List<Rectangle> rectangleList){
        double l = 0;
        for(Rectangle rec: rectangleList){
            l+=rec.getLength();
        }
        l /= rectangleList.size();
        return l;
    }

}
