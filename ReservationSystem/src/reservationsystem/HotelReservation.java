/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservationsystem;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class HotelReservation extends JFrame implements ActionListener {

    
    private JLabel lbltitle, lblname, lblcheckIn, lblcheckOut, lblcontact, bg;
    private JTextField txtname, txtcontact;
    private JButton btnNext;
    private JSpinner spnCheckIn, spnCheckOut;
    private Connection connection;

    public HotelReservation() {
        connectToDatabase(); // Initialize database connection

        setTitle("Hotel Reservation");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        
        setLayout(null);
        
        //bgimg
        bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\casan\\OneDrive\\Documents\\NetBeansProjects\\HotelReservationSystem\\ReservationSystem\\src\\reservationsystem\\bgimg.jpg").getImage().getScaledInstance(450,300, Image.SCALE_SMOOTH)));
        bg.setBounds(140, 10, 450, 300);
         

        lbltitle = new JLabel("Reservation Area",SwingConstants.CENTER);
        lbltitle.setFont(new Font("Arial", Font.BOLD, 24));
        lbltitle.setBounds(0, 40, 700, 30);
        lbltitle.setForeground(Color.WHITE);
        add(lbltitle);

        lblname = new JLabel("Name:");
        lblname.setFont(new Font("Arial", Font.PLAIN, 18));
        lblname.setBounds(50, 80, 100, 30);
        lblname.setForeground(Color.WHITE);
        add(lblname);

        txtname = new JTextField();
        txtname.setFont(new Font("Arial", Font.PLAIN, 18));
        txtname.setBounds(160, 80, 250, 25); 
        add(txtname);

        lblcheckIn = new JLabel("Check-in Date:");
        lblcheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckIn.setBounds(50, 130, 150, 30);
        lblcheckIn.setForeground(Color.WHITE);
        add(lblcheckIn);

        spnCheckIn = new JSpinner(new SpinnerDateModel());
        spnCheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        spnCheckIn.setBounds(210, 130, 200, 25);
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(spnCheckIn, "yyyy-MM-dd");
        spnCheckIn.setEditor(checkInEditor);
        add(spnCheckIn);

        lblcheckOut = new JLabel("Check-out Date:");
        lblcheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckOut.setBounds(50, 180, 150, 30);
        lblcheckOut.setForeground(Color.WHITE);
        add(lblcheckOut);

        spnCheckOut = new JSpinner(new SpinnerDateModel());
        spnCheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
        spnCheckOut.setBounds(210, 180, 200, 25);
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(spnCheckOut, "yyyy-MM-dd");
        spnCheckOut.setEditor(checkOutEditor);
        add(spnCheckOut);

        lblcontact = new JLabel("Contact Number:");
        lblcontact.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcontact.setBounds(50, 230, 150, 30);
        lblcontact.setForeground(Color.WHITE);
       add(lblcontact);

        txtcontact = new JTextField();
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 18));
        txtcontact.setBounds(210, 230, 250, 25); 
        add(txtcontact);

        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNext.setBounds(250, 290, 100, 30);
        btnNext.addActionListener(this);
        add(btnNext);
        add(bg);
        setVisible(true);
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/hotelreservation";
            String user = "root"; 
            String password = "12345"; 

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }
    }

    private void insertReservation(String name, Date checkInDate, Date checkOutDate, String contactNumber, String roomType, int price) {
        String sql = "INSERT INTO reservations (name, check_in_date, check_out_date, contact_number, room_type, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setDate(2, new java.sql.Date(checkInDate.getTime()));
            statement.setDate(3, new java.sql.Date(checkOutDate.getTime()));
            statement.setString(4, contactNumber);
            statement.setString(5, roomType);
            statement.setDouble(6, price);

            statement.executeUpdate();
            System.out.println("Reservation inserted successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to insert reservation.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            String name = txtname.getText();
            Date checkInDate = (Date) spnCheckIn.getValue();
            Date checkOutDate = (Date) spnCheckOut.getValue();
            String contactNumber = txtcontact.getText();

            if (validateDates(checkInDate, checkOutDate)) {
                RoomTypes roomTypesFrame = new RoomTypes(name, checkInDate, checkOutDate, contactNumber);
                roomTypesFrame.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Check-out date must be after check-in date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean validateDates(Date checkInDate, Date checkOutDate) {
        return checkInDate.before(checkOutDate) || checkInDate.equals(checkOutDate);
    }

}
