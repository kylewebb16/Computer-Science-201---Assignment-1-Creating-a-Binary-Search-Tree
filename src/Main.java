import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Main {
    // Allows for GUI to create and access tree
    public static BST myBst;
    public static void main(String[] args) {
        // Calls other methods to create GUI and allow user to interact with the tree.
        createGUI(); 
    }


    // Creates main JFrame and adds components from helper methods
    public static void createGUI() {
        // General frame properties, size, look and feel, icon image
        JFrame frame = new JFrame("Binary Search Tree");
        frame.setLayout(new BorderLayout()); 
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("../images/binary-tree.png");
        frame.setIconImage(image.getImage());

        createInstructionsPanel(frame);

        createButtonsPanel(frame);

        frame.pack();
        frame.setVisible(true);
    }


    // Panel with directions for user
    public static void createInstructionsPanel(JFrame frame) {
        // Create top panel with instructions
        // General properties
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel directionsLabel = new JLabel("<html><center><h2>Use the buttons below, or specified keybindings<br>to create and access your binary search tree.</h2></html>");
        directionsLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionsPanel.add(directionsLabel);
        // Add instruction panel to frame
        frame.getContentPane().add(instructionsPanel, BorderLayout.PAGE_START);
    }

    // Create a panel with specified buttons to control the tree from the GUI
    public static void createButtonsPanel(JFrame frame) {
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Delete later
        boolean treeExists = false;

        // Create buttons and specify general properties / layout
        // Button 1: Create a binary search tree
        JButton createBSTButton1 = new JButton("1. Create a new Binary Search Tree");
        createBSTButton1.setFont(buttonFont);
        GridBagConstraints b1 = new GridBagConstraints();
        b1.insets = new Insets(2, 5, 2, 5);
        b1.fill = GridBagConstraints.HORIZONTAL;
        b1.gridx = 0;
        b1.gridy = 0;
        b1.gridwidth = 3;
        b1.ipady = 50;
        
        // Button 2: Add a node
        JButton nodeAddButton2 = new JButton("2. Add a Node");
        nodeAddButton2.setFont(buttonFont);
        GridBagConstraints b2 = new GridBagConstraints();
        nodeAddButton2.setEnabled(treeExists);
        b2.insets = new Insets(2, 5, 2, 5);
        b2.fill = GridBagConstraints.HORIZONTAL;
        b2.gridx = 0;
        b2.gridy = 1;
        b2.gridwidth = 1;
        b2.ipady = 20;
        
        // Button 3: Delete a node
        JButton deleteNodeButton3 = new JButton("3. Delete a Node");
        deleteNodeButton3.setFont(buttonFont);
        deleteNodeButton3.setEnabled(treeExists);
        GridBagConstraints b3 = new GridBagConstraints();
        b3.fill = GridBagConstraints.HORIZONTAL;
        b3.insets = new Insets(2, 5, 2, 5);
        b3.gridx = 1;
        b3.gridy = 1;
        b3.gridwidth = 1;
        b3.ipady = 20;
        
        // Button 4: Print nodes DFS-In Order
        JButton inOrderButton4 = new JButton("4. Print Nodes in Order");
        inOrderButton4.setFont(buttonFont);
        inOrderButton4.setEnabled(treeExists);
        GridBagConstraints b4 = new GridBagConstraints();
        b4.fill = GridBagConstraints.HORIZONTAL;
        b4.insets = new Insets(2, 5, 2, 5);
        b4.gridx = 0;
        b4.gridy = 2;
        b4.gridwidth = 1;
        b4.ipady = 20;
        
        // Button 5: Print nodes DFS- pre order
        JButton preOrderButton5 = new JButton("5. Print Nodes in Pre Order");
        preOrderButton5.setFont(buttonFont);
        preOrderButton5.setEnabled(treeExists);
        GridBagConstraints b5 = new GridBagConstraints();
        b5.fill = GridBagConstraints.HORIZONTAL;
        b5.insets = new Insets(2, 5, 2, 5);
        b5.gridx = 1;
        b5.gridy = 2;
        b5.gridwidth = 1;
        b5.ipady = 20;

        // Button 6: Print nodes in DFS- post order 
        JButton postOrderButton6 = new JButton("6. Print Nodes in Post Order");
        postOrderButton6.setFont(buttonFont);
        postOrderButton6.setEnabled(treeExists);
        GridBagConstraints b6 = new GridBagConstraints();
        b6.fill = GridBagConstraints.HORIZONTAL;
        b6.insets = new Insets(2, 5, 2, 5);
        b6.gridx = 0;
        b6.gridy = 3;
        b6.gridwidth = 1;
        b6.ipady = 20;
        
        // Button 7: exit the program
        JButton exitProgramButton7 = new JButton("7. Exit");
        exitProgramButton7.setFont(buttonFont);
        GridBagConstraints b7 = new GridBagConstraints();
        b7.fill = GridBagConstraints.HORIZONTAL;
        b7.insets = new Insets(2, 5, 2, 5);
        b7.gridx = 1;
        b7.gridy = 3;
        b7.gridwidth = 1;
        b7.ipady = 20;


        // Create actions activated by buttons, allows GUI access to BST
        Action createBSTAction = new AbstractAction("createTree") {
            // Creates BST from GUI, enables other buttons once tree exists
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myBst == null) {
                    myBst = new BST();
                    nodeAddButton2.setEnabled(true);
                    deleteNodeButton3.setEnabled(true);
                    inOrderButton4.setEnabled(true);
                    preOrderButton5.setEnabled(true);
                    postOrderButton6.setEnabled(true);
                } else {
                    // Ensure user wants to delete current bst and create new one if already exists
                    int choice = JOptionPane.showConfirmDialog(frame, "<html><center>Creating a new tree will <u>destroy the current tree</u><br>Do you want to continue?</html>");
                    if (choice == JOptionPane.YES_OPTION) {
                        myBst = new BST();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Canceled create new search tree");
                    }
                }
            }
        };
        // Map keybind & add to button
        createBSTButton1.addActionListener(createBSTAction);
        createBSTButton1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("1"), "createTree");
        createBSTButton1.getActionMap().put("createTree", createBSTAction);
        
        Action addNodeAction = new AbstractAction("addNode") {
            // Adds a new node to BST from GUI, only allows valid integer input, enables delete and print if first node
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of new node:"));
                    myBst.insert(userInput);
                    JOptionPane.showMessageDialog(frame, "Success, added " + userInput + " to tree!");
                    if (!deleteNodeButton3.isEnabled()) {
                        deleteNodeButton3.setEnabled(true);
                        inOrderButton4.setEnabled(true);
                        preOrderButton5.setEnabled(true);
                        postOrderButton6.setEnabled(true);
                    }
                } 
                catch (NumberFormatException numErr) {
                    JOptionPane.showMessageDialog(frame, "Failed to add node. \nPlease enter an integer.", "Invalid input", JOptionPane.ERROR_MESSAGE);
                } 
                catch (NullPointerException ptrErr) {
                    JOptionPane.showMessageDialog(frame, "Create a binary search tree first. \n(Try using button 1)", "No Tree exists", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Create a Binary Search Tree First! (Use button 1)");
                }
            }
        };
        // Create keybind & add action to button
        nodeAddButton2.addActionListener(addNodeAction);
        nodeAddButton2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("2"), "addNode");
        nodeAddButton2.getActionMap().put("addNode", addNodeAction);
        
        Action deleteNodeAction = new AbstractAction("deleteNode") {
            // Use BST.deleteNode from GUI, checks for valid input, disables delete and print buttons if last node deleted
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of the node you want to delete:"));
                    myBst.deleteNode(userInput);
                    JOptionPane.showMessageDialog(frame, "Removed " + userInput + " from tree");
                    if (myBst.getNumOfNodes() < 1) {
                        deleteNodeButton3.setEnabled(false);
                        inOrderButton4.setEnabled(false);
                        preOrderButton5.setEnabled(false);
                        postOrderButton6.setEnabled(false);
                    }
                } 
                catch (NumberFormatException numErr) {
                    JOptionPane.showMessageDialog(frame, "Please enter an integer (0,1,2,3...)", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
                catch (NullPointerException ptrErr) {
                    JOptionPane.showMessageDialog(frame, "Create a binary search tree first. \n(Try using button 1)", "No Tree exists", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        // Add keybind and add action to button
        deleteNodeButton3.addActionListener(deleteNodeAction);
        deleteNodeButton3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("3"), "deleteNode");
        deleteNodeButton3.getActionMap().put("deleteNode", deleteNodeAction);        

        Action inOrderPrint = new AbstractAction("printInOrder") {
            // Access BST.inOrderPrint from GUI, displays to user if the tree has nodes
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myBst != null) {
                    ArrayList<Integer> results = myBst.inOrderPrint();
                    if (results != null) {
                        JOptionPane.showMessageDialog(frame, "Tree In Order:\n" + results, "Tree: In Order", JOptionPane.DEFAULT_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Tree is empty", "Empty tree", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Tree does not exist\n" + "Create a new tree first", "Tree does not exist", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        };
        // Add keybind and action to button
        inOrderButton4.addActionListener(inOrderPrint);
        inOrderButton4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("4"), "printInOrder");
        inOrderButton4.getActionMap().put("printInOrder", inOrderPrint);
        
        Action preOrderAction = new AbstractAction("printPreOrder") {
            // Access BST.preOrderPrint from GUI, display results to user
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> results = myBst.preOrderPrint();
                JOptionPane.showMessageDialog(frame, "Tree Pre Order:\n" + results, "Tree: Pre Order", JOptionPane.DEFAULT_OPTION);
            }
        };
        // Add keybinding & add action to button
        preOrderButton5.addActionListener(preOrderAction);
        preOrderButton5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("5"), "printPreOrder");
        preOrderButton5.getActionMap().put("printPreOrder", preOrderAction);

        Action postOrderPrintAction = new AbstractAction("printPostOrder") {
            // Access BST.postOrderPrint from GUI, display result to user
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> results = myBst.postOrderPrint();
                JOptionPane.showMessageDialog(frame, "Tree Post Order:\n" + results, "Tree: Post Order", JOptionPane.DEFAULT_OPTION);
    
            }
        };
        // Add keybinding and add action to button
        postOrderButton6.addActionListener(postOrderPrintAction);
        postOrderButton6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("6"), "printPostOrder");
        postOrderButton6.getActionMap().put("printPostOrder", postOrderPrintAction);

        Action exitAction = new AbstractAction("exitAction") {
            // Allows user to exit the application using a button or keybinding
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Confirm: Do you want to exit the program?", "Exit Program", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Exit caneceled", "Returning to program", JOptionPane.DEFAULT_OPTION);
                }
            }
        };
        // Add keybinding and add action to button
        exitProgramButton7.addActionListener(exitAction);
        exitProgramButton7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("7"), "exitAction");
        exitProgramButton7.getActionMap().put("exitAction", exitAction);
        
        // Add components
        centerPanel.add(createBSTButton1, b1);
        centerPanel.add(nodeAddButton2, b2);
        centerPanel.add(deleteNodeButton3, b3);
        centerPanel.add(inOrderButton4, b4);
        centerPanel.add(preOrderButton5, b5);
        centerPanel.add(postOrderButton6, b6);
        centerPanel.add(exitProgramButton7, b7);
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
    }
}
