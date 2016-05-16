package by.bsu.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Настенька on 4/26/2016.
 */
public class Container {
    private List<Package> packageList;
    private double freeSpace;

    public Container() {
        freeSpace = 1;
        packageList = new ArrayList<>();
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }

    public double getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(double freeSpace) {
        this.freeSpace = freeSpace;
    }

    public void addPackage(Package p){
        packageList.add(p);
        freeSpace-=p.getWeight();
    }

    @Override
    public String toString() {
        return "Container{\n" + packageList +
                ", \nfreeSpace=" + freeSpace +
                '}';
    }
}
