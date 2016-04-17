package by.bsu.algorythm.sort;

import java.util.Random;

/**
 * Created by Настенька on 10/14/2015.
 */
public class Main {

    public static void main(String ... args){

        /*int[] array = {1,2 ,3 ,5,1,2};

        long t0 = System.currentTimeMillis();
        Quicksort.quicksort(array, 0, array.length - 1);
        long t1 = System.currentTimeMillis();
        System.out.println("Time: " + (t1-t0));
        Quicksort.print(array);*/

        int[] array = new int[]{1,2 ,3 ,5,1,2};

        //t0 = System.currentTimeMillis();
        Mergesort.merge_sort(array, 0, array.length - 1);
        //t1 = System.currentTimeMillis();
        //System.out.println("Time: " + (t1-t0));
        Mergesort.print(array);

        /*array = new int[]{1,2 ,3 ,5,1,2};

        t0 = System.currentTimeMillis();
        Insertsort.insert_sort(array);
        t1 = System.currentTimeMillis();
        System.out.println("Time: " + (t1 - t0));
        Insertsort.print(array);*/

        /*Gibrid.testTime();
        int[] a = new int[20_000];
        Random rand = new Random();
        for(int i=0; i<a.length; i++){
            a[i]=rand.nextInt(1000);
        }
        int[] b = a.clone();
        int[] c = a.clone();

        long t0 = System.currentTimeMillis();
        Gibrid.gibrid_sort(a);
        long t1 = System.currentTimeMillis();
        System.out.print("Time for "+a.length+" elements Gibrid Sort: " + (t1-t0));

        t0 = System.currentTimeMillis();
        Quicksort.quicksort(b, 0 , b.length-1);
        t1 = System.currentTimeMillis();
        System.out.print("   Time for "+b.length+" elements Quick Sort: " + (t1-t0));

        t0 = System.currentTimeMillis();
        Insertsort.insert_sort(c);
        t1 = System.currentTimeMillis();
        System.out.print("   Time for "+c.length+" elements Insert Sort: " + (t1-t0));*/
    }
}
