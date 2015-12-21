package by.bsu.algorythm.hash_table.manager.impl;

import by.bsu.algorythm.hash_table.manager.Manager;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Настенька on 12/15/2015.
 */
public class SquaredProbirovanie implements Manager {

    private Hashtable<Integer, Integer> hashTable = new Hashtable<>();
    private static int NUMBER = 12;

    private static SquaredProbirovanie instance = new SquaredProbirovanie();

    public static SquaredProbirovanie getInstance(){
        return instance;
    }

    //Договоримся, что -1 - нет числа, -2 - удалено
    private void init(){
        for(int i=0; i < NUMBER; i++){
            hashTable.put(i, -1);
        }
    }

    @Override
    public void addArray(int[] array){
        init();

        for(int i=0; i < array.length; i++){
            addElement(array[i], null, 0);
        }
    }

    @Override
    public void add(int a){
        addElement(a, null, 0);
    }

    @Override
    public void delete(int a){
        deleteElement(a, null, 0);
    }

    @Override
    public void find(int a){
        findElement(a, null, 0);
    }


    public void addElement(int a, Integer defaultKey, Integer iteration ){
        if(defaultKey == null){
            defaultKey  = identify(a);
            Integer el = hashTable.get(defaultKey);
            if(el != -1){
                iteration++;
                addElement(a, defaultKey, iteration);
            } else {
                hashTable.put(defaultKey, a);
            }
        } else {
            defaultKey+=iteration;
            Integer el = hashTable.get(defaultKey);
            if(el != -1){
                iteration++;
                addElement(a, defaultKey, iteration);
            } else {
                hashTable.put(defaultKey, a);
            }
        }
    }


    public void deleteElement(int a, Integer defaultKey, Integer iteration){
        if(defaultKey == null){
            defaultKey  = identify(a);
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el != a){
                iteration++;
                deleteElement(a, defaultKey, iteration);
            } else {
                hashTable.put(defaultKey, -2);
            }
        } else {
            defaultKey+=iteration;
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el != a){
                iteration++;
                deleteElement(a, defaultKey, iteration);
            } else {
                hashTable.put(defaultKey, -2);
            }
        }
    }


    public void findElement(int a, Integer defaultKey, Integer iteration){
        if(defaultKey == null){
            defaultKey  = identify(a);
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el != a){
                iteration++;
                findElement(a, defaultKey, iteration);
            } else {
                System.out.println("Key: "+defaultKey);

            }
        } else {
            defaultKey+=iteration;
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el != a){
                iteration++;
                findElement(a, defaultKey, iteration);
            } else {
                System.out.println("Key: " + defaultKey);
            }
        }
    }

    @Override
    public void print(){
        System.out.println("====== HashTable ======");
        for(int i=0; i < NUMBER ; i++){
            if(hashTable.get(i) == -1){
                System.out.println("Key: "+i+" -- no number ");
            } else {
                if (hashTable.get(i) == -2) {
                    System.out.println("Key: " + i + " -- deleted ");
                } else {
                    System.out.println("Key: " + i + " -- " + hashTable.get(i));
                }
            }
        }
        System.out.println("=======================");
    }

    private int identify(int a){
        return a % NUMBER;
    }

    private int checkKey(int key){
        if(key < NUMBER){
            return key;
        } else {
            return key % NUMBER;
        }
    }
}
