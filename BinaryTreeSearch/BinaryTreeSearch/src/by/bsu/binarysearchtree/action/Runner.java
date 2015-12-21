package by.bsu.binarysearchtree.action;

import by.bsu.binarysearchtree.node.TreeNode;
import by.bsu.binarysearchtree.tree.BinaryTree;


/**
 * Created by Vlad on 27.09.2015.
 */
public class Runner {
    public static void main(String[] args){


        BinaryTree tree = new BinaryTree(null);

        TreeNode node = null;
        //вставка
        node = new TreeNode(3);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(1);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(1);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(9);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(10);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(5);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(4);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(7);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(6);
        tree.insert(node, tree.getRoot());

        node = new TreeNode(8);
        tree.insert(node, tree.getRoot());


        System.out.println("Tree");
        tree.show(tree.getRoot());
        //поиск n-ого минимального
        TreeNode findNode = tree.findNodeByNumberInTree(5, tree.getRoot());
        System.out.println("\nFind node by number: " + findNode);
        //поиск
        TreeNode nodeSearch = tree.search(1, tree.getRoot());
        System.out.println("\nNodeSearch " + nodeSearch);

        //удаление
        System.out.println("\nDelete 4 (list)");
        tree.delete(4, tree.getRoot());
        tree.show(tree.getRoot());

        System.out.println("\nDelete 5 (1 subtree)");
        tree.delete(5, tree.getRoot());
        tree.show(tree.getRoot());

        System.out.println("\nDelete 3 (2 subtree)");
        tree.delete(3, tree.getRoot());
        tree.show(tree.getRoot());
        //ротация
        tree.rotationLeft(tree.getRoot());
        System.out.println("\nTree after left rotation:");
        tree.show(tree.getRoot());
        //вставка в корень
        System.out.println("\nInsert into root.");
        tree.insertIntoRoot(24, tree.getRoot());
        tree.show(tree.getRoot());
    }
}
