import java.util.ArrayList;

public class BST {
    class Node {
        public int value;
        public Node left;
        public Node right;

        // Node constructor
        Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    private int numOfNodes;

    // 1st assignment requirement
    // Constructor 
    public BST() {
        this.root = null;
        this.numOfNodes = 7;
        this.insert(4);
        this.insert(2);
        this.insert(6);
        this.insert(1);
        this.insert(3);
        this.insert(5);
        this.insert(7);
    }

    public Node getRoot() {
        return root;
    }

    public int getNumOfNodes() {
        return numOfNodes;
    }

    
// Methods that edit the tree

    // 2nd assignment requirement
    // Accessible insert method to call private recursive method on root
    public void insert(int value) { root = rInsert(root, value); }

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
    // 3rd assignment requirement 
    public void deleteNode(int value) { root = deleteNode(root, value); }
    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;
        // Traverse tree, search for value
        if (value < currentNode.value) currentNode.left = deleteNode(currentNode.left, value);
        else if (value > currentNode.value) currentNode.right = deleteNode(currentNode.right, value);
        else { // value == currentNode.value
            // No child nodes
            if (currentNode.left == null && currentNode.right == null) {
                numOfNodes--;
                return null;
            }
            // right child only
            else if (currentNode.left == null) {
                currentNode = currentNode.right;
                numOfNodes--;
            }
            // left child only
            else if (currentNode.right == null) {
                currentNode = currentNode.left;
                numOfNodes--;
            }
            // Two child nodes, replace current with smallest value in right subtree, delete smallest
            else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);

            }
        }
        return currentNode;
    }
    // Helper method for deleteNode, finds smallest node in subtree
    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


// DFS methods
    // 4th assignment requirement
    public ArrayList<Integer> inOrderPrint() {
        // Depth first search, visits nodes from smallest value to largest
        if (root == null) return null;
        ArrayList<Integer> results = new ArrayList<>(numOfNodes);
        // Recursively search the tree
        class Traverse {
            public Traverse(Node currentNode) {
                // Searches left first every time, then adds value
                if (currentNode.left != null) new Traverse(currentNode.left);

                results.add(currentNode.value);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);
        return results;
    }

    // 5th assignment requirement
    public ArrayList<Integer> preOrderPrint() {
        // Depth first search, visits current node before visiting children
        if (root == null) return null;
        ArrayList<Integer> results = new ArrayList<>(numOfNodes);
        // Create recursive traverse method
        class Traverse {
            public Traverse(Node currentNode) {
                // Add current value to results, prioritize left search, when no left nodes remain go right
                results.add(currentNode.value);
                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
            }
        }
        new Traverse(root);

        return results;
    }

    // 6th assignment requirement
    public ArrayList<Integer> postOrderPrint() {
        // Depth first search, visits nodes children first, then goes to parents
        if (root == null) return null;
        ArrayList<Integer> results = new ArrayList<>(numOfNodes);
        // Create recursive traverse method
        class Traverse {
            public Traverse(Node currentNode) {
                // Search left first, when no left nodes remain go right, when no child nodes write value to results

                if (currentNode.left != null) new Traverse(currentNode.left);
                if (currentNode.right != null) new Traverse(currentNode.right);
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        
        return results;
    }

    // 7th assignment requirement @src/Main.java 
}
