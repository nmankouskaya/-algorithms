package by.bsu.algorythm.utils;

import by.bsu.algorythm.entity.Rectangle;

import java.util.*;

/**
 * Created by Настенька on 5/16/2016.
 */
public class InitRectangle {

    public static List<Rectangle> init(int n){

        List<Rectangle> rectangleList = new ArrayList<Rectangle>();
        Random random = new Random();
        for(int i=0; i<n; i++){
            int l = random.nextInt(10) + 1;
            int w = random.nextInt(10) + 1;
            rectangleList.add(new Rectangle(w,l));
        }

        Collections.sort(rectangleList, new RectangleComparator());

        return  rectangleList;
    }

}
