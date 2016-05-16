package by.bsu.entity;

/**
 * Created by Настенька on 4/26/2016.
 */
public class Package {
    private int number;
    private double weight;

    public Package(int number, double weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Package{" +
                "№" + number +
                ", w=" + weight +
                "}\n";
    }
}
