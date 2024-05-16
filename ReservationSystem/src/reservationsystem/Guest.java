
package reservationsystem;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Guest  {
   
    private JFrame f = new JFrame("Welcome to Hotel Reservation System");
    private JLabel  lblhotel,lblName, lbladdress, lblemail, lblContactNumber,lblcheckin, lblcheckout,  lblNextResult;
    
    private JTextField txtfldName = new JTextField();
    private JTextField txtfldaddress = new JTextField();
    private JTextField txtfldemail= new JTextField();
    private JTextField txtfldContactNumber = new JTextField();
    private JTextField txtfldckin = new JTextField();
    private JTextField txtfldckout = new JTextField();
    private JTextField txtfldNextResult = new JTextField();
    
    private JButton btnproceed;
    private JTextArea txtareaNextResult = new JTextArea();
    
    Guest(){
        f.setSize(550, 500);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
       lblName = new JLabel("Guest Name");
       lblName.setBounds(20, 60, 160, 30);
       lblName.setFont(new Font("Arial", Font.PLAIN, 13));
       
       txtfldName.setBounds(120, 60, 250, 25);
       txtfldName.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lbladdress = new JLabel("Address");
       lbladdress.setBounds(20, 90, 160, 30);
       lbladdress.setFont(new Font("Arial", Font.PLAIN, 13));
       
       txtfldaddress.setBounds(120, 90, 250, 25);
       txtfldaddress.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblemail = new JLabel("Email");
       lblemail.setBounds(20, 120, 160, 30);
       lblemail.setFont(new Font("Arial", Font.PLAIN, 13));
       
       txtfldemail.setBounds(120, 120, 250, 25);
       txtfldemail.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblContactNumber = new JLabel("Contact Number");
       lblContactNumber.setBounds(20, 150, 160, 30);
       lblContactNumber.setFont(new Font("Arial", Font.PLAIN, 13)); 
       
       txtfldContactNumber.setBounds(120, 155, 250, 25);
       txtfldContactNumber.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblcheckin = new JLabel("Check-In");
       lblcheckin.setBounds(20, 180, 160, 30);
       lblcheckin.setFont(new Font("Arial", Font.PLAIN, 13)); 
       
       txtfldckin.setBounds(120, 185, 250, 25);
       txtfldckin.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblcheckout = new JLabel("Check-Out");
       lblcheckout.setBounds(20, 210, 160, 30);
       lblcheckout.setFont(new Font("Arial", Font.PLAIN, 13)); 
       
       txtfldckout.setBounds(120, 215, 250, 25);
       txtfldckout.setFont(new Font("Arial", Font.PLAIN, 15));
       
       
       btnproceed = new JButton("Proceed");
       btnproceed.setBounds(270, 300, 100, 30);
       btnproceed.setFont(new Font("Arial", Font.PLAIN, 15));
       
       
       
       lblNextResult = new JLabel("");
       lblNextResult.setBounds(20, 300, 480, 30);
       lblNextResult.setFont(new Font("Arial", Font.PLAIN, 15)); 
       
       txtfldNextResult.setBounds(200, 300, 150, 30);
       txtfldNextResult.setFont(new Font("Arial", Font.PLAIN, 20));
       
       
       
       
       f.add(btnproceed);
       f.add(txtfldName);
       f.add(lblName);
       f.add(txtfldemail);
       f.add(lbladdress);
       f.add(txtfldaddress);
       f.add(lblemail);
       f.add(lblemail);
       f.add(txtfldContactNumber);
       f.add(lblContactNumber);
       f.add(lblin);
       f.add(txtfldin);
       f.add(lblout);
       f.add(txtfldout);
       f.add(txtareaNextResult);
       f.add(lblNextResult);
       
       f.setVisible(true);
       f.setResizable(false);
       
       
    }

   
    
}

