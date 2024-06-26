package reservationsystem;

import javax.swing.SwingUtilities;

public class SEARCHMAIN23 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Assuming you have an instance of Homepage (replace with your actual instantiation)
            Homepage homepage = new Homepage();

            // Create an instance of SEARCH77 and display it
            SEARCH77 searchFrame = new SEARCH77(homepage);
            searchFrame.setVisible(true);
        });
    }
}
    
    
