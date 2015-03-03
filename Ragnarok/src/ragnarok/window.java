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
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author Beau Marwaha
 */
public class window extends JPanel implements ActionListener {

    private Timer timer;
    private player player1;
    private enemy[] enemyReal = new enemy[3];
    
    private int stageNumber = 1;
    
    private BufferedImage image;
    
    private boolean newLevelTime = false;
    
    int z = 0;

    public window() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\mainback.jpg"));
        } catch (IOException ex) {

        }
        
        player1 = new player(5);
        newlevel(player1, 40);
        
        timer = new Timer(0, this);
        timer.start();
        
        
        
        
//        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
//        ActionMap am = getActionMap();

        // Key controls...
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "upPressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "downPressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "leftPressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "rightPressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "upReleased");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "downReleased");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "leftReleased");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "rightReleased");
        
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "upFirePressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "downFirePressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "leftFirePressed");
//        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "rightFirePressed");

//        am.put("upPressed", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getY() > 0){
//                    player1.setdy(-2);
//                }else{
//                    player1.setY(0);
//                    player1.setdy(0);
//                }
//            }
//
//        });
//        
//        am.put("upReleased", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getY() > 0){
//                    player1.setdy(0);
//                }else{
//                    player1.setY(0);
//                    player1.setdy(0);
//                }
//            }
//
//        });
//        
//        am.put("downPressed", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getY() < 700){
//                    player1.setdy(2);
//                }else{
//                    player1.setY(570);
//                    player1.setdy(0);
//                }
//            }
//
//        });
//        
//        am.put("downReleased", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getY() < 700){
//                    player1.setdy(0);
//                }else{
//                    player1.setY(570);
//                    player1.setdy(0);
//                }
//            }
//
//        });
//        
//        am.put("leftPressed", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getX() > 0){
//                    player1.setdx(-2);
//                }else{
//                    player1.setX(0);
//                    player1.setdx(0);
//                }
//                player1.setImage("viking_Sprites/walkingB.gif");
//            }
//
//        });
//        
//        am.put("leftReleased", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getX() > 0){
//                    player1.setdx(0);
//                }else{
//                    player1.setX(0);
//                    player1.setdx(0);
//                }
//            }
//
//        });
//        
//        am.put("rightPressed", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getX() < 900){
//                    player1.setdx(2);
//                }else{
//                    player1.setX(800);
//                    player1.setdx(0);
//                }
//                player1.setImage("viking_Sprites/walking.gif");
//            }
//
//        });
//        
//        am.put("rightReleased", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(player1.getX() < 900){
//                    player1.setdx(0);
//                }else{
//                    player1.setX(800);
//                    player1.setdx(0);
//                }
//            }
//
//        });
        
