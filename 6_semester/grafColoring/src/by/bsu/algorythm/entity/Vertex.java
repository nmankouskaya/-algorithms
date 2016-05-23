package by.bsu.algorythm.entity;


public class Vertex implements Cloneable{
    public int index;
    public int color;

    public Vertex(int index) {
        this.index = index;
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
        Vertex o = (Vertex) obj;
        if(o.color != this.color){
            return false;
        }
        if(o.index != this.index){
            return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return  "{i=" + index +
                ", color=" + color +
                '}';
    }

    @Override
    public Vertex clone() throws CloneNotSupportedException {
        return (Vertex)super.clone();
    }
}
