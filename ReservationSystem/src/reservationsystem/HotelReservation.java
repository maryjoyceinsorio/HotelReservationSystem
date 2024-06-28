/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservationsystem;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReservation extends JFrame implements ActionListener {

    private Container container;
    private JLabel lbltitle, lblname, lblcheckIn, lblcheckOut, lblcontact;
    private JTextField txtname, txtcheckIn, txtcheckOut,txtcontact;
    private JButton btnNext;

    public HotelReservation() {
        setTitle("Hotel Reservation");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
         getContentPane().setBackground(Color.LIGHT_GRAY);

        container = getContentPane();
        container.setLayout(null);

       
        container.setBackground(new Color(215, 230, 243)); 

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
        txtname.setBounds(160, 80, 400, 30); 
        container.add(txtname);

        lblcheckIn = new JLabel("Check-in Date:");
        lblcheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckIn.setBounds(50, 130, 150, 30); 
        container.add(lblcheckIn);

        txtcheckIn = new JTextField();
        txtcheckIn.setFont(new Font("Arial", Font.PLAIN, 18));
        txtcheckIn.setBounds(210, 130, 350, 30); 
        container.add(txtcheckIn);

        lblcheckOut = new JLabel("Check-out Date:");
        lblcheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
        lblcheckOut.setBounds(50, 180, 150, 30); 
        container.add(lblcheckOut);

         txtcheckOut = new JTextField();
        txtcheckOut.setFont(new Font("Arial", Font.PLAIN, 18));
         txtcheckOut.setBounds(210, 180, 350, 30); 
        container.add( txtcheckOut);

        lblcontact = new JLabel("Contact Number:");
        lblcontact.setFont(new Font("Arial", Font.PLAIN, 18));
       lblcontact.setBounds(50, 230, 200, 30); 
        container.add(lblcontact);

        txtcontact = new JTextField();
        txtcontact.setFont(new Font("Arial", Font.PLAIN, 18));
        txtcontact.setBounds(250, 230, 310, 30); 
        container.add(txtcontact);

        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Arial", Font.PLAIN, 18));
        btnNext.setBounds(250, 290, 100, 40); 
        btnNext.addActionListener(this);
        container.add(btnNext);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            
            String name = txtname.getText();
            String checkInDate = txtcheckIn.getText();
            String checkOutDate = txtcheckOut.getText();
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
