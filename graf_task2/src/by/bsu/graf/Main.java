package by.bsu.graf;

import by.bsu.graf.manager.BreadthFirstSearch;
import by.bsu.graf.manager.TwoPartGraf;
import by.bsu.graf.manager.utils.MatricaSmezhnosti;

import java.util.Map;

/**
 * Created by Ќастенька on 12/9/2015.
 */
public class Main {

    public static void main(String... args){
        int v = 5;
        // зададим ребра с помощью списка {{ v1, v2}, ... } - что означает, что ребро между v1 и v2 есть
        // 1 - есть ребро, 0 - нет ребра
        int[][] e = {{1, 2}, {2, 5}, {1,3}, {3,4}};

        System.out.println("MatricaSmezhnosti");
        int[][] matrix = MatricaSmezhnosti.getInstance().solve(v, e);

        int vertex = 3;
        MatricaSmezhnosti.getInstance().print();
        System.out.println("and vertex " + vertex);
        BreadthFirstSearch.getInstance().solve(matrix, vertex);
        BreadthFirstSearch.getInstance().print();

        //BreadthFirstSearch.getInstance().connected();

        //TwoPartGraf.getInstance().solve(matrix, vertex);
    }
}
