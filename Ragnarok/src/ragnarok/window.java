
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
    private enemy enemy1;
    
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

        player1 = new player(5);
        enemy1 = new enemy(5);

        timer = new Timer(1, this);
        timer.start();
        ImagePanel();
    }


    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;

            g.drawImage(image, 0, 0, null);
            g2d.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
            setEnemies(g2d);
            
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
                msd.remove(i);
            }
            
            if(((m.getX()+(m.getImgW()/2)) > (enemy1.getX()-(enemy1.getImgW()/2)) && (m.getX()-(m.getImgW()/2)) < (enemy1.getX()+(enemy1.getImgW()/2))) && 
                    ((m.getY()+(m.getImgH()/2)) > (enemy1.getY()-(enemy1.getImgH()/2)) && (m.getY()-(m.getImgH()/2)) < (enemy1.getY()+(enemy1.getImgH()/2)))){
                enemy1.hit(1);
                if(enemy1.getHealth() <= 0){
                    System.out.println("Dead");
                }
                ms.remove(i);
                msd.remove(i);
            }
        }
        if(((player1.getX()+(player1.getImgW()/2)) > (enemy1.getX()-(enemy1.getImgW()/2)) && (player1.getX()-(player1.getImgW()/2)) < (enemy1.getX()+(enemy1.getImgW()/2))) && 
                    ((player1.getY()+(player1.getImgH()/2)) > (enemy1.getY()-(enemy1.getImgH()/2)) && (player1.getY()-(player1.getImgH()/2)) < (enemy1.getY()+(enemy1.getImgH()/2)))){
                player1.hit(1);
                if(player1.getHealth() <= 0){
                    System.out.println("Player Dead");
                }
        }
        
        player1.move();
        enemy1.move(player1.getX(), player1.getY());
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
    
    public void setEnemies(Graphics2D g2d){
        g2d.drawImage(enemy1.getImage(), (int)Math.round(enemy1.getX()), (int)Math.round(enemy1.getY()), this);
    }
}
