
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
 */
import javax.swing.JFrame;

public class Ragnarok extends JFrame {

    public Ragnarok() {

        add(new window());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Ragnarok");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ragnarok();
    }
}