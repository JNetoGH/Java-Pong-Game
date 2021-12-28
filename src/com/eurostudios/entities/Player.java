package com.eurostudios.entities;

import java.awt.*;
import com.eurostudios.game_engine_classes.PongWindow;

public class Player implements Entity{

    public static boolean goingUp;
    public static boolean goingDown;
    public static int posX;
    public static int posY;
    public static Dimension dimensions;


    @Override
    public void start() {
        dimensions = new Dimension(5,15);
        posX = PongWindow.MARGIN;
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight()/2);
    }

    @Override
    public void update() {
        if(goingUp) {
            if (!(posY < + PongWindow.MARGIN)) {
                posY--;
            }
        }
        else if(goingDown) {
            if (!(posY + dimensions.getHeight() > PongWindow.HEIGHT - PongWindow.MARGIN)) {
                posY++;
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.CYAN); // picking a color or you can set manually g.setColor(new Color(19,19,19));
        graphics.fillRect(posX, posY, (int) dimensions.getWidth(),(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
    }
}
