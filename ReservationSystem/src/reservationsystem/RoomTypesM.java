/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservationsystem;

import java.awt.EventQueue;
import java.util.Date;
import javax.swing.SwingUtilities;

/**
 *
 * @author user
 */
public class RoomTypesM {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
                  EventQueue.invokeLater(new Runnable() {
          

             @Override
             public void run() {
                RoomTypes roomTypes = new RoomTypes("", new Date(), new Date(), "");
             }
        });
    }
}
      
      
      
      
      
      
 
