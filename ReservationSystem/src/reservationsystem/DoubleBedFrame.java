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
public class DoubleBedFrame extends JFrame implements ActionListener{
  private JButton backbtn, paymentsbtn;
  private JLabel dbhead, dbdesc, dbdeta, dbprice;
    
    DoubleBedFrame(){
        setTitle("Two-person Room");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 150, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        dbhead = new JLabel("Two-person Room");
        dbhead.setBounds(80, -50, 400, 400);
        dbhead.setFont(new Font("Lucida Calligraphy", Font.BOLD,18));
        add(dbhead);
        
        dbdesc = new JLabel("A room for two with an affordable price.");
        dbdesc.setBounds(80, -20, 400, 400);
        dbdesc.setFont(new Font("Lucida Handwriting", Font.ITALIC,14));
        add(dbdesc);
        
        dbdeta = new JLabel("Available on lower and second floors.");
        dbdeta.setBounds(80, 0, 400, 400);
        dbdeta.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        add(dbdeta);
        
        dbprice = new JLabel("1140.00 php/per night");
        dbprice.setBounds(80, 80, 400, 400);
        dbprice.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        add(dbprice);
        
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

