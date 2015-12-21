package by.bsu.graf.manager.impl;

import by.bsu.graf.manager.Manager;

/**
 * Created by Настенька on 12/8/2015.
 */
public class MatricaSmezhnosti implements Manager {

    private static int[][] matrix;

    private static MatricaSmezhnosti instance = new MatricaSmezhnosti();

    public static MatricaSmezhnosti getInstance(){
        return instance;
    }

    // Матрица смежности графа G с конечным числом вершин n (пронумерованных числами от 1 до n) — это
    // квадратная матрица A размера n, в которой значение элемента a_ij равно числу рёбер из i-й вершины графа в j-ю вершину.

    @Override
    public  int[][] solve(int v, int[][] e){
        matrix = new int[v][v];

        for(int i=1; i<=v; i++){ // 1, 2, 3, 4, 5 вершины
            for(int j=1; j<=v; j++){
                for(int k=0; k < e.length; k++) { // просто чтобы пробежать все рёбра
                    //System.out.print("Vertex " + i + " and " + j + " in {" + e[k][0] + ", " + e[k][1] + "} ");
                    if ( (e[k][0]==i && e[k][1]==j) || (e[k][0]==j && e[k][1]==i) ){
                        matrix[i-1][j-1] = 1;
                        //System.out.print(" true\n");
                        //print();
                    } else {
                        //System.out.print(" false\n");
                        //print();
                    }
                    //System.out.println();
                }
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
