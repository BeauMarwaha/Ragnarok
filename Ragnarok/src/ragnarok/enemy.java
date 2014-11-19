
package ragnarok;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Beau Marwaha
 */
public class enemy {
    private String craft = "BlueBaby.png";
    
    Random gen = new Random();
    
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    public enemy() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 600;
        y = gen.nextInt(650);
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
    
    public int getImgW() {
        return image.getWidth(null);
    }

    public int getImgH() {
        return image.getHeight(null);
    }

    public Image getImage() {
        return image;
    }

//    public void keyPressed(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_A) {
//            if(x > 0){
//                dx = -1;
//            }else{
//                dx = 0;
//            }
//        }
//
//        if (key == KeyEvent.VK_D) {
//            if(x < 500){
//                dx = 1;
//            }else{
//                dx = 0;
//            }
//        }
//
//        if (key == KeyEvent.VK_W) {
//            if(y > 0){
//                dy = -1;
//            }else{
//                dy = 0;
//            }
//        }
//
//        if (key == KeyEvent.VK_S) {
//            if(y < 500){
//                dy = 1;
//            }else{
//                dy = 0;
//            }
//        }
//    }
//
//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_A) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_D) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_W) {
//            dy = 0;
//        }
//
//        if (key == KeyEvent.VK_S) {
//            dy = 0;
//        }
//    }
}
