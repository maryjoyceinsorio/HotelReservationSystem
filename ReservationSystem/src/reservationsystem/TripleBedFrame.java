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
public class TripleBedFrame extends JFrame implements ActionListener{
  private JButton backbtn, paymentsbtn;
  private JLabel tbhead, tbdesc, tbdeta, tbprice;
    
    TripleBedFrame(){
        setTitle("Family Room");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backbtn = new JButton("Back");
        backbtn.setBounds(10, 50, 150, 50);
        
        paymentsbtn = new JButton("Payments");
        paymentsbtn.setBounds(410, 400, 150, 50);
        
        tbhead = new JLabel("Triple Family Room");
        tbhead.setBounds(80, -50, 400, 400);
        tbhead.setFont(new Font("Lucida Calligraphy", Font.BOLD,18));
        add(tbhead);
        
        tbdesc = new JLabel("A small room for families");
        tbdesc.setBounds(80, -20, 400, 400);
        tbdesc.setFont(new Font("Lucida Handwriting", Font.ITALIC,14));
        add(tbdesc);
        
        tbdeta = new JLabel("Available on second floors and third floors.");
        tbdeta.setBounds(80, 0, 400, 400);
        tbdeta.setFont(new Font("Lucida Handwriting", Font.PLAIN, 14));
        add(tbdeta);
        
        tbprice = new JLabel("1825.00 php/per night");
        tbprice.setBounds(80, 80, 400, 400);
        tbprice.setFont(new Font("Lucida Sans", Font.PLAIN, 25));
        add(tbprice);
        
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

