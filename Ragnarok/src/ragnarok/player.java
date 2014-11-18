
package ragnarok;

/**
 *
 * @author Beau Marwaha
 */
import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class player {

    private String craft = "Cain.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    private ArrayList missiles;
    private ArrayList missilesDirections;
    
    private final int CRAFT_SIZE = 20;

    public player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        missiles = new ArrayList();
        missilesDirections = new ArrayList();
        x = 40;
        y = 60;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public ArrayList getMissiles() {
        return missiles;
    }
    
    public ArrayList getMissilesDirections() {
        return missilesDirections;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            fireLeft();
        }
        
        if(key == KeyEvent.VK_RIGHT){
            fireRight();
        }
        
        if(key == KeyEvent.VK_UP){
            fireUp();
        }
        
        if(key == KeyEvent.VK_DOWN){
            fireDown();
        }

        if (key == KeyEvent.VK_A) {
            if(x > 0){
                dx = -1;
            }else{
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_D) {
            if(x < 500){
                dx = 1;
            }else{
                dx = 0;
            }
        }

        if (key == KeyEvent.VK_W) {
            if(y > 0){
                dy = -1;
            }else{
                dy = 0;
            }
        }

        if (key == KeyEvent.VK_S) {
            if(y < 500){
                dy = 1;
            }else{
                dy = 0;
            }
        }
    }

    public void fireUp() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("up"));
    }
    
    public void fireDown() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("down"));
    }
    
    public void fireLeft() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("left"));
    }
    
    public void fireRight() {
        missiles.add(new axe(x + CRAFT_SIZE, y + CRAFT_SIZE/2));
        missilesDirections.add(new String("right"));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}
