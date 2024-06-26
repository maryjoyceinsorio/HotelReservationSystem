/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package reservationsystem;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 */
public class SEARCH77 implements ActionListener {
    
    private JFrame f = new JFrame("search");
    private JLabel lblROOM,lblNOOFBEDS, lblSearchResults;
    private JTextField txtfldROOM = new JTextField();
    private JTextField txtfldNOOFBEDS = new JTextField();
    private JButton btnSEARCH, btnReset;
   

    
    SEARCH77(){
    
    f.setSize(450, 300);
    f.setLayout(null);
    f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
    
    lblROOM = new JLabel("TYPE OF ROOM :");
    lblROOM.setBounds(20, 50, 150, 30);
    lblROOM.setFont(new Font("Arial Black", Font.BOLD, 15));
    
    lblNOOFBEDS = new JLabel("NO. OF BEDS:");
    lblNOOFBEDS.setBounds(20, 100, 120, 30);
    lblNOOFBEDS.setFont(new Font("Arial Black", Font.BOLD, 15));
    
    txtfldROOM.setBounds(180, 50, 140,30);
    txtfldROOM.setFont(new Font("Arial", Font.PLAIN, 15));
    
    txtfldNOOFBEDS.setBounds(180, 100, 140,30);
    txtfldNOOFBEDS.setFont(new Font("Arial", Font.PLAIN, 15));
    
    
    btnSEARCH = new JButton("SEARCH");
    btnSEARCH.setBounds(30, 150, 120, 30);
    btnSEARCH.setFont(new Font("Arial Black", Font.PLAIN, 15));
    btnSEARCH.addActionListener(this);
   
    btnReset = new JButton("CLEAR");
    btnReset.setBounds(160, 150, 120, 30);
    btnReset.setFont(new Font("Arial Black", Font.PLAIN, 15));
    btnReset.addActionListener(this);
    
    lblSearchResults = new JLabel("");
    lblSearchResults.setBounds(20, 200, 480, 30);
    lblSearchResults.setFont(new Font("Arial", Font.PLAIN, 15));
    
    f.add(lblROOM);
    f.add(lblNOOFBEDS);
    f.add(lblROOM);
    f.add(txtfldROOM);
    f.add(txtfldNOOFBEDS);
    f.add(btnSEARCH);
    f.add(btnReset);
    f.add(lblSearchResults);
    
   
    f.setVisible(true);
    f.setResizable(false);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}