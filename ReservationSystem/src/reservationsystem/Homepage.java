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
import java.awt.EventQueue;
import javax.swing.*;

public class Homepage extends JFrame {
    
    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(200, 50, 400, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(20.0f));
        add(lblWelcome);
        
        JButton btnSearchRoom = new JButton("Search Rooms");
        btnSearchRoom.setBounds(100, 150, 200, 30);
        btnSearchRoom.addActionListener(e -> {
            
            new SEARCH77().setVisible(true);
            dispose(); 
        });
        add(btnSearchRoom);
        
        JButton btnReservationArea = new JButton("Reservation Area");
        btnReservationArea.setBounds(350, 150, 200, 30);
        btnReservationArea.addActionListener(e -> {
            
            new HotelReservation().setVisible(true);
            dispose(); 
        });
        add(btnReservationArea);
        
        JButton btnRoomService = new JButton("Room Service");
        btnRoomService.setBounds(100, 250, 200, 30);
        btnRoomService.addActionListener(e -> {
           
            new RoomService().setVisible(true);
            dispose(); 
        });
        add(btnRoomService);
        
        JButton btnPayment = new JButton("Payment");
        btnPayment.setBounds(350, 250, 200, 30);
        btnPayment.addActionListener(e -> {
            
            new Payment().setVisible(true);
            dispose(); 
        });
        add(btnPayment);
        
        setVisible(true);
    }

    
     public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
          

             @Override
             public void run() {
                   new Homepage();
             }
        });
    }
}
