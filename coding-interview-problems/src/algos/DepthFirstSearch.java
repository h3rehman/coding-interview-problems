package algos;

import static commons.TreeUtils.createBinarySearchTree;

public class DepthFirstSearch extends BinarySearchTree{

    static void inOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.key + " | ");
        inOrderTraversal(node.rightChild);
    }

    static void preOrderTraversal(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.key + " | ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    static void postOrderTraversal(Node node){
        if (node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.key + " | ");
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
         *       /            \
         *     30             70
         *    /                 \
         *  20                  75
         * In order Traversal:
         * 20 30 40 45 50 55 60 65 70 75
         *
         * Pre order Traversal:
         * 55 45 40 30 20 50 60 65 70 75
         *
         * Post order Traversal:
         * 20 30 40 50 45 75 70 65 60 55
         */
        System.out.println("###### In order traversal: #####");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("##### Pre order traversal: #####");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("#### Post order traversal: #####");
        postOrderTraversal(root);
    }

}
