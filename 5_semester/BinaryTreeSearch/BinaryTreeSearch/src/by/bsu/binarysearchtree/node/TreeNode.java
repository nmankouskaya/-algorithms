package by.bsu.binarysearchtree.node;

/**
 * Created by Vlad on 27.09.2015.
 */
public class TreeNode {
    private int number;
    private int countNodeLeft;
    private int countNodeRight;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int number) {
        this.setNumber(number);
    }

    public TreeNode(int number, TreeNode left, TreeNode right) {
        this.setNumber(number);
        this.setCountNodeLeft(0);
        this.setCountNodeRight(0);
        this.setLeft(left);
        this.setRight(right);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountNodeLeft() {
        return countNodeLeft;
    }

    public void setCountNodeLeft(int countNodeLeft) {
        this.countNodeLeft = countNodeLeft;
    }

    public int getCountNodeRight() {
        return countNodeRight;
    }

    public void setCountNodeRight(int countNodeRight) {
        this.countNodeRight = countNodeRight;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("TreeNode: ");
        sb.append("value="+number);
        sb.append(", count_left_node=" + countNodeLeft);
        sb.append(", count_right_node=" + countNodeRight);
        if(left!=null)
            sb.append(", left=" + left.getNumber());
        else
            sb.append(", left= no");
        if(right!=null)
            sb.append(", right=" + right.getNumber());
        else
            sb.append(", right= no");
        return sb.toString();
    }
}
