package reservationsystem;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class RoomTypes extends JFrame implements ActionListener {
        //room buttons
        private JButton room1 = new JButton("Single bed");
        private JButton room2 = new JButton("Double bed");
        private JButton room3 = new JButton("Balcony");
        private JButton room4 = new JButton("Triple bed");
        private JButton room5 = new JButton("Queen bed");
        private JButton room6 = new JButton("Royalty bed");
        private JButton room7 = new JButton("Queen's balcony");
        private JButton room8 = new JButton("Bunk beds");
        
        //text header
        private JLabel textH = new JLabel("Room Types Available:");
        private JLabel textS = new JLabel ("Search:");
        private JTextField searchB = new JTextField();
        
        //room descriptions
        private JLabel roomi1 = new JLabel("Standard Room Size, Single Bed");
        private JLabel roomi2 = new JLabel("Standard Room Size, Two Beds");
        private JLabel roomi3 = new JLabel("Standard Room Size, Two Beds, Balcony View");
        private JLabel roomi4 = new JLabel("Medium Room Size, Three Beds");
        private JLabel roomi5 = new JLabel("Medium Room Size, One Queen Sized Bed");
        private JLabel roomi6 = new JLabel("Medium Room Size, Two Queen Sized Beds");
        private JLabel roomi7 = new JLabel("Large Room Size, One Queen Sized Bed with Balcony View");
        private JLabel roomi8 = new JLabel("Medium Room Size, Two Medium Bunkbeds");
        
    RoomTypes(){
        setTitle("Types of Room available");
        setSize(1500, 2000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //room button boundaries
        room1.setBounds(80, 130, 500, 30);
        room2.setBounds(80, 330, 500, 30);
        room3.setBounds(80, 530, 500, 30);
        room4.setBounds(80, 730, 500, 30);
        room5.setBounds(800, 130, 500, 30);
        room6.setBounds(800, 330, 500, 30);
        room7.setBounds(800, 530, 500, 30);
        room8.setBounds(800, 730, 500, 30);
        
        
        //room header boundaries
        textH.setBounds(10, 0, 300, 50);
        textS.setBounds(10, 30, 300, 50);
        searchB.setBounds(55, 45, 300, 20);
        
        
        //room description boundaries
        roomi1.setBounds(80, 160, 200, 70);
        roomi2.setBounds(80, 360, 200, 70);
        roomi3.setBounds(80, 560, 500, 70);
        roomi4.setBounds(80, 760, 200, 70);
        roomi5.setBounds(800, 160, 500, 70);
        roomi6.setBounds(800, 360, 500, 70);
        roomi7.setBounds(800, 560, 500, 70);
        roomi8.setBounds(800, 760, 500, 70);
        
        //added 
       add(room1);
       add(room2);
       add(room3);
       add(room4);
       add(room5);
       add(room6);
       add(room7);
       add(room8);
        
       add(roomi1);
       add(roomi2);
       add(roomi3);
       add(roomi4);
       add(roomi5);
       add(roomi6);
       add(roomi7);
       add(roomi8);
        
       add(textH);
       add(textS);
       add(searchB);
       
       //action listener
       room1.addActionListener(this);
       room2.addActionListener(this);
       room3.addActionListener(this);
       room4.addActionListener(this);
       room5.addActionListener(this);
       room6.addActionListener(this);
       room7.addActionListener(this);
       room8.addActionListener(this);
       
       
       
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if(e.getSource() == room1){
            SingleBedFrame sgf = new SingleBedFrame();
            sgf.setVisible(true);
        }else if(e.getSource() == room2){
            DoubleBedFrame dbf = new DoubleBedFrame();
            dbf.setVisible(true);
        }else if(e.getSource() == room3){
            BalconyFrame bf = new BalconyFrame();
            bf.setVisible(true);
        }else if(e.getSource() == room4){
            TripleBedFrame tbf = new TripleBedFrame();
            tbf.setVisible(true);
        }else if(e.getSource() == room5){
            DeluxeRoom tbf = new DeluxeRoom();
            tbf.setVisible(true);
}
}
}
