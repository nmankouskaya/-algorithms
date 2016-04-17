package by.bsu.algorythm.interpol_search;

import java.util.Random;

/**
 * Created by Настенька on 10/21/2015.
 */
public class Main {
    public static void main(String ... args){

        int[] a = new int[1_000_000];
        Random rand = new Random();
        for(int i=0; i<a.length; i++){
            a[i]=rand.nextInt(10_000);
        }
        QuickSort.quicksort(a, 0, a.length-1);

        int index;
        long t0 = System.currentTimeMillis();
        index = Manager.interpol_search(a, 59);
        long t1 = System.currentTimeMillis();
        if(index!=-1){
            System.out.println("Find element with Interpol Search. Index="+index+" element="+a[index]);
            System.out.println("Time: "+(t1-t0));
        } else {
            System.out.println("Can not find element.");
        }

        t0 = System.currentTimeMillis();
        index = Manager.simple_search(a, 59);
        t1 = System.currentTimeMillis();
        if(index!=-1){
            System.out.println("Find element with Simple Search. Index="+index+" element="+a[index]);
            System.out.println("Time: "+(t1-t0));
        } else {
            System.out.println("Can not find element.");
        }
    }
}
