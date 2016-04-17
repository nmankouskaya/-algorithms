package by.bsu.algorythm.sort;

/**
 * Created by Настенька on 10/20/2015.
 */
public class Mergesort {

    public static void print(int[] a){
        System.out.println("Merge Sort:");
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static void merge(int[] a, int low, int mid, int high)
    {
        System.out.println("Sliyanie v nachale");
        for(int i=low; i<= high ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        // Variables declaration.
        int[] b = new int[high+1-low];
        int h,i,j,k;
        h=low;
        i=0;
        j=mid+1;
        // Merges the two array's into b[] until the first one is finish
        while((h<=mid)&&(j<=high))
        {
            if(a[h]<=a[j])
            {
                b[i]=a[h];
                h++;
            }
            else
            {
                b[i]=a[j];
                j++;
            }
            i++;
        }
        // Completes the array filling in it the missing values
        if(h>mid)
        {
            for(k=j;k<=high;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        else
        {
            for(k=h;k<=mid;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        // Prints into the original array
        for(k=0;k<=high-low;k++)
        {
            a[k+low]=b[k];
        }

        System.out.println("Sliyanie v konce");
        for(i=low; i<= high ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void merge_sort(int[] a, int low, int high)
    {// Recursive sort ...
        System.out.println("Delenie");
        for(int i=low; i<= high ; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        if(low<high)
        {
            int mid=(low+high)/2;
            merge_sort(a, low,mid);
            merge_sort(a, mid+1,high);
            merge(a, low,mid,high);
        }
    }
}
