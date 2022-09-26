package algos;

abstract public class BinarySearchTree {

    static Node root;
    static class Node {
        int key;
        Node leftChild;
        Node rightChild;

        Node(int key){
            this.key = key;
        }
    }


    /**
     * Maintains a binary search tree
     */
    protected static void addNode(int key){
        DepthFirstSearch.Node newNode = new DepthFirstSearch.Node(key);
        if (root == null){
            root = newNode;
        }
        else{
            DepthFirstSearch.Node focusNode = root;
            DepthFirstSearch.Node parent;
            while(true){
                if (key < focusNode.key){
                    parent = focusNode;
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    parent = focusNode;
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }


}
