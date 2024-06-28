package reservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Login Frame
 * Author: Insorio
 */
public class Login extends JFrame implements ActionListener {
    
    private JLabel lbllog, lbluser, lblpass;
    private JTextField txtuser;
    private JPasswordField pass;
    private JButton btnlogin, btnback;
    
    public Login(){
        setTitle("Guest LogIn");
        setLayout(null);
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    
        lbllog = new JLabel("Login");
        lbllog.setBounds(250, 20, 100, 30);
        
        lbluser = new JLabel("Username");
        lbluser.setBounds(100, 80, 100, 30);
        txtuser = new JTextField();
        txtuser.setBounds(250, 80, 150, 30);
        
        lblpass = new JLabel("Password");
        lblpass.setBounds(100, 130, 100, 30);
        pass = new JPasswordField();
        pass.setBounds(250, 130, 150, 30);
        
        btnlogin = new JButton("Login");
        btnlogin.setBounds(200, 200, 100, 30);
        btnlogin.setFont(new Font("Arial", Font.BOLD,15));
        
        btnback = new JButton("Back");
        btnback.setBounds(320, 200, 100, 30);
         btnback.setFont(new Font("Arial", Font.BOLD, 15));
       
                
        
        btnlogin.addActionListener(this);
        btnback.addActionListener(this);
        
        add(lbllog);
        add(lbluser);
        add(txtuser);
        add(lblpass);
        add(pass);
        add(btnlogin);
        add(btnback);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnlogin) {
            String username = txtuser.getText();
            String password = new String(pass.getPassword());
            

            if (validateLogin(username, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                
                dispose(); 
             
                new Homepage().setVisible(true); 
            } else if(e.getSource() == btnback){
            
             new GuestRegistration();
                dispose();
            }
              
            else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            new GuestRegistration().setVisible(true);
            
            dispose();
            }
        }
    }

    private boolean validateLogin(String username, String password) {
      
        return "user".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}


   