
package ragnarok;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 *
 * @author Beau Marwaha
 */
public class boss {
    private String mainPic = "enemy_Sprites/loki/faceL.png";
    
    Random gen = new Random();
    
    private ArrayList missiles;
    
    private double dx;
    private double dy;
    private double x;
    private double y;
    private int health;
    private boolean dead;
    private Image image;

    public boss(int health) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(mainPic));
        image = ii.getImage();
        x = 800;
        y = 275;
        this.health = health;
        dead = false;
        missiles = new ArrayList();
    }
    
    public void setImage(String pic) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(pic));
        image = ii.getImage();
        new SwingWorker() {
            @Override protected Object doInBackground() throws Exception {
                Thread.sleep(1000);
                return null;
            }
            @Override protected void done() {
                x = 5000;
                y = 5000;
            }
        }.execute();
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public int getImgW() {
        return image.getWidth(null);
    }

    public int getImgH() {
        return image.getHeight(null);
    }
    
    public int getHealth(){
        return health;
    }

    public Image getImage() {
        return image;
    }
    
    public ArrayList getMissiles() {
        return missiles;
    }
    
    public void fireLeft() {
        missiles.add(new firebolt(775, gen.nextInt(700)));
    }
    
    public void hit(int damage){
        health -= damage;
    }
}
