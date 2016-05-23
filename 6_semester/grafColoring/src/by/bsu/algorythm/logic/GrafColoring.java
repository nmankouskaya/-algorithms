package by.bsu.algorythm.logic;

import by.bsu.algorythm.entity.Edge;
import by.bsu.algorythm.entity.Graf;
import by.bsu.algorythm.entity.Vertex;

import java.util.ArrayList;
import java.util.List;


public class GrafColoring {

    public static void sequentialColoring(Graf graf){
        int color = 1;
        graf.vertexes.get(0).color = color;
        Vertex coloredVertex = graf.vertexes.get(0);
        List<Vertex> list = findNonColoringVertexes(graf.vertexes);
        boolean status;
        while(!list.isEmpty()){
            status = true;
            for(Vertex v : list){
                if( !checkAdjacency(coloredVertex, v, graf.edges) ){
                    v.color = color;
                    coloredVertex = v;
                    list = findNonColoringVertexes(list);
                    status = false;
                }
            }
            if(status){
                color++;
                list.get(0).color = color;
                coloredVertex = list.get(0);
                list = findNonColoringVertexes(list);
            }
        }
    }

    private static List<Vertex> findNonColoringVertexes(List<Vertex> vertexes){
        List<Vertex> list = new ArrayList<>();
        for(Vertex v : vertexes){
            if(v.color == 0){
                list.add(v);
            }
        }
        return list;
    }

    private static boolean checkAdjacency(Vertex v1, Vertex v2, List<Edge> edges){
        Edge currentEdge = new Edge(v1, v2);
        for(Edge edge : edges){
            if(edge.equals(currentEdge)){
                return true;
            }
        }
        for(Edge e : edges){
            if( e.v1.equals(v2) ){
                if(e.v2.color == v1.color){
                    return true;
                }
            } else if( e.v2.equals(v2) ){
                if(e.v1.color == v1.color){
                    return true;
                }
            }
        }
        return false;
    }



    /////////////////////////////////////
    public static void independentSetsColoring(Graf graf) throws CloneNotSupportedException {
        int color = 1;
        List<Vertex> grafVertexes = graf.vertexes;
        List<Vertex> newVertexes = new ArrayList<>();
        List<Edge> grafEdges = graf.edges;
        List<Vertex> independentVertexes = findNonRelatedVertexes(grafVertexes, grafEdges);
        while( !independentVertexes.isEmpty() ){
            for(Vertex v : independentVertexes){
                v.color = color;
                newVertexes.add(v);
            }
            color++;
            grafVertexes.removeAll(independentVertexes);
            independentVertexes = findNonRelatedVertexes(graf.vertexes, graf.edges);
        }
        graf.vertexes.addAll(newVertexes);
    }

    private static List<Vertex> findNonRelatedVertexes(List<Vertex> vertexes, List<Edge> edges){
        List<Vertex> list = new ArrayList<>();
        list.addAll(vertexes);
        List<Vertex> surroundVertexes;
        for(Vertex v : vertexes){
            if(list.contains(v)){
                surroundVertexes = getSurroundVertexes(v, edges);
                list.removeAll(surroundVertexes);
            }
        }

        return list;
    }

    private static List<Vertex> getSurroundVertexes(Vertex v, List<Edge> edges){
        List<Vertex> list = new ArrayList<>();
        for(Edge e : edges){
            if(e.v1.equals(v)){
                list.add(e.v2);
            } else if(e.v2.equals(v)){
                list.add(e.v1);
            }
        }
        return list;
    }
}
