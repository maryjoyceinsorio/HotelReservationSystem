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
  private JLabel dxhead, dxdesc, dxdeta, dxprice;
    
    DeluxeRoom(){
        setTitle("Deluxe Room");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 150, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        dxhead = new JLabel("Deluxe Room");
        dxhead.setBounds(80, -50, 400, 400);
        dxhead.setFont(new Font("Lucida Calligraphy", Font.BOLD,18));
        add(dxhead);
        
        dxdesc = new JLabel("A large room capable of fitting two or one");
        dxdesc.setBounds(80, -20, 400, 400);
        dxdesc.setFont(new Font("Lucida Handwriting", Font.ITALIC,14));
        add(dxdesc);
        
        dxdeta = new JLabel("Available on second floors and third floors.");
        dxdeta.setBounds(80, 0, 400, 400);
        dxdeta.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        add(dxdeta);
        
        dxprice = new JLabel("2045.00 php/per night");
        dxprice.setBounds(80, 80, 400, 400);
        dxprice.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        add(dxprice);
        
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
