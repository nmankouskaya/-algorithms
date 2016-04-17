package by.bsu.algorythm.interpol_search;

/**
 * Created by Настенька on 10/21/2015.
 */
public class Manager {

    public static int interpol_search(int[] a, int val){
        int left = 0;
        int right = a.length-1;
        int mid;
        int s=0;
        while(a[right]>= val && a[left]<= val){
            mid=left+((val-a[left])*(right-left))/(a[right]-a[left]);
            s++;
            if (a[mid]<val) {
                left = mid + 1;
            } else if (a[mid]>val) {
                right = mid - 1;
            } else {
                System.out.println("Interpol Search "+s);
                return mid;
            }
        }
        System.out.println("Interpol Search"+s);
        if (a[left]==val)
            return left;
        else
            return -1;
    }

    public static int simple_search(int[] a, int val){
        int s=0;
        for(int i=0; i<a.length; i++){
            s++;
            if(a[i]==val){
                System.out.println("Simple Search "+s);
                return i;
            }
        }
        System.out.println("Simple sort"+s);
        return -1;
    }
}
