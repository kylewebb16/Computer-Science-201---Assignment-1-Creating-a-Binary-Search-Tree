import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;


public class Main {
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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        // Create button 1 new BST
        JButton createBSTButton = new JButton("1. Create a new Binary Search Tree");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 50;
        centerPanel.add(createBSTButton, gbc);
        // Create button 2 add a node
        JButton nodeAddButton = new JButton("2. Add a Node");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.ipady = 20;
        centerPanel.add(nodeAddButton, gbc);
        // Create button 3 Delete a node
        JButton deleteNodeButton = new JButton("3. Delete a Node");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipady = 20;
        centerPanel.add(deleteNodeButton, gbc);
        


        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
        // Create content pane
        // GridBagConstraints gbc = new GridBagConstraints();
        // JPanel contentPane = new JPanel(new GridBagLayout());
        // contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // contentPane.setBackground(Color.DARK_GRAY);

        
        
        // Create instruction JLabel
        // Label properties
        // JLabel instructions = new JLabel("Use your keyboard or the buttons below to create, modify, and search your binary search tree.");
        // instructions.setForeground(Color.WHITE);
        // gbc.gridx = 0;
        // gbc.gridy = 0;
        // gbc.anchor = GridBagConstraints.PAGE_START;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // contentPane.add(instructions, gbc);
        
        // JLabel instructions2 = new JLabel("Use your keyboard or the buttons below to create, modify, and search your binary search tree.");
        // gbc.gridx = 1;
        // gbc.gridy = 0;
        // frame.add(instructions2, gbc);
        
        // Adding components to the frame
        
        
        frame.setVisible(true);
    }
}
