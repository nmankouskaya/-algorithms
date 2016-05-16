package by.bsu.utils;

import by.bsu.entity.Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Настенька on 4/26/2016.
 */
public class InitPackage {

    public static List<Package> init(){

        List<Package> list = new ArrayList<>();

        // раскоментить и поставить в классе Container полю freeSpace в конструкторе вместо 1 значение 5
        // закоментить то, что идёт дальше, начиная с Random

        /*list.add(new Package(1, 1));
        list.add(new Package(2, 2));
        list.add(new Package(3, 3));
        list.add(new Package(4, 2));
        list.add(new Package(5, 2));
        list.add(new Package(6, 3));
        list.add(new Package(7, 4));
        list.add(new Package(8, 1));
        list.add(new Package(9, 1));*/

        Random rand = new Random();
        for(int i=1; i <= 10; i++){
            list.add( new Package(i, rand.nextDouble()) );
        }

        return list;
    }
}
