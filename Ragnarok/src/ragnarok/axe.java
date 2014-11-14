
package ragnarok;

/**
 *
 * @author Beau Marwaha
 */
import java.awt.Image;

import javax.swing.ImageIcon;

public class axe {

    private int x, y;
    private Image image;
    boolean visible;

    private final int BOARD_WIDTH = 850;
    private final int MISSILE_SPEED = 2;

    public axe(int x, int y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("missile.jpg"));
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        x += MISSILE_SPEED;
        if (x > BOARD_WIDTH)
            visible = false;
    }
}