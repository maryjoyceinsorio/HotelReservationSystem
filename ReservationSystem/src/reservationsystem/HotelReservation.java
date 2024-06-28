/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservationsystem;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class HotelReservation extends JFrame implements ActionListener {

    private Container container;
    private JLabel lbltitle, lblname, lblcheckIn, lblcheckOut, lblcontact;
    private JTextField txtname, txtcontact;
    private JButton btnNext;
    private JSpinner spnCheckIn, spnCheckOut;

    public HotelReservation() {
        setTitle("Hotel Reservation");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        container = getContentPane();
        container.setLayout(null);

        lbltitle = new JLabel("Reservation Area");
        lbltitle.setFont(new Font("Arial", Font.BOLD, 24));
        lbltitle.setBounds(150, 30, 300, 30);
        container.add(lbltitle);

        lblname = new JLabel("Name:");
        lblname.setFont(new Font("Arial", Font.PLAIN, 18));
        lblname.setBounds(50, 80, 100, 30);
        container.add(lblname);

        txtname = new JTextField();
        txtname.setFont(new Font("Arial", Font.PLAIN, 18));
        txtname.setBounds(160, 80, 250, 25); 
        container.add(txtname);

        lblcheckIn = new JLabel("Check-in Date:");
        lblcheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckIn.setBounds(50, 130, 150, 30);
        container.add(lblcheckIn);

        spnCheckIn = new JSpinner(new SpinnerDateModel());
        spnCheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        spnCheckIn.setBounds(210, 130, 200, 25);
        JSpinner.DateEditor checkInEditor = new JSpinner.DateEditor(spnCheckIn, "yyyy-MM-dd");
        spnCheckIn.setEditor(checkInEditor);
        container.add(spnCheckIn);

        lblcheckOut = new JLabel("Check-out Date:");
        lblcheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckOut.setBounds(50, 180, 150, 30);
        container.add(lblcheckOut);

        spnCheckOut = new JSpinner(new SpinnerDateModel());
        spnCheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
        spnCheckOut.setBounds(210, 180, 200, 25);
        JSpinner.DateEditor checkOutEditor = new JSpinner.DateEditor(spnCheckOut, "yyyy-MM-dd");
        spnCheckOut.setEditor(checkOutEditor);
        container.add(spnCheckOut);

        lblcontact = new JLabel("Contact Number:");
        lblcontact.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcontact.setBounds(50, 230, 150, 30);
        container.add(lblcontact);

        txtcontact = new JTextField();
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 18));
        txtcontact.setBounds(210, 230, 250, 25); 
        container.add(txtcontact);

        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNext.setBounds(250, 290, 100, 30);
        btnNext.addActionListener(this);
        container.add(btnNext);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            String name = txtname.getText();
            Date checkInDate = (Date) spnCheckIn.getValue();
            Date checkOutDate = (Date) spnCheckOut.getValue();
            String contactNumber = txtcontact.getText();

            
            RoomTypes roomTypesFrame = new RoomTypes(name, checkInDate, checkOutDate, contactNumber);
            roomTypesFrame.setVisible(true);

            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelReservation();
        });
    }
}
