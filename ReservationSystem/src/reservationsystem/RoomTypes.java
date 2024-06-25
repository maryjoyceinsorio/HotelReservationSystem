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
    private JLabel titleLabel, roomTypeLabel;
    private JComboBox<String> roomTypeComboBox;
    private JButton btnPayment;
    
    // Room types and their prices
    private Map<String, Integer> roomPrices;

    public RoomTypes() {
        setTitle("Hotel Room Type Selection");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        titleLabel = new JLabel("Select Room Type");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setSize(200, 30);
        titleLabel.setLocation(100, 30);
        container.add(titleLabel);

        roomTypeLabel = new JLabel("Room Type:");
        roomTypeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        roomTypeLabel.setSize(100, 20);
        roomTypeLabel.setLocation(50, 80);
        container.add(roomTypeLabel);

        // Room types and their prices
        roomPrices = new HashMap<>();
        roomPrices.put("Standard Room", 970);
        roomPrices.put("Two-person Room", 1140);
        roomPrices.put("Balcony Room", 1045);
        roomPrices.put("Family Suite", 1825);
        roomPrices.put("Deluxe Room", 2045);
        roomPrices.put("Superior Deluxe Suite", 2585);
        roomPrices.put("Executive Suite", 2885);
        roomPrices.put("Executive Suite", 2885);
        roomPrices.put("Family Deluxe Suite", 2985);

        roomTypeComboBox = new JComboBox<>(roomPrices.keySet().toArray(new String[0]));
        roomTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        roomTypeComboBox.setSize(200, 20);
        roomTypeComboBox.setLocation(150, 80);
        container.add(roomTypeComboBox);

        btnPayment = new JButton("Payment");
        btnPayment.setFont(new Font("Arial", Font.PLAIN, 15));
        btnPayment.setSize(100, 20);
        btnPayment.setLocation(150, 120);
        btnPayment.addActionListener(this);
        container.add(btnPayment);

        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if(e.getSource() == btnPayment){
            Payment sgf = new Payment();
            sgf.setVisible(true);
}
}
}