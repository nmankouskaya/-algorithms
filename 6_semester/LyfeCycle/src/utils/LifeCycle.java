package utils;

import entity.Surface;

/**
 * Created by Настенька on 4/16/2016.
 */
public class LifeCycle {

    public static void start(Surface sf) throws CloneNotSupportedException {
        int m = sf.getM();
        int n = sf.getN();
        int[][] surface = sf.getSurface();

        int[][] newGeneration = sf.clone().getSurface();

        for(int i=0; i < m; i++){
            for(int j=0; j< n; j++){
                int liveNeighbours = checkNeighbours(surface, i, j);
                evolve(newGeneration, i, j, liveNeighbours);
            }
        }
        sf.setSurface(newGeneration);
        System.out.println(sf);
    }

    private static int checkNeighbours(int[][] surface, int m, int n){
        int liveNeighbours = 0;
        for(int i = m-1; i <= m+1; i++){
            if( i>=0 && i < surface.length ){
                for(int j = n-1; j <= n+1; j++){
                    if( ( j>=0 && j < surface[0].length ) && !( j==n && i==m ) ){
                        if( surface[i][j] == 1 ){
                            liveNeighbours++;
                        }
                    }
                }
            }
        }
        return liveNeighbours;
    }

    private static void evolve(int[][] surface, int m, int n, int liveNeighbours){
        if( surface[m][n] == 0 ){
            if( liveNeighbours == 3 ) {
                giveBirth(surface, m, n);
            }
        } else if( liveNeighbours > 3 || liveNeighbours < 2 ){
            die(surface, m, n);
        } else {
            survive(surface, m, n);
        }
    }

    private static void giveBirth(int[][] sf, int m, int n){
        sf[m][n] = 1;
    }

    private static void die(int[][] sf, int m, int n){
        sf[m][n] = 0;
    }

    private static void survive(int[][] sf, int m, int n){
        sf[m][n] = 1;
    }
}
