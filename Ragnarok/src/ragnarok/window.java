
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 * @author Beau Marwaha
 */
public class window extends JPanel implements ActionListener {

    private Timer timer;
    private player player1;
    private boss[] loki = new boss[1];
    private enemy[] enemyReal = new enemy[100];
    
    private int stageNumber = 1;
    private int enemyCount;
    private int bossCount = 0;
    private int load = 0;
    
    private boolean newLevelTime = false;
    
    private BufferedImage image;
    ArrayList ms;
    ArrayList msd;
    ArrayList msE;
    ArrayList msdE;
    
    public window(int enemyCount) {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        this.enemyCount = enemyCount;
        
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\backgrounds\\back1.jpg"));
        } catch (IOException ex) {

        }
        
        player1 = new player(10);
        newLevel(player1, 40, enemyCount);
        
        timer = new Timer(0, this);
        timer.start();
        
    }

    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;

            g.drawImage(image, 0, 0, null);
            g2d.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
            setEnemies(g2d);
            
            if(player1.getX() < 0){
                player1.setX(0);
            }

            if(player1.getX() > 800){
                player1.setX(800);
            }

            if(player1.getY() < 0){
                player1.setY(0); 
            }

            if(player1.getY() > 570){
                player1.setY(570); 
            }
            
            ms = player1.getMissiles();
            for (int i = 0; i < ms.size(); i++ ) {
                axe m = (axe) ms.get(i);
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
            
            if(newLevelTime){
                timer.stop();
                g2d.dispose();
                stageNumber += 4;
                enemyCount += 1;
                newLevelTime = false;
                ms.removeAll(ms);
                msd.removeAll(msd);
                if(stageNumber == 5){
                    newBossLevel(player1, player1.getY(), 0);
                    JOptionPane.showMessageDialog(null, "You have reached the layer of the trickster \n" + 
                                                        "Loki, prepare to face in him in Mortal Combat");
                    JOptionPane.showMessageDialog(null, "Watch out! Loki's foul magik has impaired you, \n" + 
                                                        "Your speed and attacking abilities have been \n" +
                                                        "severly impacted.");
                }else{
                    newLevel(player1, player1.getY(), enemyCount);
                    JOptionPane.showMessageDialog(null, "Ready to begin stage " + stageNumber + "?");
                }
                timer.start();
            }
            
            if(stageNumber == 5 && load >= 1){
                msE = loki[0].getMissiles();
                for (int i = 0; i < msE.size(); i++ ) {
                    firebolt m = (firebolt)msE.get(i);
                    g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
                }
            }
            
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
            
            if(stageNumber == 5 && player1.getN() != 2){
                new SwingWorker() {
                    @Override protected Object doInBackground() throws Exception {
                        Thread.sleep(700);
                        return null;
                    }
                    @Override protected void done() {
                        player1.setN(2);
                    }
                }.execute();
            }
            
    }

    public void actionPerformed(ActionEvent e) {
        ms = player1.getMissiles();
        msd = player1.getMissilesDirections();
        
        for (int i = 0; i < ms.size(); i++) {
            axe m = (axe)ms.get(i);
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
            
            if (stageNumber != 5){
                hitCheck: for (int j = 0; j < enemyCount; j++){
                    if(((m.getX()+(m.getImgW()/2)) > (enemyReal[j].getX()-(10/2)) && (m.getX()-(m.getImgW()/2)) < (enemyReal[j].getX()+(150/2))) && 
                            ((m.getY()+(m.getImgH()/2)) > (enemyReal[j].getY()-(100/2)) && (m.getY()-(m.getImgH()/2)) < (enemyReal[j].getY()+(100/2)))){
                        enemyReal[j].hit(1);
                        if(enemyReal[j].getHealth() <= 0){
                            enemyReal[j].setImage("enemy_Sprites/goblin/ongroundGob.gif");
                        }

                        try {
                            if (ms.get(i) != null){
                                ms.remove(i);
                                msd.remove(i);
                                break hitCheck;
                            }
                        } catch ( IndexOutOfBoundsException b ) {

                        }

                    }
                }
            }else if (stageNumber == 5){
                if(((m.getX()+(m.getImgW()/2)) > (loki[0].getX()) && (m.getX()-(m.getImgW()/2)) < loki[0].getX()+(loki[0].getImgW()/2)) && 
                    ((m.getY()+(m.getImgH()/2)) > (loki[0].getY()) && (m.getY()-(m.getImgH()/2)) < loki[0].getY()+(loki[0].getImgH()/2))){
                    loki[0].hit(1);
                    try {
                        if (ms.get(i) != null){
                            ms.remove(i);
                            msd.remove(i);
                        }
                    } catch ( IndexOutOfBoundsException b ) {

                    }

                }
                
                if(loki[0].getHealth() == 0){
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Excellent work Forseti. You have defeated \n"
                                                      + "Loki and avenged your father. \n"
                                                      + "YOU WIN!");
                    System.exit(0);
                }
            }
        }
        int deadCount = 0;
        for (int j = 0; j < enemyCount; j++){
            if(enemyReal[j].getHealth() <= 0){
                deadCount += 1;
            }
            if (deadCount == enemyCount && stageNumber != 5){
                newLevelTime = true;
            }
        }
        deadCount = 0;
        
        
        
        if (stageNumber == 5){
            loki[0].fireLeft();
            
            msE = loki[0].getMissiles();
            
            for (int i = 0; i < msE.size(); i++) {
                firebolt m = (firebolt)msE.get(i);
                if(m.isVisible()){
                    m.moveLeft();
                }else{
                    try {
                        if (msE.get(i) != null){
                            msE.remove(i);
                            msdE.remove(i);
                        }
                    } catch (NullPointerException b ) {}
                }

                if(((m.getX()+(m.getImgW()/2)) > (player1.getX()) && (m.getX()-(m.getImgW()/2)) < player1.getX()+(player1.getImgW()/2)) && 
                    ((m.getY()+(m.getImgH()/2)) > (player1.getY()) && (m.getY()-(m.getImgH()/2)) < player1.getY()+(player1.getImgH()/2))){
                    player1.hit(1);
                    try {
                        if (msE.get(i) != null){
                            msE.remove(i);
                            msdE.remove(i);
                        }
                    }catch (NullPointerException b ) {}

                    if(player1.getHealth() <= 0){
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "You have fought bravely but it was not enough. \n"
                                                          + "You fell trying to complete Stage: " + stageNumber + "\n"
                                                          + "YOU LOSE");
                        System.exit(0);
                    }
                }
            }
        }
        
        if (stageNumber != 5){
            for (int i = 0; i < enemyCount; i++){
                if(((player1.getX()+(player1.getImgW()/2)) > (enemyReal[i].getX()-(10/2)) && (player1.getX()-(player1.getImgW()/2)) < (enemyReal[i].getX()+(150/2))) && 
                ((player1.getY()+(player1.getImgH()/2)) > (enemyReal[i].getY()-(100/2)) && (player1.getY()-(player1.getImgH()/2)) < (enemyReal[i].getY()+(100/2)))){
                    player1.hit(1);
                    enemyReal[i].hit(0);
                    if(player1.getHealth() <= 0){
                        timer.stop();
                        JOptionPane.showMessageDialog(null, "You have fought bravely but it was not enough. \n"
                                                          + "You fell trying to complete Stage: " + stageNumber + "\n"
                                                          + "YOU LOSE");
                        System.exit(0);
                    }
                }
            }
            
            for(int enemyFocus = 0; enemyFocus < enemyCount; enemyFocus++){
                for(int enemyChecking = 0; enemyChecking < enemyCount; enemyChecking++){
                    if (enemyFocus != enemyChecking){
                        if(collision(enemyReal[enemyChecking].getX(), enemyReal[enemyChecking].getY(), enemyReal[enemyFocus].getX(), enemyReal[enemyFocus].getY(), enemyReal[enemyFocus].getImgW(), enemyReal[enemyFocus].getImgH())){
                            enemyReal[enemyFocus].moveY(player1.getY());
                            enemyReal[enemyFocus].moveX(player1.getX());
                        }else{
                            enemyReal[enemyFocus].moveY(0);
                            enemyReal[enemyFocus].moveX(0);
                        }
                    }
                }
            }
        }
        player1.move();
        
        repaint();  
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
        }
    }
    
    public boolean collision(double x1, double y1, double x2, double y2, int imgW2, int imgH2){
        if(x1 > x2 && x1 < x2 + imgW2){
            if(y1 > y2 && y1 < y2 + imgH2){
            return false;
            } 
        }
        return true;
    }
    
    public void setEnemies(Graphics2D g2d){
        for (int i = 0; i < enemyCount; i++){
            g2d.drawImage(enemyReal[i].getImage(), (int)Math.round(enemyReal[i].getX()), (int)Math.round(enemyReal[i].getY()), this);
        }
        for (int i = 0; i < bossCount; i++){
            g2d.drawImage(loki[i].getImage(), (int)Math.round(loki[i].getX()), (int)Math.round(loki[i].getY()), this);
        }
    }
    
    final public void newLevel(player x, int oldPlayerY, int enemyCount){
        
        player1 = x;
        player1.setX(40);
        player1.setY(oldPlayerY);
        for (int i = 0; i < enemyCount; i++){
            enemyReal[i] = new enemy(5);
        }
        
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\backgrounds\\back1.png"));
        } catch (IOException ex) {

        }
    }
    
    final public void newBossLevel(player x, int oldPlayerY, int enemyCount){
        
        player1 = x;
        player1.setX(40);
        player1.setY(oldPlayerY);
        this.enemyCount = 0;
        bossCount = 1;
        loki[0] = new boss(20);
        load += 1;
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\backgrounds\\back2.png"));
        } catch (IOException ex) {

        }
    }
}
