package reservationsystem;



import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * Login Frame
 * Author: Insorio
 */
public class Login extends JFrame implements ActionListener {

    private JLabel lbllog, lbluser, lblpass, bg;
    private JTextField txtuser;
    private JPasswordField pass;
    private JButton btnlogin, btnback;

    public Login() {
        setTitle("Guest LogIn");
        setLayout(null);
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(100, 10, 500, 300);

        lbllog = new JLabel("Login");
        lbllog.setBounds(250, 20, 100, 30);
           lbllog.setForeground(Color.WHITE);

        lbluser = new JLabel("Username");
        lbluser.setBounds(100, 80, 100, 30);
        lbluser.setForeground(Color.WHITE);
        txtuser = new JTextField();
        txtuser.setBounds(250, 80, 150, 30);

        lblpass = new JLabel("Password");
        lblpass.setBounds(100, 130, 100, 30);
        lblpass.setForeground(Color.WHITE);
        pass = new JPasswordField();
        pass.setBounds(250, 130, 150, 30);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(200, 200, 100, 30);
        btnlogin.setFont(new Font("Arial", Font.BOLD, 15));

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
        add(bg);
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
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnback) {
            new GuestRegistration().setVisible(true);
            dispose();
        }
    }

    private boolean validateLogin(String username, String password) {
        boolean isValid = false;
        String url = "jdbc:mysql://localhost:3306/hotelreservation";
        String dbUser = "root"; 
        String dbPassword = "12345"; 

        String query = "SELECT * FROM guests WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return isValid;
    }

    public static void main(String[] args) {
        new Login();
    }
}
