package com.eurostudios.entities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.eurostudios.game_engine_classes.*;

public class Menu implements Entity, MouseListener {

    public static boolean isInMenu = true;
    public static boolean isPVP = false;
    public static boolean isPVE = false;


    public static Color shadowColor = new Color(0,0,0, 30);
    private Rectangle button1 = new Rectangle(20, 40, 50,25);
    private Rectangle button2 = new Rectangle(button1.x+button1.width+30, 40, 50,25);
    public static boolean isButton1Pressed = false;
    public static boolean isButton2Pressed = false;

    public Menu() {
        PongWindow.canvas.addMouseListener(this);
    }

    @Override
    public void start() {}
    @Override
    public void update() {}

    @Override
    public void render(Graphics graphics) {
        if (!isButton1Pressed) {
            graphics.setColor(shadowColor);
            graphics.fillRect(button1.x+3, button1.y+3, button1.width, button1.height);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(button1.x, button1.y, button1.width, button1.height);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawString("PVP", button1.x + 14, button1.y + 18);
        }
        else {
            graphics.setColor(shadowColor);
            graphics.fillRect(button1.x+3, button1.y+3, button1.width, button1.height);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(button1.x+1, button1.y+1, button1.width, button1.height);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawString("PVP", button1.x + 14 +1, button1.y + 18 +1);
            graphics.setColor(shadowColor);
            graphics.fillRect(button1.x+1, button1.y+1, button1.width, button1.height);
        }

        if (!isButton2Pressed) {
            graphics.setColor(shadowColor);
            graphics.fillRect(button2.x+3, button2.y+3, button2.width, button2.height);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(button2.x, button2.y, button2.width, button2.height);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawString("PVE", button2.x + 14, button2.y + 18);
        }
        else {
            graphics.setColor(shadowColor);
            graphics.fillRect(button2.x+3, button2.y+3, button2.width, button2.height);
            graphics.setColor(Color.WHITE);
            graphics.fillRect(button2.x+1, button2.y+1, button2.width, button2.height);
            graphics.setColor(Color.DARK_GRAY);
            graphics.drawString("PVE", button2.x + 14 +1, button2.y + 18 +1);
            graphics.setColor(shadowColor);
            graphics.fillRect(button2.x+1, button2.y+1, button2.width, button2.height);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isInMenu) {
            int axisX = e.getX()/PongWindow.SCALE;
            int axisY = e.getY()/PongWindow.SCALE;
            if (axisX >= button1.x && axisX <= button1.x+button1.width && axisY >= button1.y && axisY <= button1.y + button1.height) {
                isButton1Pressed = true;
            }
            if (axisX >= button2.x && axisX <= button2.x+button2.width && axisY >= button2.y && axisY <= button2.y + button2.height) {
                isButton2Pressed = true;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (isButton1Pressed) {
            isButton1Pressed = false;
            isInMenu = false;
            isPVP = true;
            PongGameLoop.resetEntities();
        }
        else if (isButton2Pressed) {
            isButton2Pressed = false;
            isInMenu = false;
            isPVE = true;
            PongGameLoop.resetEntities();
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
