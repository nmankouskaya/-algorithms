package by.bsy.algorythm.hash_table.project_manager.impl;

import by.bsy.algorythm.hash_table.project_manager.Manager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Настенька on 12/8/2015.
 */
public class OpenAdressingManager implements Manager {

    private static OpenAdressingManager instance = new OpenAdressingManager();

    private static Map< Integer, List<Integer> > hashMap = new HashMap<>();
    private static Integer number = 8;

    public static OpenAdressingManager getInstance(){
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
        for(int i=0; i<number; i++){
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
        int k = el%number;
        List<Integer> list = hashMap.get(k);
        list.add(el);
    }

    @Override
    public void delete(Integer el){
        int k = el%number;
        List<Integer> list = hashMap.get(k);
        list.remove(el);
    }

    @Override
    public Integer search(Integer el){
        int k = el % number;
        List<Integer> list = hashMap.get(k);
        int index = list.indexOf(el);
        return index;
    }

}
