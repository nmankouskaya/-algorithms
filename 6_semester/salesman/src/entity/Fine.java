package entity;

/**
 * Created by Настенька on 4/18/2016.
 */
public class Fine {

    public int i;
    public int j;
    public int value;

    public int originalI;
    public int originalJ;

    public Fine() {
    }

    public Fine(int i, int j, int originalI, int originalJ, int value) {
        this.i = i;
        this.j = j;
        this.originalI = originalI;
        this.originalJ = originalJ;
        this.value = value;
    }

    @Override
    public String toString() {
        return "i=" + i + " j=" + j + " value=" + value;
    }
}
