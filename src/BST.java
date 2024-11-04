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
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        Node currentNode = this.root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    // Left off here
                }
            }
        }
        return false;
    }

}
