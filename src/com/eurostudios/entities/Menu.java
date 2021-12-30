package com.eurostudios.entities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.eurostudios.game_engine_classes.*;

public class Menu implements Entity{

    public static boolean isInMenu = true;
    public static boolean isPVP = false;
    public static boolean isPVE = false;

    public static Color darkTransparent = new Color(0,0,0, 225);

    @Override
    public void start() {}
    @Override
    public void update() {}


    public static final EuroStdsButton buttonPVP = new EuroStdsButton("PVP", PongWindow.MARGIN*2, 40, 50,25);
    public static final EuroStdsButton buttonPVE = new EuroStdsButton("PVE", PongWindow.MARGIN*2, 80, 50,25);
    public static final EuroStdsButton buttonInfo = new EuroStdsButton("INF", PongWindow.MARGIN*2, 120, 50,25);
    public static final EuroStdsButton buttonExitInfo = new EuroStdsButton("  X", PongWindow.WIDTH/2-25, PongWindow.HEIGHT-PongWindow.MARGIN*4, 50,25);
    public static boolean infoTrigger = false; // used to display the information menu

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

}
