package reservationsystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Guest Registration Frame
 * Author: Insorio
 */
public class GuestRegistration extends JFrame implements ActionListener {
    private JLabel lblTitle, lbluser, lblpass, lblconfirmpass;
    private JTextField txtuser;
    private JPasswordField txtpass, txtconfirmpass;
    private JButton btnsignup, btnback;
    
    public GuestRegistration() {
        setTitle("Guest Registration");
        setLayout(null);
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        lblTitle = new JLabel("Sign-Up");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(200, 30, 150, 30);
        
        lbluser = new JLabel("Username");
        lbluser.setBounds(100, 80, 100, 30);
        txtuser = new JTextField();
        txtuser.setBounds(250, 80, 150, 30);
        
        lblpass = new JLabel("Password");
        lblpass.setBounds(100, 130, 100, 30);
        txtpass = new JPasswordField();
        txtpass.setBounds(250, 130, 150, 30);
        
        lblconfirmpass = new JLabel("Confirm Password");
        lblconfirmpass.setBounds(100, 180, 150, 30);
        txtconfirmpass = new JPasswordField();
        txtconfirmpass.setBounds(250, 180, 150, 30);
        
        btnsignup = new JButton("Sign-Up");
        btnsignup.setBounds(200, 250, 100, 30);
        btnback = new JButton("Back");
        btnback.setBounds(320, 250, 100, 30);
        
        btnsignup.addActionListener(this);
        btnback.addActionListener(this);
        
        add(lblTitle);
        add(lbluser);
        add(txtuser);
        add(lblpass);
        add(txtpass);
        add(lblconfirmpass);
        add(txtconfirmpass);
        add(btnsignup);
        add(btnback);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsignup) {
            String username = txtuser.getText();
            String password = new String(txtpass.getPassword());
            String confirmpass = new String(txtconfirmpass.getPassword());
            
            if (password.equals(confirmpass)) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new Login(); 
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnback) {
            dispose();
            new Login(); 
        }
    }
    
    public static void main(String[] args) {
        new GuestRegistration();
    }
}
