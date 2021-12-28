import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    static private Player player;

    KeyboardController () {
        player = PongGameLoop.player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.right = true;
                break;
            case KeyEvent.VK_LEFT:
                player.left = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.right = false;
                break;
            case KeyEvent.VK_LEFT:
                player.left = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
