package by.bsy.algorythm.hash_table.project_manager.impl;

import by.bsy.algorythm.hash_table.project_manager.Manager;

import java.util.*;

/**
 * Created by Настенька on 10/7/2015.
 */
public class ModManager implements Manager {

    private static ModManager instance = new ModManager();

    private static Map< Integer, List<Integer> > hashMap = new HashMap<>();
    private static Integer NUMBER = 128;

    public static ModManager getInstance(){
        return instance;
    }

    @Override
    public void solve(Integer[] array){
        init();
        for(int i=0; i<array.length; i++){
           add(array[i]);
        }


    }

    private void init(){
        for(int i=0; i< NUMBER; i++){
            hashMap.put(i, new LinkedList<Integer>());
        }
    }

    @Override
    public void print(){
        for(Integer key : hashMap.keySet()){
            List<Integer> list = hashMap.get(key);
            System.out.print("Key: " + key + "   ");
            for(Integer ob : list){
                System.out.print(" " + ob);
            }
            System.out.println();
        }
    }

    @Override
    public void add(Integer el){
        int k = el% NUMBER;
        List<Integer> list = hashMap.get(k);
        list.add(el);
    }

    @Override
    public void delete(Integer el){
        int k = el% NUMBER;
        List<Integer> list = hashMap.get(k);
        list.remove(el);
    }

    @Override
    public Integer search(Integer el){
        int k = el % NUMBER;
        List<Integer> list = hashMap.get(k);
        int index = list.indexOf(el);
        return index;
    }
}
