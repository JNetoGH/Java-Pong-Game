package com.eurostudios.entities;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.eurostudios.game_engine_classes.PongWindow;
import com.eurostudios.game_engine_classes.SpriteHandler;

public class Enemy implements Entity {

    public static Color enemyColor = new Color(255,0,0);
    BufferedImage sprite;

    public static boolean goingUp;
    public static boolean goingDown;
    public static double posX;
    public static double posY;
    public static double speed = 2.5;
    public static Dimension dimensions;
    public static double speedDecrement = 0.9; // (0.01 <=> 1) the lowest the easiest, because the enemy slows down, 1 == impossible

    @Override
    public void start() {
        sprite = new SpriteHandler("/vacina_2.png").getSprite();
        dimensions = new Dimension(sprite.getWidth(), sprite.getHeight());
        posX = (int) (PongWindow.WIDTH - PongWindow.MARGIN - dimensions.getWidth());
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight()/2);
    }

    @Override
    public void update() {
        if (Menu.isPVE) {
            double newPosiY = (posY + (Ball.posY - posY) - dimensions.height/2 + Ball.dimensions.height/2) * speedDecrement;
            if (!(newPosiY > PongWindow.HEIGHT - PongWindow.MARGIN - dimensions.height)) { // ! > bottom
                if (!(newPosiY < PongWindow.MARGIN)) { // ! < top
                    posY = newPosiY;
                }
            }
        }
        else if (Menu.isPVP) {
            if(goingUp) {
                if (!(posY < PongWindow.MARGIN)) {
                    posY -= speed;
                }
            }
            else if(goingDown) {
                if (!(posY + dimensions.getHeight() > PongWindow.HEIGHT - PongWindow.MARGIN)) {
                    posY += speed;
                }
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        //Bar
        graphics.setColor(enemyColor);
        graphics.fillRect((int) posX, (int) posY, 2,(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
        graphics.drawImage(sprite, (int) posX, (int) posY, null);
    }
}
