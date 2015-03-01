
package ragnarok;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Beau Marwaha
 */
public class mainMenu extends JPanel implements MouseListener {
    
    ImageIcon image = new ImageIcon("src\\ragnarok\\mainback.jpg");
    
    boolean start;
    
    JFrame window = new JFrame("Hang Man");//GUI window
    JPanel mainPanel = new JPanel(); 
    JLabel pic = new JLabel();
    
    public mainMenu(){
        window.setUndecorated(true);
        pic.setIcon(image);
        mainPanel.add(pic);
        pic.addMouseListener(this);
        
        window.add(mainPanel);
        window.setSize(810, 645);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pic){
            start = true;
            System.out.println("A");
            window.dispose();
            JOptionPane.showMessageDialog(null, "Put intro text here...");
            new Ragnarok();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
