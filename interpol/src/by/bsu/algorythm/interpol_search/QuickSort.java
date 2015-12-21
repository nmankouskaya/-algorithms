package by.bsu.algorythm.interpol_search;

/**
 * Created by Настенька on 10/21/2015.
 */
public class QuickSort {
    public static void print(int[] a){
        System.out.println("Quick Sort:");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void quicksort(int[] a, int first, int last) {
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
    }
}
