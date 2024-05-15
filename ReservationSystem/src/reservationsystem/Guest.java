
package reservationsystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Guest implements ActionListener {
   
    private JFrame f = new JFrame("Welcome to Hotel Reservation System");
    private JLabel  lblhotel,lblName, lbladdress, lblemail, lblContactNumber,lblcheckin, lblcheckout, lblroom, lblNextResult;
    
    private JTextField txtfldName = new JTextField();
    private JTextField txtfldaddress = new JTextField();
    private JTextField txtfldemail= new JTextField();
    private JTextField txtfldContactNumber = new JTextField();
    private JTextField txtfldcheckin = new JTextField();
    private JTextField txtfldcheckout = new JTextField();
     private JTextField txtfldroom = new JTextField();
    private JTextField txtfldNextResult = new JTextField();
    
    private JButton btnNew;
    private JTextArea txtareaNextResult = new JTextArea();
    
    Guest(){
        f.setSize(450, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
       lblName = new JLabel("Guest Name:");
       lblName.setBounds(25, 60, 160, 30);
       lblName.setFont(new Font("Arial", Font.PLAIN, 13));
       
       txtfldName.setBounds(120, 60, 250, 25);
       txtfldName.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lbladdress = new JLabel("Address:");
       lbladdress.setBounds(25, 90, 160, 30);
       lbladdress.setFont(new Font("Arial", Font.PLAIN, 13));
       
       txtfldaddress.setBounds(120, 90, 250, 25);
       txtfldaddress.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblemail = new JLabel("Email:");
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
       
       txtfldcheckin.setBounds(120, 185, 250, 25);
       txtfldcheckin.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblcheckout = new JLabel("Check-Out");
       lblcheckout.setBounds(20, 210, 160, 30);
       lblcheckout.setFont(new Font("Arial", Font.PLAIN, 13)); 
       
       txtfldcheckout.setBounds(120, 215, 250, 25);
       txtfldcheckout.setFont(new Font("Arial", Font.PLAIN, 15));
       
       lblroom = new JLabel("Check-Out");
       lblroom.setBounds(20, 240, 160, 30);
       lblroom.setFont(new Font("Arial", Font.PLAIN, 13)); 
       
       txtfldroom.setBounds(120, 235, 250, 25);
       txtfldroom.setFont(new Font("Arial", Font.PLAIN, 15));
       
       btnNew = new JButton("Proceed");
       btnNew.setBounds(270, 250, 100, 30);
       btnNew.setFont(new Font("Arial", Font.PLAIN, 15));
       
       
       
       
       txtfldNextResult.setBounds(200, 300, 150, 30);
       txtfldNextResult.setFont(new Font("Arial", Font.PLAIN, 20));
       
       lblNextResult = new JLabel("");
       lblNextResult.setBounds(20, 300, 480, 30);
       lblNextResult.setFont(new Font("Arial", Font.PLAIN, 15)); 
       
       txtareaNextResult.setEditable(false);
       txtareaNextResult.setLineWrap(true);
       
       f.add(btnNew);
       f.add(txtfldName);
       f.add(lblName);
       f.add(txtfldemail);
       f.add(lbladdress);
       f.add(txtfldaddress);
       f.add(lblemail);
       f.add(lblemail);
       f.add(txtfldContactNumber);
       f.add(lblContactNumber);
       f.add(lblcheckin);
       f.add(txtfldcheckin);
       f.add(lblcheckout);
       f.add(txtfldcheckout);
       f.add(txtareaNextResult);
       f.add(lblNextResult);
       
       f.setVisible(true);
       f.setResizable(false);
       
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
