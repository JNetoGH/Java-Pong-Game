package com.eurostudios.entities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import com.eurostudios.game_engine_classes.*;

public class Ball implements Entity {

    BufferedImage sprite;

    public static double speed = 3;
    public static double posX;
    public static double posY;
    public static Dimension dimensions;

    // can be 1 or -1 indicates the were the ball is going
    public static double dx;
    public static double dy;

    private double roundRandoms(double num) {
        if (num > 0) return 1;
        else return  -1;
    }

    @Override
    public void start() {
        sprite = new SpriteHandler("/covid_ball.png").getSprite();
        dimensions = new Dimension(sprite.getWidth(),sprite.getHeight());
        posX = (int) (PongWindow.WIDTH/2-dimensions.getWidth());
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight());
        dx = roundRandoms(new Random().nextGaussian());
        dy = roundRandoms(new Random().nextGaussian());
    }

    @Override
    public void update() {
        // COLLISIONS WITH WALLS
        if(posY + dx * speed + dimensions.height >= PongWindow.HEIGHT - PongWindow.MARGIN || posY + dy * speed < PongWindow.MARGIN) {
            dy *= -1;
            System.out.println();
        }

        Rectangle ballHitBox = new Rectangle((int)(posX + dx * speed), (int)(posY + dy * speed), dimensions.width, dimensions.height);
        Rectangle playerHitBox = new Rectangle((int) Player.posX, (int) Player.posY, Player.dimensions.width, Player.dimensions.height);
        Rectangle enemyHitBox = new Rectangle((int) Enemy.posX, (int) Enemy.posY, Enemy.dimensions.width, Enemy.dimensions.height);

        // COLLISIONS WITH ENTITIES: 30% of chance of change the dy in each tackle
        if (ballHitBox.intersects(playerHitBox) || ballHitBox.intersects(enemyHitBox)) {
            dx *= -1;
            int num = new Random().nextInt(10) + 1; //1<=>10
            if (num >= 8) dy*=-1;
        }

        // MOVES THE BALL
        posX += dx * speed;
        posY += dy * speed;

        if (posX > PongWindow.WIDTH) { // player point
            Render.BackGround.addPointToPlayer();
            PongGameLoop.resetEntities();
        }
        else if (posX < 0) { // enemy point
            Render.BackGround.addPointToEnemy();
            PongGameLoop.resetEntities();
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(sprite, (int) posX, (int) posY, null);
    }
}
