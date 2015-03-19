
package ragnarok;

/**
 *
 * @author Beau Marwaha
 */
import java.awt.Image;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

public class player {

    private String stance = "viking_Sprites/stance.gif";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int health;
    private boolean dead;
    private Image image;
    
    private boolean moveOveride = false;
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    
    private int fireRate = 360;
    private int n = 2;

    private ArrayList missiles;
    private ArrayList missilesDirections;

    public player(int health) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(stance));
        image = ii.getImage();
        missiles = new ArrayList();
        missilesDirections = new ArrayList();
        x = 40;
        y = 60;
        this.health = health;
        dead = false;
    }
    
    public void setImage(String x) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(x));
        image = ii.getImage();
    }
    
    public void setImageReal(Image i) {
        image = i;
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
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
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
    
    public int getFireRate() {
        return fireRate;
    }
    
    public int getN(){
        return n;
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public void hit(int damage){
        health -= damage;
        if(health <= 0){
            dead = true;
        }
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
        
        if (n == 2){
            n=1;
            if (key == KeyEvent.VK_LEFT) {
                final Image pic = image;
                fireLeft();
                setImage("viking_Sprites/swingB.gif");
                new SwingWorker() {
                    @Override protected Object doInBackground() throws Exception {
                        Thread.sleep(360);
                        return null;
                    }
                    @Override protected void done() {
                        setImageReal(pic);
                    }
                }.execute();
            }
            
            if(key == KeyEvent.VK_RIGHT){
                final Image pic = image;
                fireRight();
                setImage("viking_Sprites/swing.gif");
                new SwingWorker() {
                    @Override protected Object doInBackground() throws Exception {
                        Thread.sleep(360);
                        return null;
                    }
                    @Override protected void done() {
                        setImageReal(pic);
                    }
                }.execute();
            }

            if(key == KeyEvent.VK_UP){
                final Image pic = image;
                fireUp();
                setImage("viking_Sprites/swing.gif");
                new SwingWorker() {
                    @Override protected Object doInBackground() throws Exception {
                        Thread.sleep(360);
                        return null;
                    }
                    @Override protected void done() {
                        setImageReal(pic);
                    }
                }.execute();
            }

            if(key == KeyEvent.VK_DOWN){
                final Image pic = image;
                fireDown();
                setImage("viking_Sprites/swingB.gif");
                new SwingWorker() {
                    @Override protected Object doInBackground() throws Exception {
                        Thread.sleep(360);
                        return null;
                    }
                    @Override protected void done() {
                        setImageReal(pic);
                    }
                }.execute();
            }
            
            new SwingWorker() {
                @Override protected Object doInBackground() throws Exception {
                    Thread.sleep(fireRate);
                    return null;
                }
                @Override protected void done() {
                    n=2;
                }
            }.execute();
        }
        

        if (key == KeyEvent.VK_A) {
            if(x > 0){
                dx = -2;
                left = true;
            }else{
                x = 0;
                dx = 0;
            }
            setImage("viking_Sprites/walkingB.gif");
            moveOveride = true;
        }

        if (key == KeyEvent.VK_D) {
            if(x < 900){
                dx = 2;
                right = true;
            }else{
                x = 800;
                dx = 0;
            }
            setImage("viking_Sprites/walking.gif");
            moveOveride = true;
        }

        if (key == KeyEvent.VK_W) {
            if(y > 0){
                dy = -2;
                up = true;
            }else{
                y = 0;
                dy = 0;
            }
            if(!moveOveride){
                setImage("viking_Sprites/walking.gif");
            }
            
        }

        if (key == KeyEvent.VK_S) {
            if(y < 700){
                dy = 2;
                down = true;
            }else{
                y = 570;
                dy = 0;
            }
            if(!moveOveride){
                setImage("viking_Sprites/walkingB.gif");
            }
        }
    }

    public void fireUp() {
        missiles.add(new axe(x + image.getWidth(null)/3, y + image.getHeight(null)/100));
        missilesDirections.add(new String("up"));
    }
    
    public void fireDown() {
        missiles.add(new axe(x + image.getWidth(null)/3, y + image.getHeight(null)/2));
        missilesDirections.add(new String("down"));
    }
    
    public void fireLeft() {
        missiles.add(new axe(x - image.getWidth(null)/100, y + image.getHeight(null)/4));
        missilesDirections.add(new String("left"));
    }
    
    public void fireRight() {
        missiles.add(new axe(x + image.getWidth(null)/2, y + image.getHeight(null)/4));
        missilesDirections.add(new String("right"));
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            left = false;
            moveOveride = false;
            dx = 0;
            if (!right && !down && !up){
                setImage("viking_Sprites/stanceB.gif");
            }
        }

        if (key == KeyEvent.VK_D) {
            right = false;
            moveOveride = false;
            dx = 0;
            if (!left && !down && !up){
                setImage("viking_Sprites/stance.gif");
            }
        }

        if (key == KeyEvent.VK_W) {
            up = false;
            dy = 0;
            if (!left && !down && !right){
                setImage("viking_Sprites/stance.gif");
            }
        }

        if (key == KeyEvent.VK_S) {
            down = false;
            dy = 0;
            if (!right && !left && !up){
                setImage("viking_Sprites/stanceB.gif");
            }
        }
    }
}
