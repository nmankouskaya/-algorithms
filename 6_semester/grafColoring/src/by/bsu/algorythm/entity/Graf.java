package by.bsu.algorythm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Graf implements Cloneable {
    public List<Vertex> vertexes;
    public List<Edge> edges;

    public Graf() {
        this.vertexes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public Graf(int n){
        initVertexes(n);
        initEdges(n);
    }

    private void initVertexes(int n){
        vertexes = new ArrayList<>();
        for(int i=0; i< n; i++){
            vertexes.add(new Vertex(i));
        }
    }

    private void initEdges(int n){
        edges = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i < n ; i++){
            //для каждой вершины определим количество соседей
            int amount = random.nextInt(n);
            for(int j=0; j < amount ; j++){
                //выберем соседей по индексу
                int index = random.nextInt(n);
                Edge edge = new Edge(vertexes.get(i), vertexes.get(index));
                if(i != index && !edges.contains(edge)) {
                    edges.add(edge);
                }
            }
        }
    }

    public int getChromaticNumber(){
        int chromNum = 0;
        for( Vertex v : vertexes ){
            if(v.color > chromNum){
                chromNum = v.color;
            }
        }
        return chromNum;
    }

    @Override
    public String toString() {
        return "Graf{\n" +
                "vertexes=" + vertexes +
                ",\n edges=" + edges +
                '}';
    }

}
