
package ragnarok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Beau Marwaha
 */
public class window extends JPanel implements ActionListener {

    private Timer timer;
    private player player1;
    
    private BufferedImage image;

    public void ImagePanel() {
       try {                
          image = ImageIO.read(new File("src\\ragnarok\\backgroundPic.jpg"));
       } catch (IOException ex) {
            
       }
    }
    
    public window() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player1 = new player();

        timer = new Timer(5, this);
        timer.start();
        ImagePanel();
    }


    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;

            g.drawImage(image, 0, 0, null);
            g2d.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
            
            ArrayList ms = player1.getMissiles();
            for (int i = 0; i < ms.size(); i++ ) {
                axe m = (axe) ms.get(i);
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        ArrayList ms = player1.getMissiles();
        ArrayList msd = player1.getMissilesDirections();
        
        for (int i = 0; i < ms.size(); i++) {
            axe m = (axe) ms.get(i);
            if(m.isVisible() && msd.get(i).equals("left")){
                m.moveLeft();
            }else if(m.isVisible() && msd.get(i).equals("right")){
                m.moveRight();
            }else if(m.isVisible() && msd.get(i).equals("up")){
                m.moveUp();
            }else if(m.isVisible() && msd.get(i).equals("down")){
                m.moveDown();
            }else{
                ms.remove(i);
            }
        }

        player1.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
        }
    }

}
