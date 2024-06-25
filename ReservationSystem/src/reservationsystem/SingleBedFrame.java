/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;


import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Nieto
 */
public class SingleBedFrame extends JFrame implements ActionListener{
  private JButton backbtn, paymentsbtn;
  private JLabel sbhead, sbdesc, sbprice, sbdeta;
    
    SingleBedFrame(){
        setTitle("Single Person");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 150, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        sbhead = new JLabel("Standard Room");
        sbhead.setBounds(80, -50, 400, 400);
        sbhead.setFont(new Font("Lucida Calligraphy", Font.BOLD,18));
        add(sbhead);
        
        sbdesc = new JLabel("Most affordable room available.");
        sbdesc.setBounds(80, -20, 400, 400);
        sbdesc.setFont(new Font("Lucida Handwriting", Font.ITALIC,14));
        add(sbdesc);
        
        sbdeta = new JLabel("Available on lower floors.");
        sbdeta.setBounds(80, 0, 400, 400);
        sbdeta.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        add(sbdeta);
        
        sbprice = new JLabel("970.00 php/per night");
        sbprice.setBounds(80, 80, 400, 400);
        sbprice.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        add(sbprice);
        
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
            RoomPaymentOption payment = new RoomPaymentOption();
            payment.setVisible(true);
        }
    }
}

