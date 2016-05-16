package by.bsu.algorythm;

import by.bsu.algorythm.entity.Level;
import by.bsu.algorythm.entity.Rectangle;
import by.bsu.algorythm.logic.DimensionalPackaging;
import by.bsu.algorythm.utils.CalculateFreeSquare;
import by.bsu.algorythm.utils.InitRectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        System.out.println("############# 1 #############");

        List<Rectangle> rectangleList = InitRectangle.init(5);
        System.out.println("Rectangle list:");
        for(Rectangle rec : rectangleList){
            System.out.println(rec);
        }

        List<Rectangle> rectangleList2 = new ArrayList<Rectangle>();
        for(int i=0; i< 5; i++){
            rectangleList2.add(new Rectangle());
        }
        List<Rectangle> rectangleList3 = new ArrayList<Rectangle>();
        for(int i=0; i< 5; i++){
            rectangleList3.add(new Rectangle());
        }
        Collections.copy(rectangleList2, rectangleList);
        Collections.copy(rectangleList3, rectangleList);

        List<Level> levelList = DimensionalPackaging.positiveContainer(rectangleList);

        System.out.println("Level list:");
        for(Level level : levelList){
            System.out.println(level);
        }

        System.out.println("Free Square: " + CalculateFreeSquare.calculate(levelList));

        System.out.println("############# 2 #############");

        List<Level> levelList2 = DimensionalPackaging.infinityLine(rectangleList2);

        System.out.println("Level list 2:");
        for(Level level : levelList2){
            System.out.println(level);
        }

        System.out.println("Free Square: " + CalculateFreeSquare.calculate(levelList));

        System.out.println("############# 3 #############");

        List<Level> levelList3 = DimensionalPackaging.container(rectangleList3);

        System.out.println("Level list 3:");
        for(Level level : levelList3){
            System.out.println(level);
        }

        System.out.println("Free Square: " + CalculateFreeSquare.calculate(levelList));
    }
}
