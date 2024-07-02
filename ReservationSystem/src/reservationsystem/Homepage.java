package reservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homepage extends JFrame implements ActionListener {
    private JLabel bg;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnReservationAreaHeader, btnTypesOfRoom, btnRoomSearch, btnCancelReservation;

    private final String url = "jdbc:mysql://localhost:3306/hotelreservation";
    private final String dbUser = "root";
    private final String dbPassword = "12345"; 

    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(200, 100, 500, 300);

        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(150, 20, 500, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(20.0f));
        lblWelcome.setForeground(Color.WHITE);
        add(lblWelcome);

        btnReservationAreaHeader = new JButton("Reservation Area");
        btnReservationAreaHeader.setBounds(90, 70, 150, 30);
        btnReservationAreaHeader.addActionListener(this);
        add(btnReservationAreaHeader);

        btnTypesOfRoom = new JButton("Types of Room");
        btnTypesOfRoom.setBounds(260, 70, 150, 30);
        btnTypesOfRoom.addActionListener(this);
        add(btnTypesOfRoom);

        btnRoomSearch = new JButton("Room Search");
        btnRoomSearch.setBounds(420, 70, 150, 30);
        btnRoomSearch.addActionListener(this);
        add(btnRoomSearch);

        btnCancelReservation = new JButton("Cancel Reservation");
        btnCancelReservation.setBounds(590, 70, 150, 30);
        btnCancelReservation.addActionListener(this);
        add(btnCancelReservation);

        String[] columnNames = {"Name", "Contact", "Check-In", "Check-Out", "Room Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 150, 600, 200);
        add(scrollPane);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(150, 400, 150, 30);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        btnUpdate.addActionListener(this);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(325, 400, 150, 30);
        btnDelete.addActionListener(this);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnDelete);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(500, 400, 150, 30);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
        btnAdd.addActionListener(this);
        add(btnAdd);
        add(bg);
      
        loadReservations();

        setVisible(true);
    }

    private void loadReservations() {
        String query = "SELECT name, contact_number, check_in_date, check_out_date, room_type FROM reservations";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            tableModel.setRowCount(0); 

            while (rs.next()) {
                String name = rs.getString("name");
                String contact = rs.getString("contact_number");
                Date checkInDate = rs.getDate("check_in_date");
                Date checkOutDate = rs.getDate("check_out_date");
                String roomType = rs.getString("room_type");

                tableModel.addRow(new Object[]{
                    name,
                    contact,
                    new SimpleDateFormat("yyyy-MM-dd").format(checkInDate),
                    new SimpleDateFormat("yyyy-MM-dd").format(checkOutDate),
                    roomType
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addReservation(String name, String contact, Date checkInDate, Date checkOutDate, String roomType) {
        String query = "INSERT INTO reservations (name, contact_number, check_in_date, check_out_date, room_type) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, contact);
            stmt.setDate(3, new java.sql.Date(checkInDate.getTime()));
            stmt.setDate(4, new java.sql.Date(checkOutDate.getTime()));
            stmt.setString(5, roomType);

            stmt.executeUpdate();
            loadReservations(); 

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateReservation(int rowIndex, String name, String contact, Date checkInDate, Date checkOutDate, String roomType) {
        String query = "UPDATE reservations SET name = ?, contact_number = ?, check_in_date = ?, check_out_date = ?, room_type = ? WHERE name = ? AND contact_number = ? AND check_in_date = ? AND check_out_date = ? AND room_type = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, contact);
            stmt.setDate(3, new java.sql.Date(checkInDate.getTime()));
            stmt.setDate(4, new java.sql.Date(checkOutDate.getTime()));
            stmt.setString(5, roomType);
            
            stmt.setString(6, (String) tableModel.getValueAt(rowIndex, 0));
            stmt.setString(7, (String) tableModel.getValueAt(rowIndex, 1));
            stmt.setDate(8, java.sql.Date.valueOf((String) tableModel.getValueAt(rowIndex, 2)));
            stmt.setDate(9, java.sql.Date.valueOf((String) tableModel.getValueAt(rowIndex, 3)));
            stmt.setString(10, (String) tableModel.getValueAt(rowIndex, 4));

            stmt.executeUpdate();
            loadReservations(); 

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteReservation(int rowIndex) {
        String query = "DELETE FROM reservations WHERE name = ? AND contact_number = ? AND check_in_date = ? AND check_out_date = ? AND room_type = ?";

       try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelreservation", "root", "12345");
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, (String) tableModel.getValueAt(rowIndex, 0));
            stmt.setString(2, (String) tableModel.getValueAt(rowIndex, 1));
            stmt.setDate(3, java.sql.Date.valueOf((String) tableModel.getValueAt(rowIndex, 2)));
            stmt.setDate(4, java.sql.Date.valueOf((String) tableModel.getValueAt(rowIndex, 3)));
            stmt.setString(5, (String) tableModel.getValueAt(rowIndex, 4));

            stmt.executeUpdate();
            loadReservations(); 

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReservationAreaHeader) {
            new HotelReservation().setVisible(true);
            dispose();
        } else if (e.getSource() == btnRoomSearch) {
            new SEARCH77().setVisible(true);
            dispose();
        } else if (e.getSource() == btnTypesOfRoom) {
            new ROOMS().setVisible(true);
            dispose();
        } else if (e.getSource() == btnCancelReservation) {
            new CancelReservation().setVisible(true);
            dispose();
        } else if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();

            int selectedRow = table.getSelectedRow();
            switch (buttonText) {
                case "Update":
                    if (selectedRow != -1) {
                        String name = JOptionPane.showInputDialog(this, "Enter new name:", tableModel.getValueAt(selectedRow, 0));
                        String contact = JOptionPane.showInputDialog(this, "Enter new contact:", tableModel.getValueAt(selectedRow, 1));
                        String checkInStr = JOptionPane.showInputDialog(this, "Enter new check-in date (YYYY-MM-DD):", tableModel.getValueAt(selectedRow, 2));
                        String checkOutStr = JOptionPane.showInputDialog(this, "Enter new check-out date (YYYY-MM-DD):", tableModel.getValueAt(selectedRow, 3));
                        String roomType = JOptionPane.showInputDialog(this, "Enter new room type:", tableModel.getValueAt(selectedRow, 4));

                        try {
                            Date checkInDate = java.sql.Date.valueOf(checkInStr);
                            Date checkOutDate = java.sql.Date.valueOf(checkOutStr);

                            updateReservation(selectedRow, name, contact, checkInDate, checkOutDate, roomType);
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to update");
                    }
                    break;

                case "Delete":
                    if (selectedRow != -1) {
                        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this reservation?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            deleteReservation(selectedRow);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to delete");
                    }
                    break;

                case "Add":
                    String name = JOptionPane.showInputDialog(this, "Enter Name:");
                    String contact = JOptionPane.showInputDialog(this, "Enter Contact:");
                    String checkInStr = JOptionPane.showInputDialog(this, "Enter Check-In Date (YYYY-MM-DD):");
                    String checkOutStr = JOptionPane.showInputDialog(this, "Enter Check-Out Date (YYYY-MM-DD):");
                    String roomType = JOptionPane.showInputDialog(this, "Enter Room Type:");

                    try {
                        Date checkInDate = java.sql.Date.valueOf(checkInStr);
                        Date checkOutDate = java.sql.Date.valueOf(checkOutStr);

                        addReservation(name, contact, checkInDate, checkOutDate, roomType);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
    }

   
}
