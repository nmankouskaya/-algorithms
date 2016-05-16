package by.bsu;

import by.bsu.entity.Container;
import by.bsu.entity.Package;
import by.bsu.utils.InitPackage;
import by.bsu.utils.Packaging;

import java.util.List;

/**
 * Created by Настенька on 4/26/2016.
 */
public class Main {

    public static void main(String... args){

        List<Package> list = InitPackage.init();

        System.out.println("List:");
        for(Package p : list){
            System.out.print(p);
        }
        System.out.println("############################################################################");

        //вместимость контейнера <= 10
        List<Container> containerList = Packaging.nextSuitable(list);
        System.out.println("\nNext Suitable:");
        for(Container c : containerList){
            System.out.println(c);
        }

        System.out.println("\nContainer amount " + containerList.size()
                + " ; Genral free space " + countFreeSpace(containerList)
                + " ; Amount of not full containers " + countNotFullContainers(containerList));
        System.out.println("############################################################################");

        List<Package> list2 = InitPackage.init();
        List<Container> containerList2 = Packaging.firstSuitable(list2);
        System.out.println("\nFirst Suitable:");
        for(Container c : containerList2){
            System.out.println(c);
        }

        System.out.println("\nContainer amount " + containerList2.size()
                + " ; Genral free space " + countFreeSpace(containerList2)
                + " ; Amount of not full containers " + countNotFullContainers(containerList2));
        System.out.println("############################################################################");

        List<Package> list3 = InitPackage.init();
        List<Container> containerList3 = Packaging.bestSuitable(list3);
        System.out.println("\nBest Suitable:");
        for(Container c : containerList3){
            System.out.println(c);
        }

        System.out.println("\nContainer amount " + containerList3.size()
                + " ; Genral free space " + countFreeSpace(containerList3)
                + " ; Amount of not full containers " + countNotFullContainers(containerList3));
        System.out.println("############################################################################");

    }

    private static double countFreeSpace(List<Container> list){
        double general = 0;
        for(Container c : list){
            general += c.getFreeSpace();
        }
        return general;
    }

    private static int countNotFullContainers(List<Container> list){
        int amount = 0;
        for(Container c : list){
            if(c.getFreeSpace() != 0){
                amount++;
            }
        }
        return amount;
    }
}
