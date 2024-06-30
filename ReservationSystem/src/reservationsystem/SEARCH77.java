package reservationsystem;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SEARCH77 extends JFrame implements ActionListener {

    private JLabel lblRoomType, lblCheckIn, lblCheckOut;
    private JComboBox<String> comboRoomType;
    private JSpinner spnCheckIn, spnCheckOut;
    private JButton btnSearch, btnReservation;
    private JTextArea resultArea;

    private Connection connection;

    public SEARCH77() {
        setTitle("Search Room");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblRoomType = new JLabel("Room Type:");
        lblRoomType.setBounds(50, 50, 100, 25);
        add(lblRoomType);

        String[] roomTypes = {"Suite", "Two-person Room", "Balcony Room", 
            "Family Suite", "Deluxe Room", "Superior Deluxe Suite", "Executive Suite", "Family Deluxe Suite"};
        comboRoomType = new JComboBox<>(roomTypes);
        comboRoomType.setBounds(150, 50, 150, 25);
        add(comboRoomType);

        lblCheckIn = new JLabel("Check-in Date:");
        lblCheckIn.setBounds(50, 100, 100, 25);
        add(lblCheckIn);

        spnCheckIn = new JSpinner(new SpinnerDateModel());
        spnCheckIn.setBounds(150, 100, 150, 25);
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(spnCheckIn, "yyyy-MM-dd");
        spnCheckIn.setEditor(checkInEditor);
        add(spnCheckIn);

        lblCheckOut = new JLabel("Check-out Date:");
        lblCheckOut.setBounds(50, 150, 100, 25);
        add(lblCheckOut);

        spnCheckOut = new JSpinner(new SpinnerDateModel());
        spnCheckOut.setBounds(150, 150, 150, 25);
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(spnCheckOut, "yyyy-MM-dd");
        spnCheckOut.setEditor(checkOutEditor);
        add(spnCheckOut);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(50, 200, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);

        btnReservation = new JButton("Reservation");
        btnReservation.setBounds(200, 200, 120, 30);
        btnReservation.addActionListener(this);
        add(btnReservation);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 250, 500, 100);
        resultArea.setEditable(false);
        add(resultArea);

        connectToDatabase(); 
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/hotelreservation?zeroDateTimeBehavior=convertToNull"; // Replace with your DB name
            String user = "root"; 
            String password = "123456"; 

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }
    }

    private boolean isRoomAvailable(String roomType, Date checkInDate, Date checkOutDate) {
        String sql = "SELECT COUNT(*) FROM reservations WHERE room_type = ? AND ((check_in_date <= ? AND check_out_date >= ?) OR (check_in_date <= ? AND check_out_date >= ?))";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, roomType);
            statement.setDate(2, new java.sql.Date(checkOutDate.getTime()));
            statement.setDate(3, new java.sql.Date(checkInDate.getTime()));
            statement.setDate(4, new java.sql.Date(checkOutDate.getTime()));
            statement.setDate(5, new java.sql.Date(checkInDate.getTime()));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) == 0; 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to check room availability.");
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String roomType = (String) comboRoomType.getSelectedItem();
            Date checkIn = (Date) spnCheckIn.getValue();
            Date checkOut = (Date) spnCheckOut.getValue();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String checkInDate = sdf.format(checkIn);
            String checkOutDate = sdf.format(checkOut);

            boolean isAvailable = isRoomAvailable(roomType, checkIn, checkOut);

            if (isAvailable) {
                resultArea.setText("Room type '" + roomType + "' is available from " + checkInDate + " to " + checkOutDate);
            } else {
                resultArea.setText("Room type '" + roomType + "' is not available from " + checkInDate + " to " + checkOutDate);
            }
        } else if (e.getSource() == btnReservation) {
            HotelReservation hotelReservation = new HotelReservation();
            hotelReservation.setVisible(true);
            this.dispose();
        }
    }
}
