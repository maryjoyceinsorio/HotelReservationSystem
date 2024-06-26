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
        
        lblPayment = new JLabel("Payment Details");
        lblPayment.setBounds(20, 20, 150, 25);
        
        lblAmount = new JLabel("Total Amount:");
        lblAmount.setBounds(20, 60, 100, 25);
        add(lblAmount);
        
        txtAmount = new JTextField(totalAmount); // Initialize with the provided total amount
        txtAmount.setBounds(130, 60, 150, 25);
        txtAmount.setEditable(false); // Ensure the amount field is not editable
        
        lblPaymentMethod = new JLabel("Payment Method:");
        lblPaymentMethod.setBounds(20, 100, 120, 25);
        
        comboPaymentMethod = new JComboBox<>(paymentMethods);
        comboPaymentMethod.setBounds(150, 100, 150, 25);
        
        btnPay = new JButton("Pay Now");
        btnPay.setBounds(100, 150, 100, 25);
        btnPay.addActionListener(this);
        
        add(lblPayment);
        add(lblAmount);
        add(txtAmount);
        add(lblPaymentMethod);
        add(comboPaymentMethod);
        add(btnPay);
        setVisible(true);
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPay) {
            String totalAmount = txtAmount.getText();
            String selectedMethod = (String) comboPaymentMethod.getSelectedItem();
            
            JOptionPane.showMessageDialog(this, "Payment processed successfully!\n"
                    + "Total Amount Paid: " + totalAmount + "\n"
                    + "Payment Method: " + selectedMethod);
            
            dispose(); // Close the Payment frame after payment is processed
            
            JOptionPane.showMessageDialog(null, "Thank you for your payment. "
                    + "You will receive a confirmation email shortly.");
            
            // Replace with appropriate action after payment completion, e.g., navigating to a homepage
            // Homepage homepage = new Homepage();
            // homepage.setVisible(true);
        }
    }

    public void setTotalAmount(String amount) {
        txtAmount.setText(amount);
    }
}
