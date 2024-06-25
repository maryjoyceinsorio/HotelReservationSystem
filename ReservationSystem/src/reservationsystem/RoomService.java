package reservationsystem;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RoomService extends JFrame implements ActionListener {
    
    private JLabel lblHotelName,  lblBreakfast, lblLunch, lblDinner, lblQtyBreakfast, lblQtyLunch, lblQtyDinner;
    private JButton btnAddBreakfast, btnMinusBreakfast, btnAddLunch, btnMinusLunch, btnAddDinner, btnMinusDinner, btnReviewOrder, btnPayment;
    private JComboBox<String> cmbSizeBreakfast, cmbSizeLunch, cmbSizeDinner;
    private JTextArea txaOrder;
    
    private static final String[] items = {"Pancakes", "Salad", "Cereals", "Yogurt",
        "Chicken Soup", "Fettuccine Alredo","Pork Sisig","Chicken with vegetable", "Mushroom Risotto","Grilled Chiken", "Seared Scallops","Steaks"};
    private int qtyBreakfast = 0;
    private int qtyLunch = 0;
    private int qtyDinner = 0;
    
    RoomService(){
        setTitle("Room Service - Hotel");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblHotelName = new JLabel("Hotel Name", SwingConstants.CENTER);
        lblHotelName.setBounds(0, 10, 600, 30);
        add(lblHotelName);
        
       
        lblBreakfast = new JLabel("Breakfast:");
        lblBreakfast.setBounds(50, 50, 100, 30);
        add(lblBreakfast);
        
        lblQtyBreakfast = new JLabel("0");
        lblQtyBreakfast.setBounds(160, 50, 100, 30);
        add(lblQtyBreakfast);
        
        btnAddBreakfast = new JButton("+");
        btnAddBreakfast.setBounds(200, 50, 50, 30);
        add(btnAddBreakfast);
        
        btnMinusBreakfast = new JButton("-");
        btnMinusBreakfast.setBounds(260, 50, 50, 30);
        add(btnMinusBreakfast);
        
        cmbSizeBreakfast = new JComboBox<>(new String[] {"Pancakes", "Sandwich", "Salad", "Cereals","Yogurt"});
        cmbSizeBreakfast.setBounds(330, 50, 120, 30);
        add(cmbSizeBreakfast);
        
        
        lblLunch = new JLabel("Lunch:");
        lblLunch.setBounds(50, 100, 100, 30);
        add(lblLunch);
        
        lblQtyLunch = new JLabel("0");
        lblQtyLunch.setBounds(160, 100, 100, 30);
        add(lblQtyLunch);
        
        btnAddLunch = new JButton("+");
        btnAddLunch.setBounds(200, 100, 50, 30);
        add(btnAddLunch);
        
        btnMinusLunch = new JButton("-");
        btnMinusLunch.setBounds(260, 100, 50, 30);
        add(btnMinusLunch);
        
        cmbSizeLunch = new JComboBox<>(new String[] {"Chicken Soup", "Fettuccine Alredo","Pork Sisig","Chicken with vegetable"});
        cmbSizeLunch.setBounds(330, 100, 120, 30);
        add(cmbSizeLunch);
        
        
        lblDinner = new JLabel("Dinner:");
        lblDinner.setBounds(50, 150, 100, 30);
        add(lblDinner);
        
        lblQtyDinner = new JLabel("0");
        lblQtyDinner.setBounds(160, 150, 100, 30);
        add(lblQtyDinner);
        
        btnAddDinner = new JButton("+");
        btnAddDinner.setBounds(200, 150, 50, 30);
        add(btnAddDinner);
        
        btnMinusDinner = new JButton("-");
        btnMinusDinner.setBounds(260, 150, 50, 30);
        add(btnMinusDinner);
        
        cmbSizeDinner = new JComboBox<>(new String[] {"Mushroom Risotto","Grilled Chicken", "Seared Scallops","Steaks"});
        cmbSizeDinner.setBounds(330, 150, 120, 30);
        add(cmbSizeDinner);
        
        
        btnReviewOrder = new JButton("Review Room Service");
        btnReviewOrder.setBounds(50, 200, 200, 30);
        add(btnReviewOrder);
        
        
        btnPayment = new JButton("Payment");
        btnPayment.setBounds(270, 200, 150, 30);
        add(btnPayment);
        
        
        txaOrder = new JTextArea();
        txaOrder.setBounds(50, 250, 500, 300);
        txaOrder.setEditable(false);
        add(txaOrder);
        
        
        btnAddBreakfast.addActionListener(this);
        btnMinusBreakfast.addActionListener(this);
        btnAddLunch.addActionListener(this);
        btnMinusLunch.addActionListener(this);
        btnAddDinner.addActionListener(this);
        btnMinusDinner.addActionListener(this);
        btnReviewOrder.addActionListener(this);
        btnPayment.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddBreakfast){
            qtyBreakfast++;
            lblQtyBreakfast.setText(String.valueOf(qtyBreakfast));
        } else if(e.getSource() == btnMinusBreakfast){
            if(qtyBreakfast > 0){
                qtyBreakfast--;
                lblQtyBreakfast.setText(String.valueOf(qtyBreakfast));
            }
        } else if(e.getSource() == btnAddLunch){
            qtyLunch++;
            lblQtyLunch.setText(String.valueOf(qtyLunch));
        } else if(e.getSource() == btnMinusLunch){
            if(qtyLunch > 0){
                qtyLunch--;
                lblQtyLunch.setText(String.valueOf(qtyLunch));
            }
        } else if(e.getSource() == btnAddDinner){
            qtyDinner++;
            lblQtyDinner.setText(String.valueOf(qtyDinner));
        } else if(e.getSource() == btnMinusDinner){
            if(qtyDinner > 0){
                qtyDinner--;
                lblQtyDinner.setText(String.valueOf(qtyDinner));
            }
        } else if(e.getSource() == btnReviewOrder){
            double totalCost = 0.0;
            
            totalCost += calculateCost(qtyBreakfast, (String)cmbSizeBreakfast.getSelectedItem());
            totalCost += calculateCost(qtyLunch, (String)cmbSizeLunch.getSelectedItem());
            totalCost += calculateCost(qtyDinner, (String)cmbSizeDinner.getSelectedItem());
            
            txaOrder.setText("Breakfast ("+cmbSizeBreakfast.getSelectedItem()+"): "+qtyBreakfast+"\n" +
            "Lunch ("+cmbSizeLunch.getSelectedItem()+"): "+qtyLunch+"\n" +
            "Dinner ("+cmbSizeDinner.getSelectedItem()+"): "+qtyDinner+"\n" +
            "Total Cost: $"+String.format("%.2f", totalCost));
        } else if(e.getSource() == btnPayment){
            double totalCost = 0.0;
            
            totalCost += calculateCost(qtyBreakfast, (String)cmbSizeBreakfast.getSelectedItem());
            totalCost += calculateCost(qtyLunch, (String)cmbSizeLunch.getSelectedItem());
            totalCost += calculateCost(qtyDinner, (String)cmbSizeDinner.getSelectedItem());
            
           
            Payment payment = new Payment();
            payment.setTotalAmount(String.format("%.2f", totalCost));
            payment.setVisible(true);
        }
    }

    private double calculateCost(int quantity, String size){
        double price = 0.0;
        switch(size){
            case "Salad":
                price = 12.00;
                break;
            case "Cereals":
                price = 10.00;
                break;
            case "Yogurt":
                price = 7.00;
                break;
            case "Pancakes":
                price = 10.50;
                break;
            case "Chicken Soup":
                price = 15.00;
                break;
            case "Fettuccine Alredo":
                price = 15.00;
                break;
            case "Pork Sisig":
                price = 15.00;
                break;   
            case "Chicken with vegetable":
                price = 15.00;
                break;
            case "Mushroom Risotto":
                price = 15.00;
                break;
            case "Grilled Chicken":
                price = 15.00;
                break;
            case "Seared Scallops":
                price = 15.00;
                break;
            case "Steaks":
                price = 15.00;
                break;   
        }
        return quantity * price;
    }
    

    
    public static void main(String[] args) {
        
            RoomService roomService = new RoomService();
            roomService.setVisible(true);
        }
 
    }

