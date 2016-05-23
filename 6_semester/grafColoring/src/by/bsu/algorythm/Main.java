package by.bsu.algorythm;

import by.bsu.algorythm.entity.Edge;
import by.bsu.algorythm.entity.Graf;
import by.bsu.algorythm.entity.Vertex;
import by.bsu.algorythm.logic.GrafColoring;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Graf graf = new Graf(5);
        /*Graf graf = new Graf();
        for(int i=0; i<5; i++){
            graf.vertexes.add(new Vertex(i));
        }
        graf.edges.add(new Edge( graf.vertexes.get(0), graf.vertexes.get(1)));
        graf.edges.add(new Edge( graf.vertexes.get(0), graf.vertexes.get(2)));
        graf.edges.add(new Edge( graf.vertexes.get(1), graf.vertexes.get(3)));
        graf.edges.add(new Edge( graf.vertexes.get(2), graf.vertexes.get(4)));
        graf.edges.add(new Edge( graf.vertexes.get(2), graf.vertexes.get(1)));
        graf.edges.add(new Edge( graf.vertexes.get(3), graf.vertexes.get(2)));
        graf.edges.add(new Edge( graf.vertexes.get(3), graf.vertexes.get(4)));
        graf.edges.add(new Edge( graf.vertexes.get(4), graf.vertexes.get(1)));*/

        System.out.println("======================= SequentialColoring =======================");
        System.out.println(graf);
        GrafColoring.sequentialColoring(graf);
        System.out.println(graf);
        System.out.println("Хроматическое число: " + graf.getChromaticNumber());

        Graf graf2 = new Graf(5);
        /*Graf graf2 = new Graf();
        for(int i=0; i<5; i++){
            graf2.vertexes.add(new Vertex(i));
        }
        graf2.edges.add(new Edge( graf2.vertexes.get(0), graf2.vertexes.get(4)));
        graf2.edges.add(new Edge( graf2.vertexes.get(0), graf2.vertexes.get(3)));
        graf2.edges.add(new Edge( graf2.vertexes.get(2), graf2.vertexes.get(3)));
        graf2.edges.add(new Edge( graf2.vertexes.get(1), graf2.vertexes.get(2)));*/
        System.out.println("======================= IndependentSetsColoring =======================");
        System.out.println(graf2);
        GrafColoring.independentSetsColoring(graf2);
        System.out.println(graf2);
        System.out.println("Хроматическое число: " + graf2.getChromaticNumber());
    }
}
