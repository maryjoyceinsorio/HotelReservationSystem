package reservationsystem;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SEARCH77 extends JFrame implements ActionListener {

    private JLabel lblRoomType, lblCheckIn, lblCheckOut;
    private JComboBox<String> comboRoomType;
    private JTextField txtCheckIn, txtCheckOut;
    private JButton btnSearch, btnCancel;
    private JTextArea resultArea;

    public SEARCH77() {
        setTitle("Search Room");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(50, 50, 100, 25);
        add(lblRoomType);
        
        String[] roomTypes = {"Single", "Double", "Suite", "Two-person Room","Balcony Room", 
            "Family Suite", "Deluxe Room","Superior Deluxe Suite","Executive Suite","Family Deluxe Suite"};
        comboRoomType = new JComboBox<>(roomTypes);
        comboRoomType.setBounds(150, 50, 150, 25);
        add(comboRoomType);
        
        lblCheckIn = new JLabel("Check-in Date:");
        lblCheckIn.setBounds(50, 100, 100, 25);
        add(lblCheckIn);
        
        txtCheckIn = new JTextField();
        txtCheckIn.setBounds(150, 100, 150, 25);
        add(txtCheckIn);
        
        lblCheckOut = new JLabel("Check-out Date:");
        lblCheckOut.setBounds(50, 150, 100, 25);
        add(lblCheckOut);
        
        txtCheckOut = new JTextField();
        txtCheckOut.setBounds(150, 150, 150, 25);
        add(txtCheckOut);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(50, 200, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 200, 100, 30);
        btnCancel.addActionListener(this);
        add(btnCancel);
        
        resultArea = new JTextArea();
        resultArea.setBounds(50, 250, 500, 100);
        resultArea.setEditable(false);
        add(resultArea);
    }

    SEARCH77(Homepage aThis) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String roomType = (String) comboRoomType.getSelectedItem();
            String checkInDate = txtCheckIn.getText();
            String checkOutDate = txtCheckOut.getText();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkIn = null;
            Date checkOut = null;
            try {
                checkIn = sdf.parse(checkInDate);
                checkOut = sdf.parse(checkOutDate);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-MM-dd.");
                return;
            }

           
            boolean isAvailable = true; 

            if (isAvailable) {
                resultArea.setText("Room type '" + roomType + "' is available from " + checkInDate + " to " + checkOutDate);
            } else {
                resultArea.setText("Room type '" + roomType + "' is not available from " + checkInDate + " to " + checkOutDate);
            }
        } else if (e.getSource() == btnCancel) {
           
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.setVisible(true);
            this.dispose(); 
    }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SEARCH77 searchFrame = new SEARCH77();
            searchFrame.setVisible(true);
        });
    }
}