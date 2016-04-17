package by.bsu.algorithm.domain;

/**
 * Created by Настенька on 12/16/2015.
 */
public class Edge {
    Vertex a;
    Vertex b;
    int weight;
    int label;

    public Edge(Vertex a, Vertex b) {
        this.a = a;
        this.b = b;
        this.label = 0;
    }

    public Vertex getA() {
        return a;
    }

    public void setA(Vertex a) {
        this.a = a;
    }

    public Vertex getB() {
        return b;
    }

    public void setB(Vertex b) {
        this.b = b;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;

        Edge edge = (Edge) o;

        if (a.v != edge.a.getV() && a.v != edge.b.v) return false;
        if (b.v != edge.b.v && b.v != edge.a.v) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.getV();
        result = 31 * result + b.getV();
        return result;
    }

    @Override
    public String toString() {
        return " "+a.v+"-"+b.v+" ";
    }
}
