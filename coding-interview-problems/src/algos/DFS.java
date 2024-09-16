package algos;

import static algos.BinarySearchTree.root;
import static commons.TreeUtils.createBinarySearchTree;

public class DFS {

    static void postOrderTraversal(BinarySearchTree.Node node){
        if (node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.key + " ");
    }

    static void preOrderTraversal(BinarySearchTree.Node node){
        if (node == null){
            return;
        }
        System.out.print(node.key + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    static void inOrderTraversal(BinarySearchTree.Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.key + " ");
        inOrderTraversal(node.rightChild);
    }

    public static void main(String[] args) {
        createBinarySearchTree();
        /**
         * Tree:
         *              55
         *             /  \
         *           45   60
         *          / \     \
         *        40  50    65
         *       /         /  \
         *     30         63  70
         *    /                 \
         *  20                  75
         *
         */

        System.out.println("In-Order Traversal: ");
        inOrderTraversal(root);
//        20 30 40 45 50 55 60 63 65 70 75
        System.out.println();
        System.out.println("Pre-Order Traversal: ");
        preOrderTraversal(root);
//        55 45 40 30 20 50 60 65 63 70 75
        System.out.println();
        System.out.println("Post-Order Traversal: ");
        postOrderTraversal(root);
//        20 30 40 50 45 63 75 70 65 60 55
    }


}
