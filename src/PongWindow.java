import javax.swing.*;
import java.awt.*;

public class PongWindow {

    public static JFrame frame = new JFrame();
    public static Canvas canvas = new  Canvas();
    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 3; //multiplies everything in the Canvas

    public PongWindow () {
        initCanvas();
        initFrame();
    }

    private void initCanvas() {
        canvas.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
    }

    private void initFrame() {
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when x is pressed uses the System.exit() to kill everything
        frame.add(canvas); // adds a Canvas to the Frame
        frame.pack();
        frame.setLocationRelativeTo(null); // sets the default location in the middle of the screen
        frame.setVisible(true); // shows the frame
    }
}
