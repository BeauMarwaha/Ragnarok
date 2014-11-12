
package ragnarok;

import javax.swing.*;

/**
 *
 * @author Beau Marwaha
 */
public class window {
    
    JFrame window = new JFrame("Ragnarok");
    
    
    public window() {
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        
    }
}