//        am.put("upFireReleased", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                player1.fireUp();
//            }
//
//        });
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
            
            if(newLevelTime){
                timer.stop();
                g2d.dispose();
                stageNumber += 1;
                newLevelTime = false;
                newlevel(player1, player1.getY());
                JOptionPane.showMessageDialog(null, "Ready to begin stage " + stageNumber + "?");
                timer.start();
            }
            
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
            }
            
            hitCheck: for (int j = 0; j < 3; j++){
                if(((m.getX()+(m.getImgW()/2)) > (enemyReal[j].getX()-(10/2)) && (m.getX()-(m.getImgW()/2)) < (enemyReal[j].getX()+(150/2))) && 
                        ((m.getY()+(m.getImgH()/2)) > (enemyReal[j].getY()-(100/2)) && (m.getY()-(m.getImgH()/2)) < (enemyReal[j].getY()+(100/2)))){
                    enemyReal[j].hit(1);
                    System.out.println("w " + enemyReal[j].getImgW());
                    System.out.println("h " + enemyReal[j].getImgH());
                    if(enemyReal[j].getHealth() <= 0){
                        System.out.println("Dead");
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
        }
        int deadCount = 0;
        for (int j = 0; j < 3; j++){
            if(enemyReal[j].getHealth() <= 0){
                deadCount += 1;
            }
            if (deadCount == 3){
                newLevelTime = true;
            }
        }
        deadCount = 0;
        
        for (int i = 0; i < 3; i++){
            if(((player1.getX()+(player1.getImgW()/2)) > (enemyReal[i].getX()-(10/2)) && (player1.getX()-(player1.getImgW()/2)) < (enemyReal[i].getX()+(150/2))) && 
            ((player1.getY()+(player1.getImgH()/2)) > (enemyReal[i].getY()-(100/2)) && (player1.getY()-(player1.getImgH()/2)) < (enemyReal[i].getY()+(100/2)))){
                player1.hit(1);
                if(player1.getHealth() <= 0){
                    System.out.println("Player Dead " + player1.getHealth());
                }
            }
        }
        
        
        player1.move();
        //enemy0
        if(collision(enemyReal[1].getX(), enemyReal[1].getY(), enemyReal[0].getX(), enemyReal[0].getY(), enemyReal[0].getImgW(), enemyReal[0].getImgH())){
            enemyReal[0].moveY(player1.getY());
            enemyReal[0].moveX(player1.getX());
        }else{
            enemyReal[0].moveY(0);
            enemyReal[0].moveX(0);
        }
        if(collision(enemyReal[2].getX(), enemyReal[2].getY(), enemyReal[0].getX(), enemyReal[0].getY(), enemyReal[0].getImgW(), enemyReal[0].getImgH())){
            enemyReal[0].moveY(player1.getY());
            enemyReal[0].moveX(player1.getX());
        }else{
            enemyReal[0].moveY(0);
            enemyReal[0].moveX(0);
        }
        //enemy1
        if(collision(enemyReal[0].getX(), enemyReal[0].getY(), enemyReal[1].getX(), enemyReal[1].getY(), enemyReal[1].getImgW(), enemyReal[1].getImgH())){
            enemyReal[1].moveY(player1.getY());
            enemyReal[1].moveX(player1.getX());
        }else{
            enemyReal[1].moveY(0);
            enemyReal[1].moveX(0);
        }
        if(collision(enemyReal[2].getX(), enemyReal[2].getY(), enemyReal[1].getX(), enemyReal[1].getY(), enemyReal[1].getImgW(), enemyReal[1].getImgH())){
            enemyReal[1].moveY(player1.getY());
            enemyReal[1].moveX(player1.getX());
        }else{
            enemyReal[1].moveY(0);
            enemyReal[1].moveX(0);
        }
        //enemy2
        if(collision(enemyReal[1].getX(), enemyReal[1].getY(), enemyReal[2].getX(), enemyReal[2].getY(), enemyReal[2].getImgW(), enemyReal[2].getImgH())){
            enemyReal[2].moveY(player1.getY());
            enemyReal[2].moveX(player1.getX());
        }else{
            enemyReal[2].moveY(0);
            enemyReal[2].moveX(0);
        }
        if(collision(enemyReal[0].getX(), enemyReal[0].getY(), enemyReal[2].getX(), enemyReal[2].getY(), enemyReal[2].getImgW(), enemyReal[2].getImgH())){
            enemyReal[2].moveY(player1.getY());
            enemyReal[2].moveX(player1.getX());
        }else{
            enemyReal[2].moveY(0);
            enemyReal[2].moveX(0);
        }
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
        for (int i = 0; i < 3; i++){
             g2d.drawImage(enemyReal[i].getImage(), (int)Math.round(enemyReal[i].getX()), (int)Math.round(enemyReal[i].getY()), this);
        }
        
    }
    
    final public void newlevel(player x, int oldPlayerY){
        
        player1 = x;
        player1.setX(40);
        player1.setY(oldPlayerY);
        for (int i = 0; i < 3; i++){
            enemyReal[i] = new enemy(5);
        }
        
        try {                
           image = ImageIO.read(new File("src\\ragnarok\\back1.png"));
        } catch (IOException ex) {

        }
    }
}
