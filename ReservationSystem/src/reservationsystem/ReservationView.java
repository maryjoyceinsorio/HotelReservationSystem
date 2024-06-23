/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservationsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationView extends JFrame {

    private DefaultTableModel table;
    private JTable Table;

    public ReservationView() {
        setTitle("Reservation System");
        setLayout(null); 
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        
        String[] columnNames = {"Name", "Contact Number", "Check-In", "Check-Out", "Room Types", "Room Service", "Amount"};
        table = new DefaultTableModel(columnNames, 0);
       Table = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(Table);
        scrollPane.setBounds(50, 50, 700, 300);
        add(scrollPane);

       
        JButton btnadd = new JButton("Add");
        JButton btnupdate = new JButton("Update");
        JButton btndelete = new JButton("Delete");
        JButton btnsave= new JButton("Save");
        
        btnadd.setBounds(50, 370, 100, 30);
        btnupdate.setBounds(170, 370, 100, 30);
        btndelete.setBounds(290, 370, 100, 30);
        btnsave.setBounds(410, 370, 100, 30);

        
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });

        btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpdate();
            }
        });

       btndelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDelete();
            }
        });

        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSave();
            }
        });

        
        add(btnadd);
        add(btnupdate);
        add(btndelete);
        add(btnsave);

        setVisible(true);
    }

    private void onAdd() {
        table.addRow(new Object[]{"", "", "", "", "", "", ""});
    }

    private void onUpdate() {
        int selectedRow = Table.getSelectedRow();
        if (selectedRow != -1) {
            System.out.println("Update button clicked for row: " + selectedRow);
           
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update.", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onDelete() {
        int selectedRow = Table.getSelectedRow();
        if (selectedRow != -1) {
            System.out.println("Delete button clicked for row: " + selectedRow);
            table.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onSave() {
        System.out.println("Save button clicked.");
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {     
            new ReservationView();
           }
        });
    }

}