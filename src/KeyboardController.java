import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    static private Player player;

    KeyboardController () {
        player = PongGameLoop.player;
        PongWindow.canvas.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                player.goingUp = true;
                break;
            case KeyEvent.VK_DOWN:
                player.goingDown = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                player.goingUp = false;
                break;
            case KeyEvent.VK_DOWN:
                player.goingDown = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
