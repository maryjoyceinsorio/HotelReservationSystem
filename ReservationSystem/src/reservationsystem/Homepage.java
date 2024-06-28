package reservationsystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnReservationAreaHeader, btnTypesOfRoom, btnRoomSearch;

    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
         getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(150, 20, 500, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(20.0f));
        add(lblWelcome);

        btnReservationAreaHeader = new JButton("Reservation Area");
        btnReservationAreaHeader.setBounds(150, 70, 150, 30);
        btnReservationAreaHeader.addActionListener(this);
        add(btnReservationAreaHeader);

        btnTypesOfRoom = new JButton("Types of Room");
        btnTypesOfRoom.setBounds(325, 70, 150, 30);
        btnTypesOfRoom.addActionListener(this);
        add(btnTypesOfRoom);

        btnRoomSearch = new JButton("Room Search");
        btnRoomSearch.setBounds(500, 70, 150, 30);
        btnRoomSearch.addActionListener(this);
        add(btnRoomSearch);

        String[] columnNames = {"Name", "Contact", "Check-In", "Check-Out", "Room Type"};
        Object[][] data = {
                {"John Doe", "123456789", "2024-01-01", "2024-01-05", "Single"},
                {"Jane Smith", "987654321", "2024-01-02", "2024-01-06", "Double"},
                {"Bob Johnson", "456789123", "2024-01-03", "2024-01-07", "Suite"}
        };

        tableModel = new DefaultTableModel(data, columnNames);
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

        setVisible(true);
    }

    public Object[][] getReservations() {
        int rowCount = tableModel.getRowCount();
        int columnCount = tableModel.getColumnCount();
        Object[][] reservations = new Object[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                reservations[i][j] = tableModel.getValueAt(i, j);
            }
        }
        return reservations;
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
    } else if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();

            int selectedRow = table.getSelectedRow();
            switch (buttonText) {
                case "Update":
                    if (selectedRow != -1) {
                        String newName = JOptionPane.showInputDialog(this, "Enter new name:", tableModel.getValueAt(selectedRow, 0));
                        if (newName != null && !newName.trim().isEmpty()) {
                            tableModel.setValueAt(newName, selectedRow, 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to update");
                    }
                    break;

                case "Delete":
                    if (selectedRow != -1) {
                        tableModel.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a row to delete");
                    }
                    break;

                case "Add":
                    String name = JOptionPane.showInputDialog(this, "Enter Name:");
                    String contact = JOptionPane.showInputDialog(this, "Enter Contact:");
                    String checkIn = JOptionPane.showInputDialog(this, "Enter Check-In Date:");
                    String checkOut = JOptionPane.showInputDialog(this, "Enter Check-Out Date:");
                    String roomType = JOptionPane.showInputDialog(this, "Enter Room Type:");

                    if (name != null && contact != null && checkIn != null && checkOut != null && roomType != null
                            && !name.trim().isEmpty() && !contact.trim().isEmpty() && !checkIn.trim().isEmpty()
                            && !checkOut.trim().isEmpty() && !roomType.trim().isEmpty()) {
                        tableModel.addRow(new Object[]{name, contact, checkIn, checkOut, roomType});
                    } else {
                        JOptionPane.showMessageDialog(this, "Please fill all fields");
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Homepage::new);
    }
}