package by.bsu.graf.manager.impl;

import by.bsu.graf.manager.Manager;

/**
 * Created by Настенька on 12/8/2015.
 */
public class MatricaIncidentnosti implements Manager {

    private static int[][] matrix;

    private static MatricaIncidentnosti instance = new MatricaIncidentnosti();

    public static MatricaIncidentnosti getInstance(){
        return instance;
    }

    // Столбцы матрицы соответствуют ребрам, строки — вершинам
    @Override
    public int[][] solve(int v, int[][] e){
        matrix = new int[v][e.length];
        //считаем, что рёбра пронумерованы в том порядке, в котором пришли
        for(int i=1; i<=v; i++){ // 1, 2, 3, 4, 5 вершины
            for(int j=0; j < e.length; j++) { // просто чтобы пробежать все рёбра
                //System.out.print("Vertex " + i + " in {" + e[j][0] + ", " + e[j][1] + "} ");
                if (e[j][0]==i || e[j][1]==i){
                    matrix[i-1][j] = 1;
                    //System.out.print(" true");
                } else {
                    matrix[i-1][j] = 0;
                    //System.out.print(" false");
                }
                //System.out.println();
            }
        }
        return matrix;
    }

    @Override
    public void print(){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
