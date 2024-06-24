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
public class DeluxeRoom extends JFrame implements ActionListener{
  private JButton backbtn, paymentsbtn;
  private JLabel blhead, bldesc, bldeta, blprice;
    
    DeluxeRoom(){
        setTitle("Family Room");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 150, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        blhead = new JLabel("Triple Family Room");
        blhead.setBounds(80, -50, 400, 400);
        blhead.setFont(new Font("Lucida Calligraphy", Font.BOLD,18));
        add(blhead);
        
        bldesc = new JLabel("A small room for families");
        bldesc.setBounds(80, -20, 400, 400);
        bldesc.setFont(new Font("Lucida Handwriting", Font.ITALIC,14));
        add(bldesc);
        
        bldeta = new JLabel("Available on second floors and third floors.");
        bldeta.setBounds(80, 0, 400, 400);
        bldeta.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        add(bldeta);
        
        blprice = new JLabel("1825.00 php/per night");
        blprice.setBounds(80, 80, 400, 400);
        blprice.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        add(blprice);
        
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
