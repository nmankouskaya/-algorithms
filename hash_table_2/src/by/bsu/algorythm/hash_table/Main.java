package by.bsu.algorythm.hash_table;

import by.bsu.algorythm.hash_table.manager.impl.LinearProbirovanie;
import by.bsu.algorythm.hash_table.manager.impl.SquaredProbirovanie;

/**
 * Created by Настенька on 12/15/2015.
 */
public class Main {

    public static void main(String... args){
        int[] array = {0 ,0, 0, 1, 1, 4 , 3, 5};

        System.out.print("Array: ");
        for(int i=0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("\n");

        /*LinearProbirovanie linearProbirovanie = LinearProbirovanie.getInstance();
        linearProbirovanie.addArray(array);
        linearProbirovanie.print();


        System.out.println("Add element 4:");
        //null - означает, что не определён ключ, куда вставлять
        linearProbirovanie.add(4, null);
        linearProbirovanie.print();


        System.out.println("Delete element 3:");
        //null - означает, что не определён ключ, куда вставлять
        linearProbirovanie.delete(3, null);
        linearProbirovanie.print();


        System.out.println("Find element 4:");
        //null - означает, что не определён ключ, куда вставлять
        linearProbirovanie.find(4, null);
        linearProbirovanie.print();*/

        SquaredProbirovanie squaredProbirovanie = SquaredProbirovanie.getInstance();
        squaredProbirovanie.addArray(array);
        squaredProbirovanie.print();

        System.out.println("Add element 1:");
        squaredProbirovanie.add(1);
        squaredProbirovanie.print();

        System.out.println("Delete element 3:");
        squaredProbirovanie.delete(3);
        squaredProbirovanie.print();

        System.out.println("Find element 0:");
        squaredProbirovanie.find(0);
        squaredProbirovanie.print();

    }
}
