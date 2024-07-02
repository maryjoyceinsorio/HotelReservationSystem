/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RoomTypes extends JFrame implements ActionListener {

    private Container container;
    private JLabel lbltitle, lblroomType, bg;
    private JComboBox<String> roomTypeComboBox;
    private JButton btnReviewReservation, btnPayment;
    private JTextArea reservationTextArea;
    private Map<String, Integer> roomPrices;
    private String customerName, contactNumber;
    private Date checkInDate, checkOutDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public RoomTypes(String name, Date checkInDate, Date checkOutDate, String contactNumber) {
        this.customerName = name;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.contactNumber = contactNumber;

        initializeUI();
        setupComponents();
        setupRoomPrices();
        setVisible(true);
    }

    private void initializeUI() {
        setTitle("Hotel Room Type Selection");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container = getContentPane();
        container.setLayout(new BorderLayout());
         getContentPane().setBackground(Color.BLACK);
        
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(100, 100, 500, 300);
        
    }

    private void setupComponents() {
       setLayout(null);

        lbltitle = new JLabel("Select Room Type");
        lbltitle.setFont(new Font("Arial", Font.BOLD, 24));
        lbltitle.setBounds(200, 30, 250, 30);
        lbltitle.setForeground(Color.WHITE);
        add(lbltitle);

        lblroomType = new JLabel("Room Type:");
        lblroomType.setFont(new Font("Arial", Font.PLAIN, 18));
        lblroomType.setBounds(50, 80, 100, 20);
        lblroomType.setForeground(Color.WHITE);
        add(lblroomType);
         
        roomTypeComboBox = new JComboBox<>(new String[]{"Suite", "Two-person Room", "Balcony Room", 
            "Family Suite", "Deluxe Room", "Superior Deluxe Suite", "Executive Suite", "Family Deluxe Suite"});
        roomTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        roomTypeComboBox.setBounds(150, 80, 200, 25);
        add(roomTypeComboBox);

        btnReviewReservation = new JButton("Review Reservation");
        btnReviewReservation.setFont(new Font("Arial", Font.PLAIN, 18));
        btnReviewReservation.setBounds(50, 130, 220, 25);
        btnReviewReservation.addActionListener(this);
        add(btnReviewReservation);

        btnPayment = new JButton("Payment");
        btnPayment.setFont(new Font("Arial", Font.PLAIN, 18));
        btnPayment.setBounds(280, 130, 150, 25);
        btnPayment.addActionListener(this);
        add(btnPayment);

        reservationTextArea = new JTextArea();
        reservationTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        reservationTextArea.setBounds(50, 180, 500, 250);
        reservationTextArea.setEditable(false);
        add(reservationTextArea);

       
        add(bg);
    }

    private void setupRoomPrices() {
        roomPrices = new HashMap<>();

        roomPrices.put("Standard Room", 970);
        roomPrices.put("Two-person Room", 1140);
        roomPrices.put("Balcony Room", 1045);
        roomPrices.put("Family Suite", 1825);
        roomPrices.put("Deluxe Room", 2045);
        roomPrices.put("Superior Deluxe Suite", 2585);
        roomPrices.put("Executive Suite", 2885);
        roomPrices.put("Family Deluxe Suite", 2985);

        fetchRoomPrices();

        roomTypeComboBox.setModel(new DefaultComboBoxModel<>(roomPrices.keySet().toArray(new String[0])));
    }

    private void fetchRoomPrices() {
        String url = "jdbc:mysql://localhost:3306/hotelreservation";
        String dbUser = "root"; 
        String dbPassword = "12345"; 

        String query = "SELECT room_type, price FROM room_prices"; 

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String roomType = rs.getString("room_type");
                int price = rs.getInt("price");
                roomPrices.put(roomType, price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReviewReservation) {
            String selectedRoomType = (String) roomTypeComboBox.getSelectedItem();
            int price = roomPrices.get(selectedRoomType);
            displayReservationDetails(selectedRoomType, price);
        } else if (e.getSource() == btnPayment) {
            String selectedRoomType = (String) roomTypeComboBox.getSelectedItem();
            int price = roomPrices.get(selectedRoomType);
            if (insertReservationToDB(selectedRoomType, price)) {
                openPaymentWindow(price);
            } else {
                JOptionPane.showMessageDialog(this, "Error saving reservation. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void displayReservationDetails(String roomType, int price) {
        String reservationDetails = "Reservation Details:\n\n";
        reservationDetails += "Room Type: " + roomType + "\n";
        reservationDetails += "Price: $" + price + "\n";
        reservationDetails += "Name: " + customerName + "\n";
        reservationDetails += "Check-in Date: " + dateFormat.format(checkInDate) + "\n";
        reservationDetails += "Check-out Date: " + dateFormat.format(checkOutDate) + "\n";
        reservationDetails += "Contact Number: " + contactNumber + "\n";

        reservationTextArea.setText(reservationDetails);
    }

    private void openPaymentWindow(int totalAmount) {
        Payment paymentFrame = new Payment(String.format("%.2f", (double) totalAmount));
        paymentFrame.setVisible(true);
        dispose();
    }

    private boolean insertReservationToDB(String roomType, int price) {
        String url = "jdbc:mysql://localhost:3306/hotelreservation";
        String dbUser = "root";
        String dbPassword = "12345"; 

        String query = "INSERT INTO reservations (name, check_in_date, check_out_date, contact_number, room_type, price) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, customerName);
            stmt.setString(2, dateFormat.format(checkInDate));
            stmt.setString(3, dateFormat.format(checkOutDate));
            stmt.setString(4, contactNumber);
            stmt.setString(5, roomType);
            stmt.setInt(6, price);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new reservation was inserted successfully!");
            }
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

  
}
