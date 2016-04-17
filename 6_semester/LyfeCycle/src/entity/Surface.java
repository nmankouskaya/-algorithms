package entity;

import utils.LifeCycle;

/**
 * Created by Настенька on 4/16/2016.
 */
public class Surface implements Cloneable, Runnable{

    private volatile boolean stopThread = false;

    private volatile int evolution = 1;

    private int[][] surface;

    public Surface(int m, int n) {
        this.surface = new int[m][n];
        init();
    }

    private void init(){
        for(int i=0; i < surface.length; i++){
            for(int j=0; j < surface[i].length; j++){
                surface[i][j] = 0;
            }
        }
    }

    public int getM(){
        return surface.length;
    }

    public int getN(){
        return surface[0].length;
    }

    public int[][] getSurface(){
        return surface;
    }

    public void setSurface(int[][] surface) {
        this.surface = surface;
    }

    public void setConfiguration(Point[] points){
        for(Point p : points){
            if( validate(p) ){
                int m = p.getX()-1;
                int n = p.getY()-1;
                surface[m][n] = 1;
            }
        }
    }

    private boolean validate(Point p){
        if( p.getX() >= surface.length ||
                p.getY() >= surface[0].length )
            return false;
        return true;
    }

    public void stopThread(){
        stopThread = true;
    }

    @Override
    public void run() {
        while (!stopThread) {
            try {
                System.out.println( "Evolution " + evolution++);
                LifeCycle.start(this);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < surface.length; i++){
            for(int j=0; j < surface[0].length; j++){
                if(surface[i][j] == 0)
                    sb.append("_ ");
                else
                    sb.append("X ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Surface clone() throws CloneNotSupportedException {
        Surface sf = (Surface) super.clone();
        int m = surface.length;
        int n = surface[0].length;
        int[][] matrix = new int[m][n];
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                matrix[i][j] = surface[i][j];
            }
        }
        sf.setSurface(matrix);
        return sf;
    }
}
