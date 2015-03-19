
package ragnarok;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 *
 * @author Beau Marwaha
 */
public class enemy {
    private String walkL = "enemy_Sprites/goblin/pauseGob.gif";
    
    Random gen = new Random();
    
    private boolean knockback = false;
    
    private double dx;
    private double dy;
    private double x;
    private double y;
    private int health;
    private boolean dead;
    private Image image;

    public enemy(int health) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(walkL));
        image = ii.getImage();
        x = 600;
        y = gen.nextInt(500);
        this.health = health;
        dead = false;
    }
    
    public void setImage(String pic) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(pic));
        image = ii.getImage();
        if(health <= 0){
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
    }
 
    public void moveX(int playerX) {
        if(!dead){
            if(playerX > x){
                dx = .3;
            }else if(playerX < x){
                dx = -.3;
            }
            if(!knockback){
                x += dx;
            }else{
                x += dx * -1;
            }
            
            if(dx > 0){
                setImage("enemy_Sprites/goblin/walkGobR.gif");
            }else{
                setImage("enemy_Sprites/goblin/walkGobL.gif");
            }
        }
    }
    
    public void moveY(int playerY) {
        if(!dead){
            if(playerY > y){
                dy = .3;
            }else if(playerY < y){
                dy = -.3;
            }
            if(!knockback){
                y += dy;
            }else{
                y += dy * -1;
            }
        }
    }
    
    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
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
    
    public void hit(int damage){
        health -= damage;
        if(health <= 0){
            if(dx > 0){
                setImage("enemy_Sprites/goblin/deathGobR.gif");
            }else{
                setImage("enemy_Sprites/goblin/deathGobL.gif");
            }
            dead = true;
        }
        if(!dead){
            knockback = true;
            new SwingWorker() {
                @Override protected Object doInBackground() throws Exception {
                    Thread.sleep(500);
                    return null;
                }
                @Override protected void done() {
                    knockback = false;
                }
            }.execute();
        }
        
    }
}
