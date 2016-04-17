package by.bsu.algorytm.merge_sort;

/**
 * Created by Настенька on 10/14/2015.
 */
public class Manager {
    private static void merge(int[] a, int low, int mid, int high)
    {
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
    }
    public static void merge_sort(int[] a, int low, int high)
    {// Recursive sort ...
        int mid;
        if(low<high)
        {
            mid=(low+high)/2;
            merge_sort(a, low,mid);
            merge_sort(a, mid+1,high);
            merge(a, low,mid,high);
        }
    }
}
