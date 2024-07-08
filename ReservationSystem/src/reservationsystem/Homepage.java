package reservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {
    private JLabel bg, lblSuite, lblTwoPersonRoom, lblBalcony, lblFamilySuite, lblDeluxe, lblSuperior, lblExecutive, lblFamily;
    private JButton btnReservationAreaHeader, btnRoomSearch, btnCancelReservation;

    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
       
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)));
        bg.setBounds(0, 0, 800, 600);
        add(bg);

        
        JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 800, 150); 
        headerPanel.setBackground(new Color(0, 102, 204)); 
        headerPanel.setLayout(null);

       
        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(100, 10, 600, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        lblWelcome.setForeground(Color.WHITE);
        headerPanel.add(lblWelcome);

        
        btnReservationAreaHeader = createButton("Reservation Area", 50, 60);
        btnRoomSearch = createButton("Room Search", 300, 60);
        btnCancelReservation = createButton("Cancel Reservation", 550, 60);

        headerPanel.add(btnReservationAreaHeader);
        headerPanel.add(btnRoomSearch);
        headerPanel.add(btnCancelReservation);
        
        add(headerPanel);

        
        JLabel lblRoomAvailable = new JLabel("Discover Your Perfect Stay with Our Exclusive Room Types");
        lblRoomAvailable.setBounds(100, 160, 600, 30);
        lblRoomAvailable.setHorizontalAlignment(SwingConstants.CENTER);
        lblRoomAvailable.setFont(new Font("Arial", Font.BOLD, 18));
        lblRoomAvailable.setForeground(Color.WHITE);
        add(lblRoomAvailable);

        
        int yOffset = 200; 

        lblSuite = createRoomTypeLabel("Suite", 100, yOffset);
        lblTwoPersonRoom = createRoomTypeLabel("Two-Person Room", 100, yOffset + 40);
        lblBalcony = createRoomTypeLabel("Balcony Room", 100, yOffset + 80);
        lblFamilySuite = createRoomTypeLabel("Deluxe Room", 100, yOffset + 120);
        lblDeluxe = createRoomTypeLabel("Family Suite", 100, yOffset + 160);
        lblSuperior = createRoomTypeLabel("Executive Suite", 100, yOffset + 200);
        lblExecutive = createRoomTypeLabel("Superior Deluxe Suite", 100, yOffset + 240);
        lblFamily = createRoomTypeLabel("Family Deluxe Suite", 100, yOffset + 280);

        add(lblSuite);
        add(lblTwoPersonRoom);
        add(lblBalcony);
        add(lblFamilySuite);
        add(lblDeluxe);
        add(lblSuperior);
        add(lblExecutive);
        add(lblFamily);

        setVisible(true);
    }

    private JButton createButton(String text, int xPosition, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(xPosition, yPosition, 200, 40); 
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 102, 204)); 
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    private JLabel createRoomTypeLabel(String roomType, int xPosition, int yPosition) {
        JLabel label = new JLabel(roomType);
        label.setBounds(xPosition, yPosition, 600, 30);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(new Color(0, 102, 204, 150)); // Semi-transparent blue
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReservationAreaHeader) {
            new HotelReservation().setVisible(true);
            dispose();
        } else if (e.getSource() == btnRoomSearch) {
            new SEARCH77().setVisible(true);
            dispose();
        } else if (e.getSource() == btnCancelReservation) {
            new CancelReservation().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new Homepage();
    }
}
