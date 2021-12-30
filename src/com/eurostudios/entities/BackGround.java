package com.eurostudios.entities;

import com.eurostudios.game_engine_classes.AppWindow;
import com.eurostudios.game_engine_classes.Entity;

import java.awt.*;

public class BackGround implements Entity {

    private static int playerPoints;
    private static int enemyPoints;
    public static void addPointToPlayer() {playerPoints++;}
    public static void addPointToEnemy() {enemyPoints++;}
    public static void resetPoints() {
        playerPoints = 0;
        enemyPoints = 0;
    }


    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(0,0, AppWindow.WIDTH, AppWindow.HEIGHT);
        graphics.setColor(Color.gray);
        graphics.fillRect(AppWindow.WIDTH/2-1, AppWindow.MARGIN, 3, AppWindow.HEIGHT - AppWindow.MARGIN*2);
        graphics.drawString("esc => menu", AppWindow.WIDTH/2-35, AppWindow.HEIGHT);
        // Scoreboard
        graphics.setColor(Color.gray);
        graphics.drawString(String.valueOf(playerPoints), AppWindow.WIDTH/2-26, 20);
        graphics.drawString(String.valueOf(enemyPoints), AppWindow.WIDTH/2+20, 20);
    }
}
