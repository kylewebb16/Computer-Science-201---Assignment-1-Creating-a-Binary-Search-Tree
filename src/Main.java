public class Main {
    public static void main(String[] args) {
        BST myBst = new BST();
        myBst.insert(10);
        myBst.insert(5);
        myBst.insert(5);
        myBst.insert(15);
        System.out.println("Root = " + myBst.getRoot().value);
        System.out.println("Left child = " + myBst.getRoot().left.value);
        System.out.println("Right child = " + myBst.getRoot().right.value);

        System.out.println("\nIn order:");
        myBst.inOrderPrint();

        System.out.println("\nPre order:");
        myBst.preOrderPrint();
    }
}
