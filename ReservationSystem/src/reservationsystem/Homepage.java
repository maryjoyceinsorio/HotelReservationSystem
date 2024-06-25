package reservationsystem;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel tableModel;

    private JButton btnReservationAreaHeader;
    private JButton btnTypesOfRoomHeader,btnRoomSearchHeader, btnRoomServiceHeader, btnUpdate, btnDelete, btnAdd;
    



    public Homepage() {
        setTitle("Home Page");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblWelcome = new JLabel("Welcome to Hotel Reservation System");
        lblWelcome.setBounds(200, 50, 400, 30);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(lblWelcome.getFont().deriveFont(20.0f));
        add(lblWelcome);

        btnReservationAreaHeader = addHeaderButton("Reservation Area", 50, 100);
        btnTypesOfRoomHeader = addHeaderButton("Types of Room", 225, 100);
        btnRoomSearchHeader = addHeaderButton("Room Search", 400, 100);
        btnRoomServiceHeader = addHeaderButton("Room Service", 575, 100);

        String[] columnNames = {"Name", "Contact", "Check-In", "Check-Out", "Room Type"};
        Object[][] data = {
            {"John Doe", "123456789", "01-01-2024", "05-01-2024", "Deluxe"},
            {"Jane Smith", "987654321", "02-01-2024", "06-01-2024", "Suite"},
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 150, 600, 200);
        add(scrollPane);

        btnUpdate = addBottomButton("Update", 150, 400);
        btnDelete = addBottomButton("Delete", 325, 400);
        btnAdd = addBottomButton("Add", 500, 400);

        setVisible(true);
    }

    private JButton addHeaderButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 30);
        button.addActionListener(this);
        add(button);
        return button;
    }

    private JButton addBottomButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 30);
        button.addActionListener(this);
        add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();

        if (e.getSource() == btnReservationAreaHeader) {
            new HotelReservation().setVisible(true);
            dispose();
        } else if (e.getSource() == btnTypesOfRoomHeader) {
            new RoomTypes().setVisible(true);
            dispose();
        } else if (e.getSource() == btnRoomSearchHeader) {
            new SEARCH77().setVisible(true);
            dispose();
        } else if (e.getSource() == btnRoomServiceHeader) {
            new RoomService().setVisible(true);
            dispose();
        } else if (e.getSource() == btnUpdate) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String newName = JOptionPane.showInputDialog(this, "Enter new name:", tableModel.getValueAt(selectedRow, 0));
                if (newName != null && !newName.trim().isEmpty()) {
                    tableModel.setValueAt(newName, selectedRow, 0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to update");
            }
        } else if (e.getSource() == btnDelete) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to delete");
            }
        } else if (e.getSource() == btnAdd) {
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
        }
    }

    public static void main(String[] args) {
         new Homepage();
    }
}