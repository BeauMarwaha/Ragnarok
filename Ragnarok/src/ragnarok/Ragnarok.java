
package ragnarok;

/**
 * @author Beau Marwaha
 */

/*
 * TO DO:
 * enemy track on player pos (new enemy move AI)
 * enemy hit animation
 * collision detection between enemies and player and between enemies
 * add new screen capabilities
 * player stance animation
 * character mopves too fast on home comp
 */
import javax.swing.JFrame;

public class Ragnarok extends JFrame {

    public Ragnarok() {

        add(new mainMenu());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(810, 645);
        setLocationRelativeTo(null);
        setTitle("Ragnarok Menu");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ragnarok();
    }
}