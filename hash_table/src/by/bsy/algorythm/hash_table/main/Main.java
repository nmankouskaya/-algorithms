package by.bsy.algorythm.hash_table.main;

import by.bsy.algorythm.hash_table.project_manager.impl.KnutManager;
import by.bsy.algorythm.hash_table.project_manager.impl.ModManager;

import java.util.Random;

/**
 * Created by Настенька on 10/7/2015.
 */
public class Main {
    public static void main(String ... args){

        Integer[] a = new Integer[1_000];
        Random rand = new Random();
        for(int i=0; i<a.length; i++){
            a[i]=rand.nextInt(1000);
        }

        ModManager.getInstance().solve(a);
        ModManager.getInstance().print();

        System.out.println();

        //вставка элемента
        System.out.println("\nAdd element:");
        Integer el = 6745; //остаток от деления на 128 = 89
        //long t0 = System.currentTimeMillis();
        ModManager.getInstance().add(el);
        //long t1 = System.currentTimeMillis();
        ModManager.getInstance().print();
        //System.out.println("Time = "+(t1-t0)+"\n");

        //поиск элемента
        System.out.println("\nSearch element "+ el +": ");
        //t0 = System.currentTimeMillis();
        int index = ModManager.getInstance().search(el);
        //t1 = System.currentTimeMillis();
        if(index != -1) {
            System.out.println("Index of " + el + " = " + index);
        } else {
            System.out.println("No such element.");
        }
        //System.out.println("Time = " + (t1 - t0) + "\n");

        //удаление элемента
        System.out.println("\nDelete element "+el+": ");
        //t0 = System.currentTimeMillis();
        ModManager.getInstance().delete(el);
        //t1 = System.currentTimeMillis();
        ModManager.getInstance().print();
        //System.out.println("Time = " + (t1 - t0) + "\n");


        //KNUT
        System.out.println("=========================\nKNUT\n=========================");
        KnutManager.getInstance().solve(a);
        KnutManager.getInstance().print();

        System.out.println();

        //вставка элемента
        System.out.println("\nAdd element:");
        Integer el2 = 44;
        KnutManager.getInstance().add(el2);
        KnutManager.getInstance().print();


        //поиск элемента
        System.out.println("\nSearch element "+ el +": ");
        index = KnutManager.getInstance().search(el);
        if(index != -1) {
            System.out.println("Index of " + el + " = " + index);
        } else {
            System.out.println("No such element.");
        }

        //удаление элемента
        System.out.println("\nDelete element "+el+": ");
        KnutManager.getInstance().delete(el);
        KnutManager.getInstance().print();


    }
}
