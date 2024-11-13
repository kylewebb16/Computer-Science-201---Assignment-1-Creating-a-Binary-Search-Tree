import java.util.ArrayList;

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
    private int numOfNodes;
    public BST() {
        this.root = null;
        this.numOfNodes = 0;
    }

    public Node getRoot() {
        return root;
    }

    // Accessible insert method to call private recursive method
    public void insert(int value) {
        root = rInsert(root, value);
    }
    private Node rInsert(Node currentNode, int value) {
        // Base case: if current Node is null, return new Node(value)
        if (currentNode == null) {
            numOfNodes++;
            return new Node(value);
        }
        // check if val is less than, or greater than currentNode.val: recursive call rInsert 
        if (value < currentNode.value) currentNode.left = rInsert(currentNode.left, value);
        else if (value > currentNode.value) currentNode.right = rInsert(currentNode.right, value);

        return currentNode;
    }

    public ArrayList<Integer> inOrderPrint() {
        ArrayList<Integer> results = new ArrayList<>(numOfNodes);
        class Traverse {
            public Traverse(Node currentNode) {
                // Searches left first every time, then adds value
                if (currentNode.left != null) new Traverse(currentNode.left);

                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        System.out.println(results);
        return results;
    }

    public ArrayList<Integer> preOrderPrint() {
        ArrayList<Integer> results = new ArrayList<>(numOfNodes);
        class Traverse {
            public Traverse(Node currentNode) {
                // Add current value to results, prioritize left search, when no left nodes remain go right
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);

        System.out.println(results);
        return results;
    }

}
