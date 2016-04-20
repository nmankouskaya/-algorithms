package entity;

/**
 * Created by Настенька on 4/18/2016.
 */
public class Node {

    private Matrix matrix;
    private Matrix matrixAfterReduction;
    private int record;
    private Node previous;
    private Node left;
    private Node right;

    public Node() {
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        if(this.record == 0)
            this.record = record;
    }

    public Matrix getMatrixAfterReduction() {
        return matrixAfterReduction;
    }

    public void setMatrixAfterReduction(Matrix matrixAfterReduction) {
        this.matrixAfterReduction = matrixAfterReduction;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Matrix: " + matrix.toString());
        sb.append("After reduction: " + ( ( matrixAfterReduction != null ) ? matrixAfterReduction.toString() : null) );
        sb.append("Constant = " + record);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (record != node.record) return false;
        if (!matrix.equals(node.matrix)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = matrix.hashCode();
        result = 31 * result + matrixAfterReduction.hashCode();
        result = 31 * result + record;
        result = 31 * result + previous.hashCode();
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        return result;
    }
}
