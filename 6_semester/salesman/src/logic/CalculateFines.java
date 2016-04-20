package logic;

import entity.Fine;
import entity.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 4/18/2016.
 */
public class CalculateFines {

    public static List<Fine> calculate(Matrix matrix){

        int[][] matrixArray = matrix.getMatrix();
        int n = matrix.getDim();
        List<Fine> fineList = new ArrayList<>();
        Fine fine;
        int a, b;
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){

                if( matrixArray[i][j] == 0 ){
                    a = findMin(matrix.getLine(i), j);
                    b = findMin(matrix.getColumn(j), i);
                    fine = new Fine(matrix.getLineNumber(i), matrix.getColumnNumber(j), i, j, a+b);
                    fineList.add(fine);

                }
            }
        }
        return fineList;
    }

    private static int findMin(int[] array, int k){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < array.length; i++){
            if( ( i != k ) && ( array[i] < min ) && ( array[i] >= 0 ) ){
                min = array[i];
            }
        }
        return min;
    }
}
