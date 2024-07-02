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
    private JLabel lblSingle, lblDouble, lblSuite, lblTwopersonRoom, lblBalcony, lblFamilySuite,bg,
            lblDeluxe, lblSuperior, lblExecutive, lblFamily;
    private JButton btnBack;

    public ROOMS() {
        setTitle("Room Types");
        setSize(600, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(Color.BLACK);
         
         
        setLayout(null);
          bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(100, 20, 500, 300);
        

        lblSingle = new JLabel("Single");
        lblSingle.setBounds(50, 50, 100, 25);
        lblSingle.setForeground(Color.WHITE);
        add(lblSingle);

        lblDouble = new JLabel("Double");
        lblDouble.setBounds(50, 80, 100, 25);
        lblDouble.setForeground(Color.WHITE);
        add(lblDouble);

        lblSuite = new JLabel("Suite");
        lblSuite.setBounds(50, 110, 100, 25);
        lblSuite.setForeground(Color.WHITE);
        add(lblSuite);

        lblTwopersonRoom = new JLabel("Two-person Room");
        lblTwopersonRoom.setBounds(50, 140, 150, 25);
        lblTwopersonRoom.setForeground(Color.WHITE);
        add(lblTwopersonRoom);

        lblBalcony = new JLabel("Balcony Room");
        lblBalcony.setBounds(50, 170, 120, 25);
         lblBalcony.setForeground(Color.WHITE);
        add(lblBalcony);

        lblFamilySuite = new JLabel("Family Suite");
        lblFamilySuite.setBounds(50, 200, 100, 25);
         lblFamilySuite.setForeground(Color.WHITE);
        add(lblFamilySuite);

        lblDeluxe = new JLabel("Deluxe Room");
        lblDeluxe.setBounds(200, 50, 100, 25);
         lblDeluxe.setForeground(Color.WHITE);
        add(lblDeluxe);

        lblSuperior = new JLabel("Superior Deluxe Suite");
        lblSuperior.setBounds(200, 80, 150, 25);
        lblSuperior.setForeground(Color.WHITE);
        add(lblSuperior);

        lblExecutive = new JLabel("Executive Suite");
        lblExecutive.setBounds(200, 110, 120, 25);
          lblExecutive.setForeground(Color.WHITE);
        add(lblExecutive);

        lblFamily = new JLabel("Family Deluxe Suite");
        lblFamily.setBounds(200, 140, 130, 25);
        lblFamily.setForeground(Color.WHITE);
        add(lblFamily);

        btnBack = new JButton("Back to Homepage");
        btnBack.setBounds(200, 250, 180, 30);
        btnBack.setFont(new Font("Arial", Font.BOLD , 15));
        
        add(bg);
        btnBack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Homepage homepage = new Homepage();
                homepage.setVisible(true);
                dispose(); 
            }
        });
        add(btnBack);

        setVisible(true);
    }
}
  