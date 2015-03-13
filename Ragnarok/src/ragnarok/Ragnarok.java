package ragnarok;

/**
 * @author Beau Marwaha
 * @tester Kyle Lokey
 * @collab Akash Menon, James Troup
 */

/*
 * TO DO:
 * create loki throwing object
 * enemy pictures change fix
 * playr picture change fix
 * collision detection between enemies
 * implement final boss and end game
 * add items for player 
 * enemy track on player pos (new enemy move AI
 * character mopves too fast on home comp and with many enemies
 * ????
 * profit
 */
import javax.swing.JFrame;

public class Ragnarok extends JFrame {
    
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