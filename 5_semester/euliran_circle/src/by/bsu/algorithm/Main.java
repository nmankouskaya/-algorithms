package by.bsu.algorithm;

import by.bsu.algorithm.domain.Edge;
import by.bsu.algorithm.domain.Graf;
import by.bsu.algorithm.domain.Vertex;
import by.bsu.algorithm.manager.Eulerian;

/**
 * Created by Настенька on 12/16/2015.
 */
public class Main {
    public static void main(String array[]){

        int n = 6;
        int m = 9;
        Vertex[] vert = new Vertex[n];
        for(int i = 1; i <= n; i++ ){
            vert[i-1] = new Vertex(i);
        }
        Edge[]edges = new Edge[m];

        edges[0] = new Edge(vert[0], vert[1]);
        edges[1] = new Edge(vert[0], vert[2]);
        edges[2] = new Edge(vert[0], vert[3]);
        edges[3] = new Edge(vert[0], vert[5]);
        edges[4] = new Edge(vert[1], vert[2]);
        edges[5] = new Edge(vert[1], vert[4]);
        edges[6] = new Edge(vert[1], vert[5]);
        edges[7] = new Edge(vert[2], vert[4]);
        edges[8] = new Edge(vert[2], vert[3]);

        for(int i = 0; i < m; i++)
            edges[i].setWeight(i+1);

        Graf G = new Graf(n,edges);
        G.setVert(vert);

        Eulerian.Eulerian_cycle(G, G.getVert()[0]);

    }
}
