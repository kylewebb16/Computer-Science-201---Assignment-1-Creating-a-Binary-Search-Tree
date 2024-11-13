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
        myBst.inOrderPrint();
    }
}
