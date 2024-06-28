package reservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {

    private JLabel lblPayment;
    private JLabel lblAmount;
    private JTextField txtAmount;
    private JLabel lblPaymentMethod;
    private JComboBox<String> comboPaymentMethod;
    private JButton btnPay;

    private String[] paymentMethods = {"Credit Card", "Debit Card", "PayPal", "Bank Transfer"};
    
    public Payment(String totalAmount) {
        setTitle("Payment");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
         getContentPane().setBackground(Color.LIGHT_GRAY);
        
        lblPayment = new JLabel("Payment Details");
        lblPayment.setBounds(20, 20, 150, 25);
        
        
        lblAmount = new JLabel("Total Amount:");
        lblAmount.setBounds(20, 60, 100, 25);
        add(lblAmount);
        
        txtAmount = new JTextField(totalAmount); 
        txtAmount.setBounds(130, 60, 150, 25);
        txtAmount.setEditable(false); 
        
        lblPaymentMethod = new JLabel("Payment Method:");
        lblPaymentMethod.setBounds(20, 100, 120, 25);
        
        comboPaymentMethod = new JComboBox<>(paymentMethods);
        comboPaymentMethod.setBounds(150, 100, 150, 25);
        
        btnPay = new JButton("Pay Now");
        btnPay.setBounds(100, 150, 100, 25);
        btnPay.addActionListener(this);
        btnPay.setFont(new Font("Arial", Font.BOLD, 15));
        
        add(lblPayment);
    
        add(txtAmount);
        add(lblPaymentMethod);
        add(comboPaymentMethod);
        add(btnPay);
        setVisible(true);
    }

    Payment() {
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPay) {
            String totalAmount = txtAmount.getText();
            String selectedMethod = (String) comboPaymentMethod.getSelectedItem();
            
            JOptionPane.showMessageDialog(this, "Payment processed successfully!\n"
                    + "Total Amount Paid: " + totalAmount + "\n"
                    + "Payment Method: " + selectedMethod);
            
            dispose(); 
        
        JOptionPane.showMessageDialog(null, "Thank you for your payment. "
                + "You will receive a confirmation email shortly.");
        
        Homepage homepage = new Homepage();
        homepage.setVisible(true); 
    }
}

    public void setTotalAmount(String amount) {
        txtAmount.setText(amount);
    }
}
