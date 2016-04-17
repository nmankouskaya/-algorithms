package by.bsu.algorythm.hash_table.manager.impl;

import by.bsu.algorythm.hash_table.manager.Manager;

import java.util.Hashtable;

/**
 * Created by Настенька on 12/15/2015.
 */
public class LinearProbirovanie implements Manager{

    private Hashtable<Integer, Integer> hashTable = new Hashtable<>();
    private static int NUMBER = 12;

    private static LinearProbirovanie instance = new LinearProbirovanie();

    public static LinearProbirovanie getInstance(){
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
            addElement(array[i], null);
        }

    }

    @Override
    public void add(int a){
        addElement(a, null);
    }

    @Override
    public void delete(int a){
        deleteElement(a, null);
    }

    @Override
    public void find(int a){
        findElement(a, null);
    }


    public void addElement(int a, Integer defaultKey ){
        if(defaultKey == null) {
            int key = identify(a);
            Integer el = hashTable.get(key);
            if(el != -1){
                key++;
                addElement(a, key);
            } else {
                hashTable.put(key, a);
            }
        } else {
            defaultKey = checkKey(defaultKey);
            Integer el = hashTable.get(defaultKey);
            if(el != -1){
                defaultKey++;
                addElement(a, defaultKey);
            } else {
                hashTable.put(defaultKey, a);
            }
        }

    }


    public void deleteElement(int a, Integer defaultKey){
        if(defaultKey == null) {
            int key = identify(a);
            Integer el = hashTable.get(key);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el == a){
                hashTable.put(key, -2);
            }  else {
                key++;
                deleteElement(a, key);
            }

        } else {
            defaultKey = checkKey(defaultKey);
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el == a){
                hashTable.put(defaultKey, -2);
            }  else {
                defaultKey++;
                deleteElement(a, defaultKey);
            }
        }

    }


    public void findElement(int a, Integer defaultKey){
        if(defaultKey == null) {
            int key = identify(a);
            Integer el = hashTable.get(key);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el == a){
                System.out.println("Key: " + key);
                return;
            }  else {
                key++;
                findElement(a, key);
            }

        } else {
            defaultKey = checkKey(defaultKey);
            Integer el = hashTable.get(defaultKey);
            if(el == -1){
                System.out.println("No such element.");
                return;
            }
            if(el == a){
                System.out.println("Key: " + defaultKey);
                return;
            }  else {
                defaultKey++;
                findElement(a, defaultKey);
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
