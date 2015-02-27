
package ragnarok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Beau Marwaha
 */
public class mainMenu extends JPanel implements ActionListener {
    
    ImageIcon image = new ImageIcon("src\\ragnarok\\mainback.jpg");
    JButton startButton = new JButton("Hello");
    
    boolean start;
    
    JFrame window = new JFrame("Hang Man");//GUI window
    JPanel mainPanel = new JPanel(); 
    JLabel pic = new JLabel();
    
    public mainMenu(boolean start){
        window.add(mainPanel);
        window.setSize(810, 645);
        window.setLocationRelativeTo(null); 
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.start = start;
        
        pic.setIcon(image);
        
        mainPanel.add(pic);
        mainPanel.add(startButton);
        startButton.addActionListener(this);
        
        return check(start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            start = true;
        }
    }
    
    public boolean check(boolean start){
        if(start){
            return true;
        }
        
        return false;
    }
}
