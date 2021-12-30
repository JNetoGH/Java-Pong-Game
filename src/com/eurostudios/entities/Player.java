package com.eurostudios.entities;

import java.awt.*;
import java.awt.image.BufferedImage;


import com.eurostudios.game_engine_classes.Entity;
import com.eurostudios.game_engine_classes.PongWindow;
import com.eurostudios.game_engine_classes.SpriteHandler;

public class Player implements Entity {

    public static boolean goingUp;
    public static boolean goingDown;
    public static double speed;
    public static double posX;
    public static double posY;
    public static Dimension dimensions;

    BufferedImage sprite;
    public static Color shadowColor = new Color(0,0,0, 30);

    @Override
    public void start() {
        speed = 2.5;
        sprite = new SpriteHandler("/vacina_1.png").getSprite();
        dimensions = new Dimension(sprite.getWidth(),sprite.getHeight());
        posX = PongWindow.MARGIN;
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight()/2);
    }

    @Override
    public void update() {
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

    @Override
    public void render(Graphics graphics) {
        //Bar
        graphics.setColor(new Color(0,156,135)); // picking a color or you can set manually g.setColor(new Color(19,19,19));
        graphics.fillRect((int) dimensions.getWidth()+PongWindow.MARGIN-2, (int) posY, 2,(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
        graphics.drawImage(sprite, (int) posX, (int) posY, null);
    }
}
