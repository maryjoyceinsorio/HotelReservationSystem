package reservationsystem;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class HotelReservation {
  
    private JFrame f = new JFrame("HOTEL RESERVATION");
    private JLabel lblHOTELRESERVATIONFORM, lblGuestName, lblEmail, lblPhoneNumber, lblReservationDate, lblReservationTime, lblHowmanyPersonwillyoubewith;
    private JTextField txtfldName = new JTextField();
     private JTextField txtfldEmail = new JTextField();
     private JTextField txtfldPhoneNumber = new JTextField();
    private JTextField txtfldReservationDate = new JTextField();
     private JTextField txtfldReservationTime = new JTextField();
      private JTextField txtfldHowmanyPersonwillyoubewith = new JTextField();
      private JButton btnSearch, btnDelete;
      
      HotelReservation(){
    f.setSize(500, 600);
    f.setLayout(null);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    
    lblHOTELRESERVATIONFORM = new JLabel("HOTEL RESERVATION");
    lblHOTELRESERVATIONFORM.setBounds(100, 30, 350, 60);
    lblHOTELRESERVATIONFORM.setFont(new Font("Casterllar", Font.BOLD,20));
    
    lblGuestName = new JLabel("GuestName:");
    lblGuestName.setBounds(20, 100, 120, 40);
    lblGuestName.setFont(new Font("Casterllar", Font.BOLD,15));
    
    lblEmail = new JLabel("Email:");
    lblEmail.setBounds(20, 160, 140, 40);
    lblEmail.setFont(new Font("Casterllar", Font.BOLD,15));
    
     
    lblPhoneNumber = new JLabel("Phone Number:");
    lblPhoneNumber.setBounds(20, 220, 140, 40);
    lblPhoneNumber.setFont(new Font("Casterllar", Font.BOLD,15));
    
    
    lblReservationDate = new JLabel("ReservationDate:");
    lblReservationDate.setBounds(20, 280, 140, 40);
    lblReservationDate.setFont(new Font("Casterllar", Font.BOLD,15));
    
     
     
    lblReservationTime = new JLabel("ReservationTime:");
    lblReservationTime.setBounds(20, 340, 140, 40);
    lblReservationTime.setFont(new Font("Casterllar", Font.BOLD,15));
    
    
    lblHowmanyPersonwillyoubewith = new JLabel("How many Person will you be with:");
    lblHowmanyPersonwillyoubewith.setBounds(20, 400, 500, 40);
    lblHowmanyPersonwillyoubewith.setFont(new Font("Casterllar", Font.BOLD,15));
    
    btnSearch = new JButton("Search");
    btnSearch.setBounds(350, 500, 100, 30);
    btnSearch.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    btnDelete = new JButton("DELETE");
    btnDelete.setBounds(20, 500, 100, 30);
    btnDelete.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    
            
    
    
    txtfldName.setBounds(115, 110, 200,20);
    txtfldName.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    txtfldEmail.setBounds(80, 170, 200,20);
    txtfldEmail.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    txtfldPhoneNumber.setBounds(150, 230, 200,20);
    txtfldPhoneNumber.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    txtfldReservationDate.setBounds(150, 290, 200,20);
    txtfldReservationDate.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    txtfldReservationTime.setBounds(155, 350, 200,20);
    txtfldReservationTime.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    txtfldHowmanyPersonwillyoubewith.setBounds(280, 410, 100,20);
    txtfldHowmanyPersonwillyoubewith.setFont(new Font("Castellar", Font.PLAIN, 15));
    
    f.add(btnDelete);
    f.add(btnSearch);
    f.add(txtfldHowmanyPersonwillyoubewith);
    f.add(lblHowmanyPersonwillyoubewith);
    f.add(lblReservationTime);
    f.add(txtfldReservationTime);
    f.add(txtfldReservationDate);
    f.add(lblReservationDate);
    f.add(lblPhoneNumber);
    f.add( lblEmail);
    f.add(lblGuestName); 
    f.add(txtfldName);
    f.add(txtfldEmail);
    f.add(txtfldPhoneNumber);
    f.add(lblHOTELRESERVATIONFORM);
     f.setVisible(true);
    f.setResizable(false);
        
      }
      
}


