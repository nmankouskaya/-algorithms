package by.bsu.utils;

import by.bsu.entity.Container;
import by.bsu.entity.Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 4/26/2016.
 */
public class Packaging {

    // следующий подходящий
    public static List<Container> nextSuitable(List<Package> list) {

        List<Container> containerList = new ArrayList<>();

        while (!list.isEmpty()) {
            Container c = new Container();
            for (Package p : list) {
                if( c.getFreeSpace() >= p.getWeight() ){
                    c.addPackage(p);
                } else {
                    break;
                }
            }
            containerList.add(c);
            for( Package p : c.getPackageList() ){
                list.remove(p);
            }
        }
        return containerList;
    }

    //первый подходящий
    public static List<Container> firstSuitable(List<Package> list){

        List<Container> containerList = new ArrayList<>();

        Container c = new Container();
        c.addPackage( list.get(0) );
        containerList.add( c );

        list.remove(0);

        boolean status = false;
        for (Package p : list) {
            status = false;
            for(Container con : containerList){
                if( con.getFreeSpace() >= p.getWeight() ){
                    con.addPackage(p);
                    status = true;
                    break;
                }
            }
            if( !status ){
                Container container = new Container();
                container.addPackage(p);
                containerList.add(container);
            }
        }

        return containerList;
    }

    public static List<Container> bestSuitable(List<Package> list){

        List<Container> containerList = new ArrayList<>();

        Container c = new Container();
        c.addPackage( list.get(0) );
        containerList.add( c );

        list.remove(0);

        boolean status = false;
        for (Package p : list) {
            status = false;
            List<Container> tmpList = new ArrayList<>();
            for (Container con : containerList) {
                if (con.getFreeSpace() >= p.getWeight()) {
                    tmpList.add(con);
                }
            }
            Container container;
            if( !tmpList.isEmpty() ){
                container = getOptimalContainer(tmpList);
                container.addPackage(p);
            } else {
                container = new Container();
                container.addPackage(p);
                containerList.add(container);
            }
        }

        return containerList;
    }

    // определяем контейнер, который наиболее заполнен, то есть в нём минимально свободного места
    private static Container getOptimalContainer( List<Container> list ){

        Container container = list.get(0);
        double minFreeSpace = container.getFreeSpace();

        for(Container c : list){
            if(c.getFreeSpace() < minFreeSpace){
                minFreeSpace = c.getFreeSpace();
                container = c;
            }
        }

        return container;
    }

}

