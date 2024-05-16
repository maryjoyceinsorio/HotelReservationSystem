package reservationsystem;

import javax.swing.*;


public class RoomTypes {
   
    RoomTypes(){
        JFrame types = new JFrame("Types of room available.");
        
        types.setSize(1500, 2000);
        
        //room clickables
        JButton room1 = new JButton("Single bed");
        JButton room2 = new JButton("Double bed");
        JButton room3 = new JButton("Balcony");
        JButton room4 = new JButton("Triple bed");
        JButton room5 = new JButton("Queen bed");
        JButton room6 = new JButton("Royalty bed");
        JButton room7 = new JButton("Queen's balcony");
        JButton room8 = new JButton("Bunk beds");
        
        room1.setBounds(80, 130, 500, 30);
        room2.setBounds(80, 330, 500, 30);
        room3.setBounds(80, 530, 500, 30);
        room4.setBounds(80, 730, 500, 30);
        room5.setBounds(800, 130, 500, 30);
        room6.setBounds(800, 330, 500, 30);
        room7.setBounds(800, 530, 500, 30);
        room8.setBounds(800, 730, 500, 30);
        
        //text head
        JLabel textH = new JLabel("Room Types Available:");
        JLabel textS = new JLabel ("Search:");
        JTextField searchB = new JTextField ();
        
        textH.setBounds(10, 0, 300, 50);
        textS.setBounds(10, 30, 300, 50);
        searchB.setBounds(55, 45, 300, 20);
        
        //room descriptions
        JLabel roomi1 = new JLabel("Standard Room Size, Single Bed");
        JLabel roomi2 = new JLabel("Standard Room Size, Two Beds");
        JLabel roomi3 = new JLabel("Standard Room Size, Two Beds, Balcony View");
        JLabel roomi4 = new JLabel("Medium Room Size, Three Beds");
        JLabel roomi5 = new JLabel("Medium Room Size, One Queen Sized Bed");
        JLabel roomi6 = new JLabel("Medium Room Size, Two Queen Sized Beds");
        JLabel roomi7 = new JLabel("Large Room Size, One Queen Sized Bed with Balcony View");
        JLabel roomi8 = new JLabel("Medium Room Size, Two Medium Bunkbeds");
        
        roomi1.setBounds(80, 160, 200, 70);
        roomi2.setBounds(80, 360, 200, 70);
        roomi3.setBounds(80, 560, 500, 70);
        roomi4.setBounds(80, 760, 200, 70);
        roomi5.setBounds(800, 160, 500, 70);
        roomi6.setBounds(800, 360, 500, 70);
        roomi7.setBounds(800, 560, 500, 70);
        roomi8.setBounds(800, 760, 500, 70);
        
        //adding
        types.add(room1);
        types.add(room2);
        types.add(room3);
        types.add(room4);
        types.add(room5);
        types.add(room6);
        types.add(room7);
        types.add(room8);
        
        types.add(roomi1);
        types.add(roomi2);
        types.add(roomi3);
        types.add(roomi4);
        types.add(roomi5);
        types.add(roomi6);
        types.add(roomi7);
        types.add(roomi8);
        
        types.add(textH);
        types.add(textS);
        types.add(searchB);
       
        types.setLayout(null);
        
       
        types.setVisible(true);
        
        types.setDefaultCloseOperation(types.EXIT_ON_CLOSE);
    }
     
}