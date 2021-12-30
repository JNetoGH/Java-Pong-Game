package com.eurostudios.IO_controllers;

import com.eurostudios.entities.Enemy;
import com.eurostudios.entities.Menu;
import com.eurostudios.entities.Player;
import com.eurostudios.game_engine_classes.GameLoop;
import com.eurostudios.game_engine_classes.AppWindow;
import com.eurostudios.game_engine_classes.Render;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    public KeyboardController() {
        AppWindow.canvas.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                Enemy.goingUp = true;
                break;
            case KeyEvent.VK_DOWN:
                Enemy.goingDown = true;
                break;
            case KeyEvent.VK_W:
                Player.goingUp = true;
                break;
            case KeyEvent.VK_S:
                Player.goingDown = true;
                break;
            case KeyEvent.VK_ESCAPE:
                Menu.isInMenu = true;
                Menu.isPVP = false;
                Menu.isPVE = false;
                Render.BackGround.resetPoints();
                GameLoop.resetEntities();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                Enemy.goingUp = false;
                break;
            case KeyEvent.VK_DOWN:
                Enemy.goingDown = false;
                break;
            case KeyEvent.VK_W:
                Player.goingUp = false;
                break;
            case KeyEvent.VK_S:
                Player.goingDown = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
