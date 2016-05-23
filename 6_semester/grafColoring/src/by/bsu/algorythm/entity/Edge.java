package by.bsu.algorythm.entity;


public class Edge {
    public Vertex v1;
    public Vertex v2;

    public Edge(Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        Edge o = (Edge) obj;
        if( o.v1.equals(this.v1) ){
            if( o.v2.equals(this.v2) ){
                return true;
            }
        } else if( o.v1.equals(this.v2) ){
            if( o.v2.equals(this.v1) ){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\n{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                '}';
    }
}
