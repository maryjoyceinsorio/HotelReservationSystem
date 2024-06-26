package reservationsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homepage extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton btnReservationAreaHeader, btnTypesOfRoom, btnRoomSearch, btnRoomService;

    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(150, 20, 500, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblWelcome);

        btnReservationAreaHeader = new JButton("Reservation Area");
        btnReservationAreaHeader.setBounds(50, 70, 150, 30);
        btnReservationAreaHeader.addActionListener(this);
        add(btnReservationAreaHeader);
  
        btnTypesOfRoom = new JButton("Types of Room");
        btnTypesOfRoom.setBounds(225, 70, 150, 30);
        btnTypesOfRoom.addActionListener(this);
        add(btnTypesOfRoom);

        btnRoomSearch = new JButton("Room Search");
        btnRoomSearch.setBounds(400, 70, 150, 30);
        btnRoomSearch.addActionListener(this);
        add(btnRoomSearch);

        btnRoomService = new JButton("Room Service");
        btnRoomService.setBounds(575, 70, 150, 30);
        btnRoomService.addActionListener(this);
        add(btnRoomService);

        String[] columnNames = {"Name", "Contact", "Check-In", "Check-Out", "Room Type"};
        Object[][] data = {
                {"John Doe", "123456789", "01-01-2024", "05-01-2024", "Deluxe"},
                {"Jane Smith", "987654321", "02-01-2024", "06-01-2024", "Suite"},
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 150, 600, 200);
        add(scrollPane);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(150, 400, 150, 30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(325, 400, 150, 30);
        btnDelete.addActionListener(this);
        add(btnDelete);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(500, 400, 150, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);

        
        getContentPane().setBackground(new Color(215, 230, 243)); 

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btnReservationAreaHeader) {
            new HotelReservation().setVisible(true);
            dispose();
        } else if (source == btnTypesOfRoom) {
            new RoomTypes().setVisible(true);
            dispose();
        } else if (source == btnRoomSearch) {
            new SEARCH77().setVisible(true);
            dispose();
        } else if (source == btnRoomService) {
            new RoomService().setVisible(true);
            dispose();
        } else if (source instanceof JButton) {
            JButton clickedButton = (JButton) source;
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
