/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;


import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Nieto
 */
public class DoubleBedFrame extends JFrame implements ActionListener{
  private JButton backbtn, paymentsbtn;
    
    DoubleBedFrame(){
        setTitle("Single Bed");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 70, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        add(backbtn);
        add(paymentsbtn);
        
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

