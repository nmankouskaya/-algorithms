package utils;

import entity.Matrix;
import entity.Node;

/**
 * Created by Настенька on 4/18/2016.
 */
public class InitNode {

    public static Node init(){
        Node node = new Node();
        //вместо бесконечности использую -1
        int[][] array = new int[][]{{-1, 5, 2, 4, 2},
                                    {2, -1, 4, 1, 4},
                                    {5, 6, -1, 4, 1},
                                    {4, 2, 4, -1, 2},
                                    {1, 4, 5, 5, -1}};
        Matrix m = new Matrix(array);
        node.setMatrix(m);
        node.setPrevious(null);
        return node;
    }
}
