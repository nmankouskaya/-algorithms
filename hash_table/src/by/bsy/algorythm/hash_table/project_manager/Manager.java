package by.bsy.algorythm.hash_table.project_manager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Настенька on 12/8/2015.
 */
public interface Manager {

    void solve(Integer[] array);

    void print();

    void add(Integer el);

    void delete(Integer el);

    Integer search(Integer el);
}
