import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        GUI(); 
        
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


    public static void GUI() {
        // General pane properties
        JFrame frame = new JFrame("Binary Search Tree");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("../images/binary-tree.png");
        frame.setIconImage(image.getImage());
        // frame.setLayout();

        // JPanel pane = new JPanel(new GridBagLayout());
        
        
        // Label properties
        
        // Adding components to the frame
        
        
        frame.setVisible(true);
    }
}
