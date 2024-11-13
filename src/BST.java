public class BST {
    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    public BST() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    // Accessible insert method to call private recursive method
    public void insert(int value) {
        root = rInsert(root, value);
    }
    // Private recursive insert method
    private Node rInsert(Node currentNode, int value) {
        // Base case: if current Node is null, return new Node(value)
        if (currentNode == null) {
            return new Node(value);
        }

        // check if val is less than, or greater than currentNode.val
            // recursive call rInsert on appropriate child node
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        // return currentNode
        return currentNode;
    }

}
