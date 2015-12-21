package by.bsu.algorythm.sort;

/**
 * Created by Настенька on 10/20/2015.
 */
public class Insertsort {

    public static void print(int[] a){
        System.out.println("Insert Sort:");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
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
