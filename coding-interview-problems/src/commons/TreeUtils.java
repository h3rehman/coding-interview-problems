package commons;

import algos.BinarySearchTree;

public class TreeUtils extends BinarySearchTree {

    public static void createBinarySearchTree(){
        addNode(55);
        addNode(45);
        addNode(50);
        addNode(40);
        addNode(30);
        addNode(20);
        addNode(60);
        addNode(65);
        addNode(70);
        addNode(75);


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
         *
         */

    }

}
