package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Настенька on 4/18/2016.
 */
public class Matrix implements Cloneable {

    private int[][] matrix;
    private Link link;
    private List<Integer> columnNumber;
    private List<Integer> lineNumber;

    public Matrix(int n) {
        matrix = new int[n][n];
        link = new Link();
        columnNumber = new ArrayList<>();
        lineNumber = new ArrayList<>();
        for(int i=1; i <= n; i++){
            columnNumber.add(i);
            lineNumber.add(i);
        }
        init();
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
        link = new Link();
        int n = matrix.length;
        columnNumber = new ArrayList<>();
        lineNumber = new ArrayList<>();
        for(int i=1; i <= n; i++){
            columnNumber.add(i);
            lineNumber.add(i);
        }
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getDim(){
        return matrix.length;
    }

    public void setElement(int i, int j, int value){
        if( (i >= 0 && i <= matrix.length-1) && (j >= 0 && j <= matrix.length-1) ) {
            matrix[i][j] = value;
        }
    }

    public double getElement(int i, int j){
        return matrix[i][j];
    }

    public int[] getLine(int i){
        return matrix[i];
    }

    public int[] getColumn(int k){
        int[] column = new int[matrix.length];
        for(int i=0; i < this.matrix.length; i++){
            column[i] = matrix[i][k];
        }
        return column;
    }

    public void setColumn(int k, int[] array){
        for(int i=0; i < matrix.length; i++){
            matrix[i][k] = array[i];
        }
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setLink(int i, int j) {
        this.link.from = i;
        this.link.to = j;
    }

    public void setLine(int k, int[] array){
        for(int i=0; i < matrix.length; i++){
            matrix[k][i] = array[i];
        }
    }

    private void init(){
        for(int i=0; i < this.matrix.length; i++){
            for(int j=0; j < this.matrix[0].length; j++){
                    matrix[i][j] = 0;
            }
        }
    }

    public void removeLine(int k){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] matrixArray = new int[n-1][m];
        for(int i=0; i < k; i++ ){
            for(int j=0; j < m; j++){
                matrixArray[i][j] = matrix[i][j];
            }
        }
        for(int i=k+1; i < n; i++ ){
            for(int j=0; j < m; j++){
                matrixArray[i-1][j] = matrix[i][j];
            }
        }
        matrix = matrixArray;
    }

    public void removeColumn(int k){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] matrixArray = new int[n][m-1];
        for(int i=0; i < n; i++ ){
            for(int j=0; j < k; j++){
                matrixArray[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i < n; i++ ){
            for(int j=k+1; j < m; j++){
                matrixArray[i][j-1] = matrix[i][j];
            }
        }
        matrix = matrixArray;
    }

    /**
     * На вход приходит индекс из матрицы, а возвращет ее номер в исходной матрицы
     * @param i
     * @return
     */
    public int getColumnNumber(int i) {
        return columnNumber.get(i);
    }

    public int getLineNumber(int i) {
        return lineNumber.get(i);
    }

    public void removeColumnNumber(int i) {
        columnNumber.remove(i);
    }

    public void removeLineNumber(int i) {
        lineNumber.remove(i);
    }

    public void setColumnNumber(List<Integer> columnNumber) {
        this.columnNumber = columnNumber;
    }

    public void setLineNumber(List<Integer> lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix obj = (Matrix) o;

        if( this.matrix.length != obj.matrix.length )
            return false;

        if( this.matrix[0].length != obj.matrix[0].length )
            return false;

        for(int i=0; i < this.matrix.length; i++){
            for(int j=0; j < this.matrix[0].length; j++){
                if( this.matrix[i][j] != obj.matrix[i][j] )
                    return false;
            }
        }

        return true;
    }



    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < this.matrix.length; i++){
            for(int j=0; j < this.matrix[0].length; j++){
                sb.append(matrix[i][j] + " " );
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Matrix clone() throws CloneNotSupportedException {
        Matrix m = (Matrix)super.clone();
        int n = getDim();
        int[][] array = new int[n][n];
        for(int i=0; i < n; i++)
            for(int j=0; j < n; j++)
                array[i][j] =  this.matrix[i][j];
        m.setMatrix(array);
        m.setLink(new Link());
        List<Integer> columnNumber = new ArrayList<>();
        List<Integer> lineNumber = new ArrayList<>();
        for(Integer i : this.columnNumber){
            columnNumber.add(i);
        }
        for(Integer i : this.lineNumber){
            lineNumber.add(i);
        }
        m.setLineNumber(lineNumber);
        m.setColumnNumber(columnNumber);
        return m;
    }
}
