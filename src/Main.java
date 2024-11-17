import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static BST myBst;
    public static void main(String[] args) {
        GUI(); 
        
    }

    public static void GUI() {
        // General pane properties
        JFrame frame = new JFrame("Binary Search Tree");
        frame.setLayout(new BorderLayout());
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("../images/binary-tree.png");
        frame.setIconImage(image.getImage());



        // Create top panel with instructions
        JPanel instructionsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel directionsLabel = new JLabel("Use your keyboard or the buttons below to create, modify, and search your binary search tree.");
        directionsLabel.setHorizontalAlignment(JLabel.CENTER);
        instructionsPanel.add(directionsLabel, BorderLayout.CENTER);
        frame.getContentPane().add(instructionsPanel, BorderLayout.PAGE_START);



        // Create center panel with buttons
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.RED)); // Delete later
        
        JButton createBSTButton = new JButton("1. Create a new Binary Search Tree");
        GridBagConstraints b1 = new GridBagConstraints();
        b1.insets = new Insets(2, 5, 2, 5);
        b1.fill = GridBagConstraints.HORIZONTAL;
        b1.gridx = 0;
        b1.gridy = 0;
        b1.gridwidth = 3;
        b1.ipady = 50;
        createBSTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myBst == null) {
                    myBst = new BST();
                } else {
                        int choice = JOptionPane.showConfirmDialog(frame, "You have already created a binary search tree. \nIf you create a new one, the old one will be deleted. \nDo you want to continue?");
                        if (choice == JOptionPane.YES_OPTION) {
                            myBst = new BST();

                        } else {
                            JOptionPane.showMessageDialog(frame, "Canceled create new search tree");
                        }
                }
            }
        });
        centerPanel.add(createBSTButton, b1);

        JButton nodeAddButton = new JButton("2. Add a Node");
        GridBagConstraints b2 = new GridBagConstraints();
        b2.insets = new Insets(2, 5, 2, 5);
        b2.fill = GridBagConstraints.HORIZONTAL;
        b2.gridx = 0;
        b2.gridy = 1;
        b2.gridwidth = 1;
        b2.ipady = 20;
        nodeAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of new node:"));
                    myBst.insert(userInput);
                    JOptionPane.showMessageDialog(frame, "Success, added " + userInput + " to tree!");
                    
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
        centerPanel.add(nodeAddButton, b2);

        JButton deleteNodeButton = new JButton("3. Delete a Node");
        GridBagConstraints b3 = new GridBagConstraints();
        b3.fill = GridBagConstraints.HORIZONTAL;
        b3.insets = new Insets(2, 5, 2, 5);
        b3.gridx = 1;
        b3.gridy = 1;
        b3.gridwidth = 1;
        b3.ipady = 20;
        deleteNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userInput = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter value of the node you want to delete:"));
                    myBst.deleteNode(userInput);
                    JOptionPane.showMessageDialog(frame, "Removed " + userInput + " from tree");
                    
                } catch (NumberFormatException numErr) {
                    // TODO: handle exception
                    JOptionPane.showMessageDialog(frame, "Please enter an integer (0,1,2,3...)", "Invalid input", JOptionPane.ERROR_MESSAGE);
                }
                catch (NullPointerException ptrErr) {
                    JOptionPane.showMessageDialog(frame, "Create a binary search tree first. \n(Try using button 1)", "No Tree exists", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        centerPanel.add(deleteNodeButton, b3);
        
        JButton inOrderButton = new JButton("4. Print Nodes in Order");
        GridBagConstraints b4 = new GridBagConstraints();
        b4.fill = GridBagConstraints.HORIZONTAL;
        b4.insets = new Insets(2, 5, 2, 5);
        b4.gridx = 0;
        b4.gridy = 2;
        b4.gridwidth = 1;
        b4.ipady = 20;
        inOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> results = myBst.inOrderPrint();
                if (results != null) {
                    JOptionPane.showMessageDialog(frame, results, "Search Tree in order", JOptionPane.DEFAULT_OPTION);
                }
            }
        });
        centerPanel.add(inOrderButton, b4);
        
        JButton preOrderButton = new JButton("5. Print Nodes in Pre Order");
        GridBagConstraints b5 = new GridBagConstraints();
        b5.fill = GridBagConstraints.HORIZONTAL;
        b5.insets = new Insets(2, 5, 2, 5);
        b5.gridx = 1;
        b5.gridy = 2;
        b5.gridwidth = 1;
        b5.ipady = 20;
        centerPanel.add(preOrderButton, b5);
        
        JButton postOrdButton = new JButton("6. Print Nodes in Post Order");
        GridBagConstraints b6 = new GridBagConstraints();
        b6.fill = GridBagConstraints.HORIZONTAL;
        b6.insets = new Insets(2, 5, 2, 5);
        b6.gridx = 0;
        b6.gridy = 3;
        b6.gridwidth = 1;
        b6.ipady = 20;
        centerPanel.add(postOrdButton, b6);
        
        JButton exitProgramButton = new JButton("Exit");
        GridBagConstraints b7 = new GridBagConstraints();
        b7.fill = GridBagConstraints.HORIZONTAL;
        b7.insets = new Insets(2, 5, 2, 5);
        b7.gridx = 1;
        b7.gridy = 3;
        b7.gridwidth = 1;
        b7.ipady = 20;
        centerPanel.add(exitProgramButton, b7);


        // Add components to frame and show once finished
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
