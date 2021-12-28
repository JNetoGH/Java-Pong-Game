package com.eurostudios.game_engine_classes;

import javax.swing.*;
import java.awt.*;

public class PongWindow {

    public static final String FRAME_NAME = "Super Pong";
    public static JFrame frame = new JFrame(FRAME_NAME);
    public static Canvas canvas = new  Canvas();
    public static final int WIDTH = 170;
    public static final int HEIGHT = 140;
    public static final int MARGIN = 10;
    public static final int SCALE = 3; //multiplies everything in the Canvas

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
        JButton button = new JButton("Press");
        //BoxLayout boxLayout = new BoxLayout();
        frame.getContentPane().add(button);
        frame.setVisible(true); // shows the frame
    }
}
