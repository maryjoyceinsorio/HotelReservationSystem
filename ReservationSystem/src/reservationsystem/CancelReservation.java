/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

/**
 *
 * @author user
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelReservation extends JFrame implements ActionListener {

    private JLabel lblName;
    private JTextField txtName;
    private JButton btnCancel;
    private JButton btnHome;
    private JTextArea resultArea;
    

    private Connection connection;

    public CancelReservation() {
        setTitle("Cancel Reservation");
        setSize(500, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);


        lblName = new JLabel("Reservation Name:");
        lblName.setBounds(50, 50, 150, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(200, 50, 200, 25);
        add(txtName);

        btnCancel = new JButton("Cancel Reservation");
        btnCancel.setBounds(50, 100, 350, 30);
        btnCancel.addActionListener(this);
        add(btnCancel);

        btnHome = new JButton("Go to Homepage");
        btnHome.setBounds(50, 150, 350, 30);
        btnHome.addActionListener(this);
        add(btnHome);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 200, 400, 200);
        resultArea.setEditable(false);
        add(resultArea);

        connectToDatabase(); 
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/hotelreservation?zeroDateTimeBehavior=convertToNull"; // Replace with your DB name
            String user = "root"; 
            String password = "123456"; 

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }
    }

    private boolean cancelReservation(String name) {
        String sql = "DELETE FROM reservations WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to cancel reservation.");
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCancel) {
            String name = txtName.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a reservation name.");
                return;
            }

            boolean isCancelled = cancelReservation(name);

            if (isCancelled) {
                resultArea.setText("Reservations with the name '" + name + "' have been successfully cancelled.");
            } else {
                resultArea.setText("No reservations found with the name '" + name + "'.");
            }
        } else if (e.getSource() == btnHome) {
            Homepage homepage = new Homepage();  
            homepage.setVisible(true);
            this.dispose();
        }
    }

    
}
