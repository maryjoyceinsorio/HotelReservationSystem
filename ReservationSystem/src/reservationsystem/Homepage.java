/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nieto
 */
public class Homepage extends JFrame implements ActionListener {
    
 
    private JButton RoomBtn = new JButton("Rooms");
    private JButton ReserBtn = new JButton("Reservation");
    private JButton PayBtn = new JButton("Payment");
    private JButton ServBtn = new JButton("Services");
 
    
    Homepage(){
        setTitle("Home Page");
        setSize(800, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Location of Buttons
        RoomBtn.setBounds(50, 100, 100, 30);
        RoomBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        
        ReserBtn.setBounds(200, 100, 100, 30);
        ReserBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        
        PayBtn.setBounds(350, 100, 100, 30);
        PayBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        
        ServBtn.setBounds(500, 100, 100, 30);
        ServBtn.setFont(new Font("Arial", Font.PLAIN, 15));
     
        
        add(RoomBtn);
        add(ReserBtn);
        add(PayBtn);
        add(ServBtn);
       
      
        RoomBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
       
            RoomTypes lp = new RoomTypes();
            lp.setVisible(true);
        }
        
    }
