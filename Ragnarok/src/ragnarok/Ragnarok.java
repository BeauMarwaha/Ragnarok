package ragnarok;

/**
 * @author Beau Marwaha
 * @tester Kyle Lokey
 * @collab Akash Menon, James Troup
 */

/*
 * TO DO:
 * enemy track on player pos (new enemy move AI)
 * enemy hit animation
 * add player death 
 * collision detection between enemies and player and between enemies
 * character mopves too fast on home comp and with many enemies
 * implament final boss and end game
 * add items for player
 * ????
 * profit
 */
import javax.swing.JFrame;

public class Ragnarok extends JFrame {
    
    boolean done = false;

    public Ragnarok() {

        add(new window(2));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Ragnarok");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        mainMenu x = new mainMenu();
    }
}