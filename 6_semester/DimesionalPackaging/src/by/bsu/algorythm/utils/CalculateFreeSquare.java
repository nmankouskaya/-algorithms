package by.bsu.algorythm.utils;

import by.bsu.algorythm.entity.Level;
import by.bsu.algorythm.entity.Rectangle;

import java.util.List;

/**
 * Created by Настенька on 5/16/2016.
 */
public class CalculateFreeSquare {

    public static double calculate(List<Level> levelList){
        double square = findWidth(levelList) * findMaxLength(levelList) ;
        double currentSquare = getCurrentSquare(levelList);
        return square - currentSquare;
    }

    public static double findWidth(List<Level> levelList){
        double width = 0;
        for(Level level : levelList){
            width += level.getHeight();
        }
        return width;
    }

    public static double findMaxLength(List<Level> levelList){
        double max = 0 ;
        for(Level level : levelList){
            List<Rectangle> list = level.getRectangleList();
            double tmp = 0;
            for(Rectangle rec: list){
                tmp += rec.getLength();
            }
            if(max < tmp){
                max = tmp;
            }
        }
        return max;
    }

    public static double getCurrentSquare(List<Level> levelList){
        double s = 0 ;
        for(Level level : levelList){
            List<Rectangle> list = level.getRectangleList();
            for(Rectangle rec: list){
                s += rec.getLength() * rec.getWidth();
            }
        }
        return s;
    }
}
