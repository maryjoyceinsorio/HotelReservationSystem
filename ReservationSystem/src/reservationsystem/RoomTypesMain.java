/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;
import java.awt.EventQueue;
/**
 *
 * @author Nieto
 */
public class RoomTypesMain {
    
    
   public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RoomTypes sbf = new RoomTypes();
                sbf.setVisible(true);
            }
        });
    }
    
}
