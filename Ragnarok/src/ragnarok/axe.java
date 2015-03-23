
package ragnarok;

/**
 *
 * @author Beau Marwaha
 */
import java.awt.Image;

import javax.swing.ImageIcon;

public class axe {

    private int x, y;
    final private Image IMAGE;
    boolean visible;

    private final int BOARD_WIDTH = 950;
    private final int BOARD_HEIGHT = 950;
    private final int MISSILE_SPEED = 2;

    public axe(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("hammerspin.gif"));
        IMAGE = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return IMAGE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getImgW() {
        return IMAGE.getWidth(null);
    }

    public int getImgH() {
        return IMAGE.getHeight(null);
    }

    public boolean isVisible() {
        return visible;
    }

    public void moveUp() {
        y -= MISSILE_SPEED;
        if (x < 0){
            visible = false;
        }
    }
    
    public void moveDown() {
        y += MISSILE_SPEED;
        if (x > BOARD_HEIGHT){
            visible = false;
        }
    }
    
    public void moveLeft() {
        x -= MISSILE_SPEED;
        if (x < 0){
            visible = false;
        }
    }
    
    public void moveRight() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH){
            visible = false;
        }
    }
}