
package reservationsystem;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Payment {
 private JLabel lblmethod;
 private JFrame f = new JFrame("Process Payment");
 private JButton btnCredit, btnQR, btnDebit, btnPaymaya;
 
 Payment(){
     f.setSize(400, 350);
     f.setLayout(null);
     f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
     
     
     
     lblmethod = new JLabel("Select payment method");
     lblmethod.setBounds(20, 70, 160, 30);
     lblmethod.setFont(new Font("Arial", Font.PLAIN, 15));
     
     btnCredit= new JButton("Credit Card");
     btnCredit.setBounds(20, 100, 140, 25);
     btnCredit.setFont(new Font("Arial", Font.PLAIN,13));
     
     btnQR= new JButton("QR Code");
     btnQR.setBounds(20, 150, 140, 25);
     btnQR.setFont(new Font("Arial", Font.PLAIN,13));
     
     btnDebit= new JButton("Debit Card");
     btnDebit.setBounds(180, 100, 140, 25);
     btnDebit.setFont(new Font("Arial", Font.PLAIN,13));
     
     
     btnPaymaya= new JButton("Paymaya");
     btnPaymaya.setBounds(180, 150, 140, 25);
     btnPaymaya.setFont(new Font("Arial", Font.PLAIN,13));
     
     
  
     f.add(lblmethod);
     f.add(btnCredit);
     f.add(btnQR);
     f.add(btnDebit);
     f.add(btnPaymaya);
     f.setVisible(true);
     f.setResizable(false);
 }

 }
    


