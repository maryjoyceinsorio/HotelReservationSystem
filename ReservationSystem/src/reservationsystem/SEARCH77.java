import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SEARCH77 extends JFrame implements ActionListener {

    private JLabel lblRoomType, lblCheckIn, lblCheckOut,bg;
    private JComboBox<String> comboRoomType;
    private JTextField txtCheckIn, txtCheckOut;
    private JButton btnSearch, btnClear;

    public SEARCH77() {
        setTitle("SEARCH ROOM");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
         bg = new JLabel();
        bg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\HP\\Documents\\NetBeansProjects\\BANKRESERVATION\\src\\bgimg.png").getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH)));
        bg.setBounds(0, 0, 600, 400);
       
        lblRoomType = new JLabel("ROOM TYPE:");
        lblRoomType.setBounds(50, 50, 100, 25);
        add(lblRoomType);
        
        String[] roomTypes = {"SINGLE BED", "DOUBLE BEDS","TRIPLE BEDS"," VIP SUITE","PRESIDENTIAL ROOM"};
        comboRoomType = new JComboBox<>(roomTypes);
        comboRoomType.setBounds(150, 50, 150, 25);
        add(comboRoomType);
        
        lblCheckIn = new JLabel("CHECK-IN DATE:");
        lblCheckIn.setBounds(50, 100, 100, 25);
        add(lblCheckIn);
        
        txtCheckIn = new JTextField();
        txtCheckIn.setBounds(150, 100, 150, 25);
        add(txtCheckIn);
        
        lblCheckOut = new JLabel("CHECK-OUT DATE:");
        lblCheckOut.setBounds(50, 150, 150, 25);
        add(lblCheckOut);
        
        txtCheckOut = new JTextField();
        txtCheckOut.setBounds(165, 150, 150, 25);
        add(txtCheckOut);
        
        btnSearch = new JButton("SEARCH");
        btnSearch.setBounds(50, 200, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);
        
        btnClear = new JButton("CLEAR");
        btnClear.setBounds(200, 200, 100, 30);
        btnClear.addActionListener(this);
        add(btnClear);
        add(bg);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String roomType = (String) comboRoomType.getSelectedItem();
            String checkInDate = txtCheckIn.getText();
            String checkOutDate = txtCheckOut.getText();
            
            SEARCH77 rs = new SEARCH77();
            rs.setVisible(true);
            dispose();
            
           
            JOptionPane.showMessageDialog(this, "Searching for " + roomType + " rooms from " + checkInDate + " to " + checkOutDate);
        } else if (e.getSource() == btnClear) {
            comboRoomType.setSelectedIndex(0);
            txtCheckIn.setText("");
            txtCheckOut.setText("");
            
            
        }
    }
}