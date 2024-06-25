/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class reservation extends JFrame implements ActionListener {

    private JLabel lblReservationDetails, lblCheckIn, lblCheckOut,lblRoomType;
    private JTextField txtCheckIn, txtCheckOut;
    private JComboBox<String> comboRoomType;
    private JButton btnSearch,btnReserve;
    
    
    public reservation () {
        setTitle("Reservation Area");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        lblReservationDetails = new JLabel("Reservation Details");
        lblReservationDetails.setBounds(20, 20, 150, 25);
        add(lblReservationDetails);
        
        lblCheckIn = new JLabel("Check-in Date:");
        lblCheckIn.setBounds(20, 60, 100, 25);
        add(lblCheckIn);
        
        txtCheckIn = new JTextField();
        txtCheckIn.setBounds(130, 60, 120, 25);
        add(txtCheckIn);
        
        lblCheckOut = new JLabel("Check-out Date:");
        lblCheckOut.setBounds(20, 100, 100, 25);
        add(lblCheckOut);
        
        txtCheckOut = new JTextField();
        txtCheckOut.setBounds(130, 100, 120, 25);
        add(txtCheckOut);
        
        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(20, 140, 100, 25);
        add(lblRoomType);
        
        String[] roomTypes = {"Single", "Double", "Suite"};
        comboRoomType = new JComboBox<>(roomTypes);
        comboRoomType.setBounds(130, 140, 120, 25);
        add(comboRoomType);
        
        btnSearch = new JButton("Search Rooms");
        btnSearch.setBounds(280, 60, 150, 25);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        btnReserve = new JButton("Reserve Room");
        btnReserve.setBounds(280, 100, 150, 25);
        btnReserve.addActionListener(this);
        add(btnReserve);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            
            String checkInDate = txtCheckIn.getText();
            String checkOutDate = txtCheckOut.getText();
            String selectedRoomType = (String) comboRoomType.getSelectedItem();
            
            JOptionPane.showMessageDialog(this, "Searching rooms...\n"
                    + "Check-in: " + checkInDate + "\n"
                    + "Check-out: " + checkOutDate + "\n"
                    + "Room Type: " + selectedRoomType);
            
        } else if (e.getSource() == btnReserve) {
            
            String checkInDate = txtCheckIn.getText();
            String checkOutDate = txtCheckOut.getText();
            String selectedRoomType = (String) comboRoomType.getSelectedItem();
            
            JOptionPane.showMessageDialog(this, "Reserving room...\n"
                    + "Check-in: " + checkInDate + "\n"
                    + "Check-out: " + checkOutDate + "\n"
                    + "Room Type: " + selectedRoomType);
            
            
            SEARCH77 s = new SEARCH77();
            s.setVisible(true);
            dispose(); // Close the current ReservationArea frame
            
        }
    }
}
