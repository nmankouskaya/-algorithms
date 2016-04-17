package by.bsu.graf.manager;

import by.bsu.graf.domain.Parametr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Настенька on 12/9/2015.
 */
public class DepthFirstSearch {

    public static Map<Integer, Map<Parametr, Integer>> map = new HashMap<>();
    public static LinkedList<Integer> list = new LinkedList<>();
    private static int time;

    private static DepthFirstSearch instance = new DepthFirstSearch();

    public static DepthFirstSearch getInstance(){
        return instance;
    }

    public void solve(int[][] matrix){
        init(matrix);

        for(int i=1; i<=matrix.length; i++){
            int color = map.get(i).get(Parametr.COLOR);
            if(color == -1){
                visit(i, matrix);
            }
        }
    }

    private void init(int[][] matrix){
        time=0;
        for(int i=1; i<=matrix.length; i++){
            Map<Parametr, Integer> parametrMap = new HashMap<>();
            parametrMap.put(Parametr.TIME_BEGIN, 0);
            parametrMap.put(Parametr.TIME_END, 0);
            parametrMap.put(Parametr.COLOR, -1);
            map.put(i, parametrMap);
        }

        //print();
    }

    private void visit(int v, int[][] matrix){
        map.get(v).put(Parametr.COLOR, 0);
        time++;
        map.get(v).put(Parametr.TIME_BEGIN, time);
        List<Integer> surrounding = getSurrounding(matrix, v);
        System.out.println("surrounding for "+v+": "+surrounding);
        for(Integer i : surrounding){
            int color = map.get(i).get(Parametr.COLOR);
            if(color == -1){
                visit(i, matrix);
            }
        }
        map.get(v).put(Parametr.COLOR, 1);
        time++;
        map.get(v).put(Parametr.TIME_END, time);

    };

    private List<Integer> getSurrounding(int[][] matrix , Integer tmp){
        List<Integer> surrounding = new LinkedList<>();
        int[] array = matrix[tmp-1];
        for(int i=0; i<array.length; i++){
            if(array[i]==1){
                surrounding.add(i+1);
            }
        }
        return surrounding;
    }

    public void print(){
        for(int k : map.keySet()){
            System.out.print("Vertex: "+k+" -> ");
            Map<Parametr, Integer> mapParametr = map.get(k);
            System.out.print("color: "+mapParametr.get(Parametr.COLOR)+" , time_begin: "+mapParametr.get(Parametr.TIME_BEGIN)+" , time_end: "+mapParametr.get(Parametr.TIME_END));
            System.out.println();
        }
    }
}
