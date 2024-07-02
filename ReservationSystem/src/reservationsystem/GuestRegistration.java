package reservationsystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;


/**
 * Guest Registration Frame
 * Author: Insorio
 */
public class GuestRegistration extends JFrame implements ActionListener {
    private JLabel lblTitle, lbluser, lblpass, lblconfirmpass, lblFirstName, lblLastName, lblEmail,bg;
    private JTextField txtuser, txtFirstName, txtLastName, txtEmail;
    private JPasswordField txtpass, txtconfirmpass;
    private JButton btnsignup, btnback;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotelreservation";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";
    
    public GuestRegistration() {
        setTitle("Guest Registration");
        setLayout(null);
        setSize(700, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(100, 50, 500, 300);
        
        lblTitle = new JLabel("Sign-Up");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitle.setBounds(200, 30, 150, 30);
          lblTitle.setForeground(Color.WHITE);
        
        lbluser = new JLabel("Username");
        lbluser.setBounds(100, 80, 100, 30);
        lbluser.setForeground(Color.WHITE);
        
         txtuser = new JTextField();
        txtuser.setBounds(250, 80, 150, 30);
        
        lblpass = new JLabel("Password");
        lblpass.setBounds(100, 130, 100, 30);
          lblpass.setForeground(Color.WHITE);
        
        txtpass = new JPasswordField();
        txtpass.setBounds(250, 130, 150, 30);
        
        lblconfirmpass = new JLabel("Confirm Password");
        lblconfirmpass.setBounds(100, 180, 150, 30);
       lblconfirmpass.setForeground(Color.WHITE);
        
        txtconfirmpass = new JPasswordField();
        txtconfirmpass.setBounds(250, 180, 150, 30);

        lblFirstName = new JLabel("First Name");
        lblFirstName.setBounds(100, 230, 100, 30);
          lblFirstName.setForeground(Color.WHITE);
        
        txtFirstName = new JTextField();
        txtFirstName.setBounds(250, 230, 150, 30);

        lblLastName = new JLabel("Last Name");
        lblLastName.setBounds(100, 280, 100, 30);
         lblLastName.setForeground(Color.WHITE);
        
        txtLastName = new JTextField();
        txtLastName.setBounds(250, 280, 150, 30);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(100, 330, 100, 30);
         lblEmail.setForeground(Color.WHITE);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(250, 330, 150, 30);
        
        btnsignup = new JButton("Sign-Up");
        btnsignup.setBounds(200, 380, 100, 30);
        btnsignup.setFont(new Font("Arial", Font.BOLD, 15));
        
        btnback = new JButton("Back");
        btnback.setBounds(320, 380, 100, 30);
        btnback.setFont(new Font("Arial", Font.BOLD, 15));
        
        btnsignup.addActionListener(this);
        btnback.addActionListener(this);
        
        add(lblTitle);
        add(lbluser);
        add(txtuser);
        add(lblpass);
        add(txtpass);
        add(lblconfirmpass);
        add(txtconfirmpass);
        add(lblFirstName);
        add(txtFirstName);
        add(lblLastName);
        add(txtLastName);
        add(lblEmail);
        add(txtEmail);
        add(btnsignup);
        add(btnback);
        add(bg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnsignup) {
            String username = txtuser.getText();
            String password = new String(txtpass.getPassword());
            String confirmpass = new String(txtconfirmpass.getPassword());
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();
            
            if (password.equals(confirmpass)) {
                if (registerUser(username, password, firstName, lastName, email)) {
                    JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new Login(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnback) {
            dispose();
            new Login(); 
        }
    }

    private boolean registerUser(String username, String password, String firstName, String lastName, String email) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root","12345");
           
            String sql = "INSERT INTO guests (username, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstName);
            pstmt.setString(4, lastName);
            pstmt.setString(5, email);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}