/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nieto
 */
public class SingleBedFrame extends JFrame implements ActionListener{
    
    private JButton backbtn, paymentsbtn, img;
    
    SingleBedFrame(){
        setTitle("Single Bed");
        setSize(600, 600);
        setLayout(null);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 70, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        img.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\Nieto\\Documents\\NetBeansProjects\\HotelReservationSystemcloned\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\singlebed.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        
        add(backbtn);
        add(paymentsbtn);
        add(img);
        
        backbtn.addActionListener(this);
        paymentsbtn.addActionListener(this);
    }   
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
     if(e.getSource() == backbtn){
            RoomTypes rt = new RoomTypes();
            rt.setVisible(true);
        }else if (e.getSource() == paymentsbtn) {
            Payment payment = new Payment();
            payment.setVisible(true);
        }
    }
}


