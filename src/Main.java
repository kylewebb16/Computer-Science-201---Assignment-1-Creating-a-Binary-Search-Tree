import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    // Allows for GUI to create and access tree
    public static BST myBst;
    public static void main(String[] args) {
        createGUI(); 
        
    }

    // Creates main JFrame and adds components from helper methods
    public static void createGUI() {
        // General frame properties
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


    public static void createInstructionsPanel(JFrame frame) {
        // Create top panel with instructions
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel directionsLabel = new JLabel("Use your keyboard, or the buttons below to create, modify, and search your binary search tree.");
        Font labelFont = new Font("Arial", Font.PLAIN, 20);
        directionsLabel.setFont(labelFont);
        directionsLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionsPanel.add(directionsLabel, BorderLayout.CENTER);
        frame.getContentPane().add(instructionsPanel, BorderLayout.PAGE_START);
    }
    

    // Create a panel with specified buttons to control the tree from the GUI
    public static void createButtonsPanel(JFrame frame) {
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Delete later
        boolean treeExists = false;

        // Button 1: Create a binary search tree
        JButton createBSTButton = new JButton("1. Create a new Binary Search Tree");
        createBSTButton.setFont(buttonFont);
        GridBagConstraints b1 = new GridBagConstraints();
        b1.insets = new Insets(2, 5, 2, 5);
        b1.fill = GridBagConstraints.HORIZONTAL;
        b1.gridx = 0;
        b1.gridy = 0;
        b1.gridwidth = 3;
        b1.ipady = 50;
        
        // Button 2: Add a node
        JButton nodeAddButton = new JButton("2. Add a Node");
        nodeAddButton.setFont(buttonFont);
        GridBagConstraints b2 = new GridBagConstraints();
        nodeAddButton.setEnabled(treeExists);
        b2.insets = new Insets(2, 5, 2, 5);
        b2.fill = GridBagConstraints.HORIZONTAL;
        b2.gridx = 0;
        b2.gridy = 1;
        b2.gridwidth = 1;
        b2.ipady = 20;
        

        // Button 3: Delete a node
        JButton deleteNodeButton = new JButton("3. Delete a Node");
        deleteNodeButton.setFont(buttonFont);
        deleteNodeButton.setEnabled(treeExists);
        GridBagConstraints b3 = new GridBagConstraints();
        b3.fill = GridBagConstraints.HORIZONTAL;
        b3.insets = new Insets(2, 5, 2, 5);
        b3.gridx = 1;
        b3.gridy = 1;
        b3.gridwidth = 1;
        b3.ipady = 20;
        
        // Button 4: Print nodes DFS-In Order
        JButton inOrderButton = new JButton("4. Print Nodes in Order");
        inOrderButton.setFont(buttonFont);
        inOrderButton.setEnabled(treeExists);
        GridBagConstraints b4 = new GridBagConstraints();
        b4.fill = GridBagConstraints.HORIZONTAL;
        b4.insets = new Insets(2, 5, 2, 5);
        b4.gridx = 0;
        b4.gridy = 2;
        b4.gridwidth = 1;
        b4.ipady = 20;
        
        
        // Button 5: Print nodes DFS- pre order
        JButton preOrderButton = new JButton("5. Print Nodes in Pre Order");
        preOrderButton.setFont(buttonFont);
        preOrderButton.setEnabled(treeExists);
        GridBagConstraints b5 = new GridBagConstraints();
        b5.fill = GridBagConstraints.HORIZONTAL;
        b5.insets = new Insets(2, 5, 2, 5);
        b5.gridx = 1;
        b5.gridy = 2;
        b5.gridwidth = 1;
        b5.ipady = 20;

        // Button 6: Print nodes in DFS- post order 
        JButton postOrdButton = new JButton("6. Print Nodes in Post Order");
        postOrdButton.setFont(buttonFont);
        postOrdButton.setEnabled(treeExists);
        GridBagConstraints b6 = new GridBagConstraints();
        b6.fill = GridBagConstraints.HORIZONTAL;
        b6.insets = new Insets(2, 5, 2, 5);
        b6.gridx = 0;
        b6.gridy = 3;
        b6.gridwidth = 1;
        b6.ipady = 20;
        
        // Button 7: exit the program
        JButton exitProgramButton = new JButton("Exit");
        exitProgramButton.setFont(buttonFont);
        GridBagConstraints b7 = new GridBagConstraints();
        b7.fill = GridBagConstraints.HORIZONTAL;
        b7.insets = new Insets(2, 5, 2, 5);
        b7.gridx = 1;
        b7.gridy = 3;
        b7.gridwidth = 1;
        b7.ipady = 20;


        // Action listeners
        createBSTButton.addActionListener(new ActionListener() {
            // Create a new BST, if one is already created, confirm deletion of previous
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myBst == null) {
                    myBst = new BST();
                    nodeAddButton.setEnabled(true);
                } else {
                        int choice = JOptionPane.showConfirmDialog(frame, "You have already created a binary search tree. \nIf you create a new tree, the current tree will be deleted. \nDo you want to continue?");
                        if (choice == JOptionPane.YES_OPTION) {
                            myBst = new BST();
                            deleteNodeButton.setEnabled(false);
                            inOrderButton.setEnabled(false);
                            preOrderButton.setEnabled(false);
                            postOrdButton.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Canceled create new search tree");
                        }
                }
            }
        });
        
        nodeAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of new node:"));
                    myBst.insert(userInput);
                    JOptionPane.showMessageDialog(frame, "Success, added " + userInput + " to tree!");
                    if (!deleteNodeButton.isEnabled()) {
                        deleteNodeButton.setEnabled(true);
                        inOrderButton.setEnabled(true);
                        preOrderButton.setEnabled(true);
                        postOrdButton.setEnabled(true);
                    }
                    
                } catch (NumberFormatException numErr) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(frame, "Failed to add node. \nPlease enter an integer.", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
                catch (NullPointerException ptrErr) {
                    JOptionPane.showMessageDialog(frame, "Create a binary search tree first. \n(Try using button 1)", "No Tree exists", JOptionPane.ERROR_MESSAGE);
                    System.err.println("Create a Binary Search Tree First! (Use button 1)");
                }
            }
        });
        
        deleteNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of the node you want to delete:"));
                    myBst.deleteNode(userInput);
                    JOptionPane.showMessageDialog(frame, "Removed " + userInput + " from tree");
                    if (myBst.getNumOfNodes() < 1) {
                        deleteNodeButton.setEnabled(false);
                        inOrderButton.setEnabled(false);
                        preOrderButton.setEnabled(false);
                        postOrdButton.setEnabled(false);
                    }
                } catch (NumberFormatException numErr) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(frame, "Please enter an integer (0,1,2,3...)", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
                catch (NullPointerException ptrErr) {
                    JOptionPane.showMessageDialog(frame, "Create a binary search tree first. \n(Try using button 1)", "No Tree exists", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        inOrderButton.addActionListener(new ActionListener() {
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
        });
        
        preOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> results = myBst.preOrderPrint();
                if (results != null) {
                    JOptionPane.showMessageDialog(frame, "Tree Pre Order:\n" + results, "Tree: Pre Order", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        
        // Add components
        centerPanel.add(createBSTButton, b1);
        centerPanel.add(nodeAddButton, b2);
        centerPanel.add(deleteNodeButton, b3);
        centerPanel.add(inOrderButton, b4);
        centerPanel.add(preOrderButton, b5);
        centerPanel.add(postOrdButton, b6);
        centerPanel.add(exitProgramButton, b7);
        
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
    }
    
}
