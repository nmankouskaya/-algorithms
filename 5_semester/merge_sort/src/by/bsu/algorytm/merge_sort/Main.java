package by.bsu.algorytm.merge_sort;

/**
 * Created by Настенька on 10/14/2015.
 */
public class Main {

    public static void main(String ... args){
        int[] array = {5,-9,0,-12};
        Manager.merge_sort(array,0,array.length-1);
        for(int i=0;i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
