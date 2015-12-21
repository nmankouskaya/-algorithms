package by.bsu.binarysearchtree.tree;

import by.bsu.binarysearchtree.node.TreeNode;

/**
 * Created by Vlad on 27.09.2015.
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void insert(TreeNode newNode, TreeNode rootTree){

        if (this.getRoot() == null) {
            setRoot(newNode);
            return;
        }
        if (rootTree == null){
            rootTree = new TreeNode(newNode.getNumber(), newNode.getLeft(), newNode.getRight());
        } else {
            if (rootTree.getNumber() < newNode.getNumber()) {
                rootTree.setCountNodeRight(rootTree.getCountNodeRight() + 1);
                insert(newNode, rootTree.getRight());
                if (rootTree.getRight() == null){
                    rootTree.setRight(newNode);
                }
            } else {
                rootTree.setCountNodeLeft(rootTree.getCountNodeLeft() + 1);
                insert(newNode, rootTree.getLeft());
                if (rootTree.getLeft() == null) {
                    rootTree.setLeft(newNode);
                }
            }
        }
    }

    public TreeNode search(int number, TreeNode root){
        if (root == null){
            return null;
        }
        if (root.getNumber() == number){
            return root;
        } else {
            if (root.getNumber() < number)
                return search(number, root.getRight());
            else
                return search(number, root.getLeft());
        }
    }

    public TreeNode searchParent(int number, TreeNode root){
        if (root == null){
            return null;
        }

        if (root.getLeft() != null)
            if (root.getLeft().getNumber() == number)
                return root;
        if (root.getRight() != null)
            if (root.getRight().getNumber() == number)
                return root;
        if (root.getNumber() < number)
            return searchParent(number, root.getRight());
        else return searchParent(number, root.getLeft());
    }

    public void delete(int number, TreeNode root){
        if (root != null) {
            if (root.getNumber() == number) {
                if (root.getRight() != null && root.getLeft() == null) {
                    //System.out.println("Delete Left sub");
                    root.setNumber(root.getRight().getNumber());
                    root.setLeft(root.getRight().getLeft());
                    root.setRight(root.getRight().getRight());
                    if(root.getRight()!=null) {
                        root.setCountNodeRight(root.getRight().getCountNodeRight());
                        root.setCountNodeLeft(root.getRight().getCountNodeLeft());
                    }
                } else if (root.getLeft() != null && root.getRight() == null) {//analogy
                    //System.out.println("Delete Right sub");
                    root.setNumber(root.getLeft().getNumber());
                    root.setRight(root.getLeft().getRight());
                    root.setLeft(root.getLeft().getLeft());
                    if(root.getLeft() != null) {
                        root.setCountNodeRight(root.getLeft().getCountNodeRight());
                        root.setCountNodeLeft(root.getLeft().getCountNodeLeft());
                    }
                } else if (root.getLeft() != null && root.getRight() != null) {
                    TreeNode tmp = root.getRight();
                    while (tmp.getLeft() != null) {
                        tmp = tmp.getLeft();
                    }
                    root.setNumber(tmp.getNumber());
                    root.setCountNodeRight(root.getCountNodeRight() - 1);
                    //System.out.println("Delete 2 sub: " + root.getNumber() + " " + root.getRight());
                    delete(tmp.getNumber(), root.getLeft());
                }else{
                    //System.out.println("Delete 0 sub");
                    TreeNode parent = searchParent(root.getNumber(), this.getRoot());//
                    if(parent!=null) {
                        if (parent.getLeft() == root) {
                            parent.setLeft(null);
                            parent.setCountNodeLeft(0);
                        }
                        if (parent.getRight() == root) {
                            parent.setRight(null);
                            parent.setCountNodeRight(0);
                        }
                    }

                    root = null;
                }
            } else if (root.getNumber() > number) {
                root.setCountNodeLeft(root.getCountNodeLeft()-1);
                delete(number, root.getLeft());
            } else {
                root.setCountNodeRight(root.getCountNodeRight()-1);
                delete(number, root.getRight());
            }
        }
    }

    public void rotationLeft(TreeNode node){
        if (node == null) return;
        if (node.getRight() != null){
            TreeNode tmp = new TreeNode(node.getNumber());//копирую элемент который переставлять
            node.setNumber(node.getRight().getNumber());
            node.getRight().setNumber(tmp.getNumber());

            tmp = node.getLeft();
            node.setLeft(node.getRight().getLeft());
            node.getRight().setLeft(tmp);

            tmp = node.getRight();
            node.setRight(node.getLeft());
            node.setLeft(tmp);

            tmp = tmp.getRight();
            node.getLeft().setRight(node.getRight());
            node.setRight(tmp);

            node.setCountNodeRight(node.getLeft().getCountNodeRight());//количество потомков справа, я правую чатсь не трогал значит не меняю
            node.getLeft().setCountNodeRight(node.getLeft().getCountNodeLeft());//у нода беру левый и сетаю справа
            node.getLeft().setCountNodeLeft(node.getCountNodeLeft());//слева
            node.setCountNodeLeft(node.getLeft().getCountNodeLeft() + node.getLeft().getCountNodeRight() + 1);//сетаю самому ноду
        }
    }

    public void rotationRightNode(TreeNode node){
        if (node == null) return;
        if (node.getLeft() != null){
            TreeNode tmp = new TreeNode(node.getNumber());
            node.setNumber(node.getLeft().getNumber());
            node.getLeft().setNumber(tmp.getNumber());

            tmp = node.getRight();
            node.setRight(node.getLeft().getRight());
            node.getLeft().setRight(tmp);

            tmp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(tmp);

            tmp = tmp.getLeft();
            node.getRight().setLeft(node.getLeft());
            node.setLeft(tmp);

            node.setCountNodeLeft(node.getRight().getCountNodeLeft());
            node.getRight().setCountNodeLeft(node.getRight().getCountNodeRight());
            node.getRight().setCountNodeRight(node.getCountNodeRight());
            node.setCountNodeRight(node.getRight().getCountNodeRight() + node.getRight().getCountNodeLeft() + 1);
        }
    }

    public TreeNode findNodeByNumberInTree(int number, TreeNode node){
        if (number == node.getCountNodeLeft()+1) return node;
        if (number <= node.getCountNodeLeft()){
            return findNodeByNumberInTree(number, node.getLeft());
        } else {
            return findNodeByNumberInTree(number-node.getCountNodeLeft()-1, node.getRight());
        }
    }

    public void insertIntoRoot(int number, TreeNode root){
        TreeNode newNode = new TreeNode(number);
        insert(newNode, getRoot());

        TreeNode parent = getRoot();
        boolean rotation;
        while (getRoot().getNumber() != number) {
            parent = searchParent(number, getRoot());
            rotation = false;
            if (parent.getLeft() != null)
                if (parent.getLeft().getNumber() == number){
                    rotationRightNode(parent);
                    rotation = true;
                }
            if (parent.getRight() != null && !rotation)
                if (parent.getRight().getNumber() == number){
                    rotationLeft(parent);
                }
        }
    }

    public void show(TreeNode node){
        if(node == null) return;
        String left = (node.getLeft() == null ? "no" : String.valueOf(node.getLeft().getNumber()));
        String right = (node.getRight() == null ? "no" : String.valueOf(node.getRight().getNumber()));
        System.out.println("Root: "+node.getNumber()+" right "+right+" left "+left);
        show(node.getLeft());
        show(node.getRight());
    }
}
