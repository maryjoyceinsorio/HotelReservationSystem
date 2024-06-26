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
import java.util.HashMap;
import java.util.Map;

public class RoomTypes extends JFrame implements ActionListener {

    private Container container;
    private JLabel lbltitle, lblroomType;
    private JComboBox<String> roomTypeComboBox;
    private JButton btnReviewReservation, btnPayment;
    private JTextArea reservationTextArea;
    private Map<String, Integer> roomPrices;
    private String customerName, checkInDate, checkOutDate, contactNumber;
   

    public RoomTypes(String name, String checkIn, String checkOut, String contact) {
        this.customerName = name;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        this.contactNumber = contact;

        initializeUI();
        setupComponents();
        setupRoomPrices();
        setVisible(true);
    }

    RoomTypes() {}

    private void initializeUI() {
        setTitle("Hotel Room Type Selection");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(new BorderLayout());

        
         container.setBackground(new Color(215, 230, 243));  
    }

    private void setupComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null); 

       lbltitle = new JLabel("Select Room Type");
        lbltitle.setFont(new Font("Arial", Font.BOLD, 24));
        lbltitle.setBounds(200, 30, 250, 30); 

       lblroomType = new JLabel("Room Type:");
       lblroomType.setFont(new Font("Arial", Font.PLAIN, 18));
       lblroomType.setBounds(50, 80, 100, 20);
        mainPanel.add(lblroomType);

        roomTypeComboBox = new JComboBox<>();
        roomTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        roomTypeComboBox.setBounds(150, 80, 200, 25);
        mainPanel.add(roomTypeComboBox);

        btnReviewReservation = new JButton("Review Reservation");
        btnReviewReservation.setFont(new Font("Arial", Font.PLAIN, 18)); 
        btnReviewReservation.setBounds(50, 130, 220, 35);
        btnReviewReservation.addActionListener(this);
        mainPanel.add(btnReviewReservation);

        btnPayment = new JButton("Payment");
        btnPayment.setFont(new Font("Arial", Font.PLAIN, 18)); 
        btnPayment.setBounds(280, 130, 150, 35); 
        btnPayment.addActionListener(this);
        mainPanel.add(btnPayment);

        reservationTextArea = new JTextArea();
        reservationTextArea.setFont(new Font("Arial", Font.PLAIN, 16)); 
        reservationTextArea.setBounds(50, 180, 500, 250);
        reservationTextArea.setEditable(false);
        mainPanel.add(reservationTextArea);

        container.add(mainPanel, BorderLayout.CENTER);
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
 
        roomTypeComboBox.setModel(new DefaultComboBoxModel<>(roomPrices.keySet().toArray(new String[0])));
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
            openPaymentWindow(price);
        }
    }

    private void displayReservationDetails(String roomType, int price) {
        String reservationDetails = "Reservation Details:\n\n";
        reservationDetails += "Room Type: " + roomType + "\n";
        reservationDetails += "Price: $" + price + "\n";
        reservationDetails += "Name: " + customerName + "\n";
        reservationDetails += "Check-in Date: " + checkInDate + "\n";
        reservationDetails += "Check-out Date: " + checkOutDate + "\n";
        reservationDetails += "Contact Number: " + contactNumber + "\n";

        reservationTextArea.setText(reservationDetails);
    }
 
    private void openPaymentWindow(int totalAmount) {
        Payment paymentFrame = new Payment(String.format("%.2f", (double) totalAmount));
        paymentFrame.setVisible(true);
        dispose();
    }
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RoomTypes roomTypes = new RoomTypes("John Doe", "2024-07-01", "2024-07-05", "1234567890");
        });
    }
}