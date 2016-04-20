package logic;

import entity.Matrix;

/**
 * Created by Настенька on 4/18/2016.
 */
public class MatrixReduction {

    //приведение
    //возвращае константу приведения
    public static int lead(Matrix matrix) {
        int h = 0;

        for(int i=0; i < matrix.getDim(); i++) {
            int[] column = matrix.getColumn(i);
            int min = findMin(column);
            h+=min;
            //вычитаем минимальный элемент
            column = deduct(column, min);
            matrix.setColumn(i, column);
        }

        for(int i=0; i < matrix.getDim(); i++) {
            int[] column = matrix.getLine(i);
            int min = findMin(column);
            h+=min;
            //вычитаем минимальный элемент
            column = deduct(column, min);
            matrix.setLine(i, column);
        }
        return h;
    }

    private static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < array.length; i++){
            if( ( array[i] < min ) && ( array[i] >= 0 ) ){
                min = array[i];
            }
        }
        return min;
    }

    private static int[] deduct(int[] column, int min){
        for(int i=0; i< column.length; i++){
            column[i]-=min;
        }
        return column;
    }
}
