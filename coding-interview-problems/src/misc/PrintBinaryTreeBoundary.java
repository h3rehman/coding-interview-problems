package misc;

import algos.BinarySearchTree;

import static commons.TreeUtils.createBinarySearchTree;

/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 *  The boundary includes
 *
 *  1. left boundary (nodes on left excluding leaf nodes)
 *  2. leaves (consist of only the leaf nodes)
 *  3. right boundary (nodes on right excluding leaf nodes)
 */

public class PrintBinaryTreeBoundary extends BinarySearchTree {

    static void printBinaryTreeBoundary(Node root){
        if (root != null){
            printLeftTree(root);
            printRightTree(root.rightChild);
        }
    }

    static void printLeftTree(Node node){
        if (node != null){
            System.out.print(node.key + " ");
            printLeftTree(node.leftChild);
            printLeafNodes(node.rightChild);
        }
    }

    static void printLeafNodes(Node node){
        if (node != null && node.leftChild == null && node.rightChild == null){
            System.out.print(node.key + " ");
            printLeafNodes(node.leftChild);
            printLeafNodes(node.rightChild);
        }
    }

    static void printRightTree(Node node){
        if (node != null){
            printLeafNodes(node.leftChild);
            printRightTree(node.rightChild);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        /**
         * Tree:
         *              55
         *             /  \
         *           45   60
         *          / \     \
         *        40  50    65
         *       /         /  \
         *     30        63   70
         *    /                 \
         *  20                  75
         *
         */
        createBinarySearchTree();
        printBinaryTreeBoundary(root);
    }

}
