package by.bsu.graf.manager.impl;

import by.bsu.graf.manager.Manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Настенька on 12/8/2015.
 */
public class SpisokSmezhnosti {

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    private static SpisokSmezhnosti instance = new SpisokSmezhnosti();

    public static SpisokSmezhnosti getInstance(){
        return instance;
    }


    public Map<Integer, List<Integer>> solve(int v, int[][] e){
        init(v);
        for(int i=1; i<=v; i++) {
            for (int k = 0; k < e.length; k++) { // просто чтобы пробежать все рёбра
                //System.out.print("Vertex " + i + " and " + j + " in {" + e[k][0] + ", " + e[k][1] + "} ");
                if (e[k][0] == i) {
                    List<Integer> list = map.get(i);
                    list.add(e[k][1]);
                    //System.out.print(" true\n");
                    //print();
                }
                if(e[k][1] == i){
                    List<Integer> list = map.get(i);
                    list.add(e[k][0]);
                }
                //System.out.println();
            }
        }
        return  map;
    }

    private void init(int v){
        for(int i=1; i<=v; i++){
            map.put(i, new LinkedList<>());
        }
    }


    public void print(){
        for(int k : map.keySet()){
            System.out.print("Vertex: "+k+" -> ");
            List<Integer> list = map.get(k);
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
