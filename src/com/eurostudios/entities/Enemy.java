package com.eurostudios.entities;

import java.awt.*;
import com.eurostudios.game_engine_classes.PongWindow;

public class Enemy implements Entity {

    public static Color enemyColor = new Color(255,0,0);
    public static Color shadowColor = new Color(0,0,0, 30);
    public static double posX;
    public static double posY;
    public static Dimension dimensions;
    public static double speedDecrement = 0.9; // (0.01 <=> 1) the lowest the easiest, because the enemy slows down, 1 == impossible

    @Override
    public void start() {
        dimensions = new Dimension(5,15);
        posX = (int) (PongWindow.WIDTH - PongWindow.MARGIN - dimensions.getWidth());
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight()/2);
    }

    @Override
    public void update() {
        double newPosiY = (posY + (Ball.posY - posY) - dimensions.height/2 + Ball.dimensions.height/2) * speedDecrement;
        if (!(newPosiY > PongWindow.HEIGHT - PongWindow.MARGIN - dimensions.height)) { // ! > bottom
            if (!(newPosiY < PongWindow.MARGIN)) { // ! < top
                posY = newPosiY;
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        //Shadows
        graphics.setColor(shadowColor);
        graphics.fillRect((int) posX+1, (int) posY+1, (int) dimensions.getWidth(),(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
        //Bar
        graphics.setColor(enemyColor);
        graphics.fillRect((int) posX, (int) posY, (int) dimensions.getWidth(),(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
    }
}
