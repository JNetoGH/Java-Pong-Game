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
    public static Color darkTransparent = new Color(0,0,0, 225);

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

    private final EuroStdsButton buttonPVP = new EuroStdsButton("PVP", PongWindow.MARGIN*2, 40, 50,25);
    private final EuroStdsButton buttonPVE = new EuroStdsButton("PVE", PongWindow.MARGIN*2, 80, 50,25);
    private final EuroStdsButton buttonInfo = new EuroStdsButton("INF", PongWindow.MARGIN*2, 120, 50,25);
    private final EuroStdsButton buttonExitInfo = new EuroStdsButton("  X", PongWindow.WIDTH/2-25, PongWindow.HEIGHT-PongWindow.MARGIN*4, 50,25);
    private static boolean infoTrigger = false; // used to display the information menu

    @Override
    public void render(Graphics graphics) {
        buttonPVP.render(graphics);
        buttonPVE.render(graphics);
        buttonInfo.render(graphics);
        if (infoTrigger) { // information menu rendering
            graphics.setColor(darkTransparent);
            graphics.fillRect(PongWindow.MARGIN, PongWindow.MARGIN,
                    PongWindow.WIDTH - PongWindow.MARGIN*2, PongWindow.HEIGHT - PongWindow.MARGIN*2);
            graphics.setColor(Color.WHITE);
            graphics.drawRect(PongWindow.MARGIN, PongWindow.MARGIN,
                    PongWindow.WIDTH - PongWindow.MARGIN*2, PongWindow.HEIGHT - PongWindow.MARGIN*2);
            graphics.drawString("PLAYER1:      PLAYER2:", PongWindow.MARGIN*2, PongWindow.MARGIN*2+10);
            graphics.drawString("    W =>      UP      <= ▲ ", PongWindow.MARGIN*2, PongWindow.MARGIN*3+15);
            graphics.drawString("    S =>   DOWN   <= ▼", PongWindow.MARGIN*2, PongWindow.MARGIN*4+20);
            buttonExitInfo.render(graphics);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isInMenu) {
            int axisX = e.getX()/PongWindow.SCALE;
            int axisY = e.getY()/PongWindow.SCALE;
            if (!infoTrigger) { // can only press a button if its not on information menu
                if (axisX >= buttonPVP.buttonFrame.x && axisX <= buttonPVP.buttonFrame.x + buttonPVP.buttonFrame.width &&
                        axisY >= buttonPVP.buttonFrame.y && axisY <= buttonPVP.buttonFrame.y + buttonPVP.buttonFrame.height) {
                    buttonPVP.isPressed = true;
                }
                else if (axisX >= buttonPVE.buttonFrame.x && axisX <= buttonPVE.buttonFrame.x + buttonPVE.buttonFrame.width &&
                        axisY >= buttonPVE.buttonFrame.y && axisY <= buttonPVE.buttonFrame.y + buttonPVE.buttonFrame.height) {
                    buttonPVE.isPressed = true;
                }
                else if (axisX >= buttonInfo.buttonFrame.x && axisX <= buttonInfo.buttonFrame.x + buttonInfo.buttonFrame.width &&
                        axisY >= buttonInfo.buttonFrame.y && axisY <= buttonInfo.buttonFrame.y + buttonInfo.buttonFrame.height) {
                    buttonInfo.isPressed = true;
                }
            }
            else if (axisX >= buttonExitInfo.buttonFrame.x && axisX <= buttonExitInfo.buttonFrame.x + buttonExitInfo.buttonFrame.width &&
                    axisY >= buttonExitInfo.buttonFrame.y && axisY <= buttonExitInfo.buttonFrame.y + buttonExitInfo.buttonFrame.height) {
                buttonExitInfo.isPressed = true;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (buttonPVP.isPressed && !infoTrigger) {
            buttonPVP.isPressed = false;
            isInMenu = false;
            isPVP = true;
            PongGameLoop.resetEntities();
        }
        else if (buttonPVE.isPressed && !infoTrigger) {
            buttonPVE.isPressed = false;
            isInMenu = false;
            isPVE = true;
            PongGameLoop.resetEntities();
        }
        else if (buttonInfo.isPressed) {
            buttonInfo.isPressed = false;
            infoTrigger = true;
        }
        else if(buttonExitInfo.isPressed) {
            buttonExitInfo.isPressed = false;
            infoTrigger = false;
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
