package by.bsu.algorythm.sort;

import java.util.Random;

/**
 * Created by Настенька on 10/21/2015.
 */
public class Gibrid {
    public static void testTime(){
        int[] a;
        int[] b;
        Random rand = new Random();
        for(int ammount=100; ammount<20000; ammount+=100){
            a=new int[ammount];
            for(int i=0; i<ammount; i++){
                a[i]=rand.nextInt(1000);
            }
            b=a.clone();
            testQuicksort(a, ammount);
            testInsertsort(b, ammount);
        }
    }

    public static void testQuicksort(int[] a, int ammount){
        long t0 = System.currentTimeMillis();
        Quicksort.quicksort(a, 0, a.length - 1);
        long t1 = System.currentTimeMillis();
        System.out.print("Time for " + ammount + " elements Quick Sort: " + (t1-t0));
    }

    public static void testInsertsort(int[] a, int ammount){
        long t0 = System.currentTimeMillis();
        Insertsort.insert_sort(a);
        long t1 = System.currentTimeMillis();
        System.out.println("   and for Insert Sort: " + (t1 - t0));
    }

    public static void gibrid_sort(int[] a){
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(int[] a, int first, int last) {
        if((last-first)>3000){
            int i = first;
            int j = last;
            int x = a[(first + last)/2];
        /*int m = new Random().nextInt(a.length - 1);
        int x = a[m];
        System.out.println("Random int: "+m);*/
            //int x = a[last];
            //int x = a[first];
            do {
                while (a[i] < x) i++;
                while (a[j] > x) j--;

                if(i <= j) {
                    if (i < j)
                    {
                        int tmp = a[i];
                        a[i]=a[j];
                        a[j]=tmp;
                    }
                    i++;
                    j--;
                }
            } while (i <= j);
            if (i < last)
                quicksort(a, i, last);
            if (first < j)
                quicksort(a, first,j);
        } else {
            insert_sort(a);
        }
    }

    public static void insert_sort(int[] a){
        int n=a.length;
        int j, value;
        for(int i=1; i<n; i++){
            value=a[i];
            for(j=i-1; j>=0 && a[j]>value; j--){
                a[j+1]=a[j];
            }
            a[j+1]=value;
        }
    }
}
