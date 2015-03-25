package ragnarok;

/**
 * @author Beau Marwaha
 * @tester Kyle Lokey
 * @collab Akash Menon, James Troup
 */

/*
 * TO DO:
 *
 * Possible Future Improvements: 
 * better collision detection between enemies
 * items for player
 * enemy track on player pos (new enemy movement AI)
 * sprite movement speed varies between systems and some levels
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