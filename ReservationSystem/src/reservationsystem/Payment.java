
package reservationsystem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class Payment extends JFrame implements ActionListener{
 private JLabel lblname, lblamount, lblmethod;
 private JButton btnprocess, btnreservation, btnback;
 private JTextField txtname, txtamount;
 private JComboBox<String>methodd;
 
 
 Payment(){
     setTitle("Payment Process");
     setSize(600, 450 );
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
     
     lblname = new JLabel("Name");
     lblname.setBounds(100, 100, 100, 20);
     lblname.setFont(new Font("Arial", Font.PLAIN, 15));
     
     lblamount = new JLabel("amount");
     lblamount.setBounds(100, 130, 150, 20);
     lblamount.setFont(new Font("Arial", Font.PLAIN, 15));
     
     lblmethod = new JLabel("Select Payment Method");
     lblmethod.setBounds(100, 200, 210, 20);
     lblmethod.setFont(new Font("Arial", Font.PLAIN, 15));
     
     txtname = new JTextField();
     txtname.setBounds(200, 100, 200, 20);
     txtname.setFont(new Font("Arial", Font.PLAIN, 15));
     
     txtamount = new JTextField();
     txtamount.setBounds(200, 130, 200, 20);
     txtamount.setFont(new Font("Arial", Font.PLAIN, 15));
     
     btnprocess= new JButton("Process");
     btnprocess.setBounds(100, 300, 100, 20);
     btnprocess.setFont(new Font("Arial", Font.PLAIN,13));
     
     btnreservation= new JButton("Reservation");
     btnreservation.setBounds(250, 300, 100, 20);
     btnreservation.setFont(new Font("Arial", Font.PLAIN,13));
     
     btnback= new JButton("Service");
      btnback.setBounds(400, 300, 100, 20);
     btnback.setFont(new Font("Arial", Font.PLAIN,13));
     
     btnback.addActionListener(this);
     btnreservation.addActionListener(this);
     
     String[] pay = {"Debit", "Credit Card", "Paymaya", "GCash", "Paypal"};
   methodd = new JComboBox<>(pay);
   methodd.setBounds(300, 200, 150, 20);
    methodd.addActionListener(this);
     
     add(lblname);
     add(lblmethod);
     add(lblamount);
     add(lblmethod);
     add(btnreservation);
     add(btnback);
     add(btnprocess);
     add(txtname);
     add(txtamount);
     setVisible(true);
     setResizable(false);
     add(methodd);
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if(e.getSource() == btnback){
            RoomService rs = new RoomService();
            rs.setVisible(true);
        }else if(e.getSource() == btnreservation){
            HotelReservation hr = new HotelReservation();
            hr.setVisible(true);
        }
    }

}
    


