package by.bsu.graf;

import by.bsu.graf.manager.impl.MatricaIncidentnosti;
import by.bsu.graf.manager.impl.MatricaSmezhnosti;
import by.bsu.graf.manager.impl.SpisokSmezhnosti;

/**
 * Created by Ќастенька on 12/8/2015.
 */
public class Main {

    public static void main(String... args){
        int v = 5;
        // зададим ребра с помощью списка {{ v1, v2}, ... } - что означает, что ребро между v1 и v2 есть
        // 1 - есть ребро, 0 - нет ребра
        int[][] e = {{1, 2}, {2, 5}, {1, 3},  {3,4}};

        System.out.println("MatricaIncidentnosti");
        MatricaIncidentnosti.getInstance().solve(v, e);
        MatricaIncidentnosti.getInstance().print();

        System.out.println("\nMatricaSmezhnosti");
        MatricaSmezhnosti.getInstance().solve(v, e);
        MatricaSmezhnosti.getInstance().print();

        System.out.println("\nSpisokSmezhnosti");
        SpisokSmezhnosti.getInstance().solve(v, e);
        SpisokSmezhnosti.getInstance().print();
    }
}
