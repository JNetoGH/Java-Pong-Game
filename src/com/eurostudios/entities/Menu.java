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

    public Menu() {
        PongWindow.canvas.addMouseListener(this);
    }

    @Override
    public void start() {}
    @Override
    public void update() {}

    private class EuroStdsButton {
        public boolean isPressed = false;
        public Rectangle buttonFrame;
        private String str3char;
        EuroStdsButton(String str3char, int x, int y, int width, int height) {
            buttonFrame = new Rectangle(x, y, width, height);
            this.str3char = str3char;
        }
        public void render(Graphics graphics) {
            if (!isPressed) {
                graphics.setColor(shadowColor);
                graphics.fillRect(buttonFrame.x+3, buttonFrame.y+3, buttonFrame.width, buttonFrame.height);
                graphics.setColor(Color.WHITE);
                graphics.fillRect(buttonFrame.x, buttonFrame.y, buttonFrame.width, buttonFrame.height);
                graphics.setColor(Color.DARK_GRAY);
                graphics.drawString(str3char, buttonFrame.x + 14, buttonFrame.y + 18);
            }
            else {
                graphics.setColor(shadowColor);
                graphics.fillRect(buttonFrame.x+3, buttonFrame.y+3, buttonFrame.width, buttonFrame.height);
                graphics.setColor(Color.WHITE);
                graphics.fillRect(buttonFrame.x+1, buttonFrame.y+1, buttonFrame.width, buttonFrame.height);
                graphics.setColor(Color.DARK_GRAY);
                graphics.drawString(str3char, buttonFrame.x + 14 +1, buttonFrame.y + 18 +1);
                graphics.setColor(shadowColor);
                graphics.fillRect(buttonFrame.x+1, buttonFrame.y+1, buttonFrame.width, buttonFrame.height);
            }
        }

    }

    EuroStdsButton buttonPVP = new EuroStdsButton("PVP", PongWindow.MARGIN, 40, 50,25);
    EuroStdsButton buttonPVE = new EuroStdsButton("PVE", PongWindow.WIDTH - PongWindow.MARGIN - 50, 40, 50,25);

    @Override
    public void render(Graphics graphics) {
        buttonPVP.render(graphics);
        buttonPVE.render(graphics);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isInMenu) {
            int axisX = e.getX()/PongWindow.SCALE;
            int axisY = e.getY()/PongWindow.SCALE;
            if (axisX >= buttonPVP.buttonFrame.x && axisX <= buttonPVP.buttonFrame.x + buttonPVP.buttonFrame.width &&
                    axisY >= buttonPVP.buttonFrame.y && axisY <= buttonPVP.buttonFrame.y + buttonPVP.buttonFrame.height) {
                buttonPVP.isPressed = true;
            }
            else if (axisX >= buttonPVE.buttonFrame.x && axisX <= buttonPVE.buttonFrame.x + buttonPVE.buttonFrame.width &&
                    axisY >= buttonPVE.buttonFrame.y && axisY <= buttonPVE.buttonFrame.y + buttonPVE.buttonFrame.height) {
                buttonPVE.isPressed = true;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (buttonPVP.isPressed) {
            buttonPVP.isPressed = false;
            isInMenu = false;
            isPVP = true;
            PongGameLoop.resetEntities();
        }
        else if (buttonPVE.isPressed) {
            buttonPVE.isPressed = false;
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
