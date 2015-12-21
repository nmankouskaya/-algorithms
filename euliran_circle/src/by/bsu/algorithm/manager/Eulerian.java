package by.bsu.algorithm.manager;

import by.bsu.algorithm.domain.Graf;
import by.bsu.algorithm.domain.Vertex;

/**
 * Created by Настенька on 12/16/2015.
 */
public class Eulerian {
    public static void Eulerian_cycle(Graf G, Vertex v){
        //
        int eyl = 1;
        int[][] matr = G.matrixOfInc(G);
        for(int i = 0; i < G.getN(); i++) {
            int k = 0;
            for (int j = 0; j < G.getEdges().length; j++) { //j < количество ребер
                if (matr[i][j] == 1) k++;
            }
            G.getVert()[i].setDeg(k);
        }
        for(int i = 0; i < G.getN(); i++){
            if(G.getVert()[i].getDeg()%2 != 0) {
                System.out.println("Граф не является эйлеровым");
                eyl = 0;
                break;
            }
        }
        if(eyl != 0){
            Vertex[] Stemp = new Vertex[G.getEdges().length + 1];
            Vertex[] Send = new Vertex[G.getEdges().length + 1];
            int p = 0; int z = 0;
            Stemp[p]=v;
            while(p>=0){
                Vertex top = Stemp[p];
                int i = top.getV()-1;
                int j=0;
                for( ; j <= G.getEdges().length; j++){
                    if(j < G.getEdges().length && matr[i][j] == 1 && G.getEdges()[j].getLabel() == 0){
                        //ищу к какому ребру принадлежит top и если ребро не помечено, то..
                        int k = 0;
                        while (matr[k][j] != 1 || k == i){ k++;}
                        G.getEdges()[j].setLabel(1);
                        p++;
                        Stemp[p] = G.getVert()[k];
                        break;
                    }
                    else
                    if (j >= G.getEdges().length){
                        Send[z] = top;
                        z++;
                        Stemp[p] = null;
                        p--;
                        break;
                    }
                }
            }
            System.out.println("Эйлеров цикл: \n");
            for(int j = 0; j < Send.length; j++)
                System.out.print(Send[j] + " ");
        }
    }
}
