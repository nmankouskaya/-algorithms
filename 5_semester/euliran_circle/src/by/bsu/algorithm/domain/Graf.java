package by.bsu.algorithm.domain;

/**
 * Created by Настенька on 12/16/2015.
 */
public class Graf {
    int n;
    Edge[]edges;
    Vertex []vert;

    public Graf(int n, Edge[] edges) {
        this.n = n;
        this.edges = edges;
    }

    public Vertex[] getVert() {
        return vert;
    }

    public void setVert(Vertex[] vert) {
        this.vert = vert;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    public void listofAdj(Graf G){
        for(int i = 1; i <= G.getN(); i++){
            System.out.print(i + " : ");
            for(int j=0; j < G.getEdges().length; j++) {
                if (i == G.getEdges()[j].a.v)
                    System.out.print(G.getEdges()[j].b.v + ", ");
                if (i == G.getEdges()[j].b.v)
                    System.out.print(G.getEdges()[j].a.v + ", ");
            }
            System.out.print("\n");
        }
    }

    public int[][] matrixOfAdi(Graf G){
        int[][]matrix = new int[G.getN()][G.getN()];
        for(int i = 1; i <= G.getN(); i++){
            for(int j=1; j <= G.getN(); j++) {
                Edge e = new Edge(new Vertex(i), new Vertex(j));
                for(int k=0; k < G.getEdges().length; k++) {
                    if (G.getEdges()[k].equals(e)) {
                        matrix[i - 1][j - 1] = 1;
                        break;
                    }
                    else {
                        matrix[i - 1][j-1] = 0;
                        continue;
                    }
                }
            }
        }
        return matrix;
    }

    public int[][] matrixOfInc(Graf G){
        int[][]matrix = new int[G.getN()][ G.getEdges().length];
        for(int i=0; i < G.getN(); i++){
            for(int j = 0; j < G.getEdges().length; j++){
                if (G.getEdges()[j].a.v == i+1 || G.getEdges()[j].b.v == i+1)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
