/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ROOMS extends JFrame {
    private JLabel lblSingle, lblDouble, lblSuite, lblTwopersonRoom, lblBalcony, lblFamilySuite,
            lblDeluxe, lblSuperior, lblExecutive, lblFamily;
    private JButton btnBack;

    public ROOMS() {
        setTitle("Room Types");
        setSize(600, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(Color.LIGHT_GRAY);
         
        setLayout(null);
        setBackground(new Color(215, 230, 243)); 

        lblSingle = new JLabel("Single");
        lblSingle.setBounds(50, 50, 100, 25);
        add(lblSingle);

        lblDouble = new JLabel("Double");
        lblDouble.setBounds(50, 80, 100, 25);
        add(lblDouble);

        lblSuite = new JLabel("Suite");
        lblSuite.setBounds(50, 110, 100, 25);
        add(lblSuite);

        lblTwopersonRoom = new JLabel("Two-person Room");
        lblTwopersonRoom.setBounds(50, 140, 150, 25);
        add(lblTwopersonRoom);

        lblBalcony = new JLabel("Balcony Room");
        lblBalcony.setBounds(50, 170, 120, 25);
        add(lblBalcony);

        lblFamilySuite = new JLabel("Family Suite");
        lblFamilySuite.setBounds(50, 200, 100, 25);
        add(lblFamilySuite);

        lblDeluxe = new JLabel("Deluxe Room");
        lblDeluxe.setBounds(200, 50, 100, 25);
        add(lblDeluxe);

        lblSuperior = new JLabel("Superior Deluxe Suite");
        lblSuperior.setBounds(200, 80, 150, 25);
        add(lblSuperior);

        lblExecutive = new JLabel("Executive Suite");
        lblExecutive.setBounds(200, 110, 120, 25);
        add(lblExecutive);

        lblFamily = new JLabel("Family Deluxe Suite");
        lblFamily.setBounds(200, 140, 130, 25);
        add(lblFamily);

        btnBack = new JButton("Back to Homepage");
        btnBack.setBounds(200, 250, 180, 30);
        btnBack.setFont(new Font("Arial", Font.BOLD , 15));
        
        
        btnBack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to go back to homepage
                Homepage homepage = new Homepage();
                homepage.setVisible(true);
                dispose(); 
            }
        });
        add(btnBack);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ROOMS();
    }
}