package entity;

/**
 * Created by Настенька on 4/18/2016.
 */

/**
 * Используется для сохранения связи между вычеркнутой строкой и столбцом
 */
public class Link {
    public int from;
    public int to;

    @Override
    public String toString(){
        return from + "->" + to;
    }

}
