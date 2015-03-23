
package ragnarok;

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
    
    ImageIcon image = new ImageIcon("src\\ragnarok\\backgrounds\\mainback.jpg");
    
    boolean start;
    
    JFrame window = new JFrame("Hang Man");//GUI window
    JPanel mainPanel = new JPanel(); 
    JLabel pic = new JLabel();
    
    public mainMenu(){
        window.setUndecorated(true);
        pic.setIcon(image);
        pic.addMouseListener(this);
        
        window.add(pic);
        window.setSize(810, 645);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pic){
            start = true;
            window.dispose();
            JOptionPane.showMessageDialog(null, "You are the Norse god Forseti, son of Baldur who is the son \n"
                                              + "of Odin. Your father Baldur has been killed due to the misdeeds \n"
                                              + "of the wily and disloyal Norse god Loki. Take up your legendary \n"
                                              + "hammer and take revenge for your father, Forseti, and take your \n"
                                              + "place as one of the most legendary gods in history.");
            JOptionPane.showMessageDialog(null, "As you begin your journey to track down and kill the trickster \n"
                                              + "Loki you begin to encounter his evil minions. You must kill \n"
                                              + "them to countinue on your journey." );
            new Ragnarok();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
