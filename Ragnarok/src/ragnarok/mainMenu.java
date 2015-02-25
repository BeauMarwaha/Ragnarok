
package ragnarok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Beau Marwaha
 */
public class mainMenu extends JPanel implements ActionListener {
    
    private BufferedImage image;
    
    
    public mainMenu(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\mainback.jpg"));
        } catch (IOException ex) {

        }
    }
    
    public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(image, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
