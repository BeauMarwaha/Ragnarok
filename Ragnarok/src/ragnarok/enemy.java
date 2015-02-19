
package ragnarok;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Beau Marwaha
 */
public class enemy {
    private String walkL = "enemy_Sprites/goblin/walkGob.gif";
    private String walkR = "enemy_Sprites/goblin/walkGob.gif";
    private String attackL = "enemy_Sprites/goblin/walkGob.gif";
    private String attackR = "enemy_Sprites/goblin/walkGob.gif";
    
    Random gen = new Random();
    
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
        y = gen.nextInt(650);
        this.health = health;
        dead = false;
    }


    public void moveX(int playerX) {
        if(!dead){
            if(playerX > x){
                dx = .3;
            }else if(playerX < x){
                dx = -.3;
            }
            x += dx;
        }
    }
    
    public void moveY(int playerY) {
        if(!dead){
            if(playerY > y){
                dy = .3;
            }else if(playerY < y){
                dy = -.3;
            }
            y += dy;
        }
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
            dead = true;
            x = 5000;
            y = 5000;
        }
    }
}
