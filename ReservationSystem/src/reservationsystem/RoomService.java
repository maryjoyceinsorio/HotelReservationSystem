
package reservationsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class RoomService implements ActionListener {
     private JLabel lblservice, lblbf, lblsalad, lblsnacks, lblbeve;
     private JFrame f = new JFrame("Room Service");
     private JButton  btnfullbf,btnbfbuffet, btncontibf, btnalacarte, btnclassic, btnturkey, btncaesar, 
             btncobb, btncala, btnshrimp, btnfruit, btnnuts, btncoffee, btntea, btnwine, btndrinks;
     
     RoomService(){
         f.setSize(450, 550);
         f.setLayout(null);
         f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
         
      lblservice = new JLabel("Room Service");
      lblservice.setBounds(20, 30, 160, 30);
      lblservice.setFont(new Font("Arial", Font.BOLD, 20));
      
      lblbf = new JLabel("Breakfast Options");
      lblbf.setBounds(20, 70, 160, 30);
      lblbf.setFont(new Font("Arial", Font.ITALIC, 13));
      
      btnfullbf = new JButton("Full Breakfast");
      btnfullbf.setBounds(20, 100, 140, 25);
      btnfullbf.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnbfbuffet = new JButton("Breakfast Buffet");
      btnbfbuffet.setBounds(180, 100, 140, 25);
      btnbfbuffet.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btncontibf = new JButton("Continental Breakfast");
      btncontibf.setBounds(20, 140, 140, 25);
      btncontibf.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnalacarte = new JButton("A La Carte Items");
      btnalacarte.setBounds(180, 140, 140, 25);
      btnalacarte.setFont(new Font("Arial", Font.PLAIN, 13));
      
      lblsalad = new JLabel("Sandwiches and salad");
      lblsalad.setBounds(20, 165, 160, 30);
      lblsalad.setFont(new Font("Arial", Font.ITALIC, 13));
      
      btnclassic = new JButton("Classic Sandwich");
      btnclassic.setBounds(20, 200, 140, 25);
      btnclassic.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnturkey = new JButton("Turkey Sandwich");
      btnturkey.setBounds(180, 200, 140, 25);
      btnturkey.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btncaesar = new JButton("Caesar Salad");
      btncaesar.setBounds(20, 240, 140, 25);
      btncaesar.setFont(new Font("Arial", Font.PLAIN,13));
      
      btncobb = new JButton("Cobb Salad");
      btncobb.setBounds(180, 240, 140, 25);
      btncobb.setFont(new Font("Arial", Font.PLAIN, 13));
      
      lblsnacks = new JLabel("Appetizer and snacks");
      lblsnacks.setBounds(20, 265, 160, 30);
      lblsnacks.setFont(new Font("Arial", Font.ITALIC, 13));
      
      btncala = new JButton("Calamari");
      btncala.setBounds(20, 300, 140, 25);
      btncala.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnshrimp = new JButton("Shrimp Cocktail");
      btnshrimp.setBounds(180, 300, 140, 25);
      btnshrimp.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnfruit = new JButton("Fresh Fruit Plate");
      btnfruit.setBounds(180, 340, 140, 25);
      btnfruit.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnnuts = new JButton("Mixed Nuts");
      btnnuts.setBounds(20, 340, 140, 25);
      btnnuts.setFont(new Font("Arial", Font.PLAIN, 13));
      
      lblbeve = new JLabel("Beverages");
      lblbeve.setBounds(20, 365, 160, 30);
      lblbeve.setFont(new Font("Arial", Font.ITALIC, 13));
      
      btncoffee = new JButton("Coffee");
      btncoffee.setBounds(20, 400, 140, 25);
      btncoffee.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btntea = new JButton("Tea");
      btntea.setBounds(20, 440, 140, 25);
      btntea.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btnwine = new JButton("Wine");
      btnwine.setBounds(180, 400, 140, 25);
      btnwine.setFont(new Font("Arial", Font.PLAIN, 13));
      
      btndrinks = new JButton("Soft Drinks");
      btndrinks.setBounds(180, 440, 140, 25);
      btndrinks.setFont(new Font("Arial", Font.PLAIN, 13));
      btndrinks.addActionListener(this);
      
       f.add(lblservice);
      f.add(lblbf);
      f.add(btnfullbf);
      f.add(btnbfbuffet);
      f.add(btncontibf);
      f.add(btnalacarte);
      f.add(lblsalad);
      f.add(btnclassic);
      f.add(btnturkey);
      f.add(btncaesar);
      f.add(btncobb);
      f.add(lblsnacks);
      f.add(btncala);
      f.add(btnshrimp);
      f.add(btnfruit);
      f.add(btnnuts);
      f.add(lblbeve);
      f.add(btncoffee);
      f.add(btntea);
      f.add(btnwine);
      f.add(btndrinks);
      
f.setVisible(true);
      f.setResizable(false);
      
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
