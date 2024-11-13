public class Main {
    public static void main(String[] args) {
        BST myBst = new BST();
        myBst.insert(10);
        myBst.insert(5);
        myBst.insert(5);
        myBst.insert(15);
        myBst.insert(3);
        myBst.insert(1);
        myBst.insert(9);

        System.out.println("\nIn order:");
        myBst.inOrderPrint();

        System.out.println("\nPre order:");
        myBst.preOrderPrint();

        System.out.println("\nPost order:");
        myBst.postOrderPrint();
    }
}
