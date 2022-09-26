package algos;

import java.util.LinkedList;
import java.util.Queue;

import static commons.TreeUtils.createBinarySearchTree;

public class BreadthFirstSearch extends BinarySearchTree{


    static void breadthFirstSearch(Node node){
        if (node != null){
            Queue<Node> queue = new LinkedList<>();
            queue.add(node);
            System.out.println("#### Breadth first traversal ####");
            while(!queue.isEmpty()){
                 int len = queue.size();
                 for (int i=0; i<len; i++){
                     Node tempNode = queue.peek();
                     if (tempNode != null){
                         System.out.print(tempNode.key  + " | ");
                         if (tempNode.leftChild != null){
                             queue.add(tempNode.leftChild);
                         }
                         if (tempNode.rightChild != null){
                             queue.add(tempNode.rightChild);
                         }
                     }
                     queue.poll();
                 }
            }

        }
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
         *
         */
        breadthFirstSearch(root);
    }

}
