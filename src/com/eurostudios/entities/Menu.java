package com.eurostudios.entities;

import java.awt.*;

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


    public static final EuroStdsButton buttonPVP = new EuroStdsButton("PVP", AppWindow.MARGIN*2, 40, 50,25);
    public static final EuroStdsButton buttonPVE = new EuroStdsButton("PVE", AppWindow.MARGIN*2, 80, 50,25);
    public static final EuroStdsButton buttonInfo = new EuroStdsButton("INF", AppWindow.MARGIN*2, 120, 50,25);
    public static final EuroStdsButton buttonExitInfo = new EuroStdsButton("  X", AppWindow.WIDTH/2-25, AppWindow.HEIGHT- AppWindow.MARGIN*4, 50,25);
    public static boolean infoTrigger = false; // used to display the information menu

    @Override
    public void render(Graphics graphics) {
        buttonPVP.render(graphics);
        buttonPVE.render(graphics);
        buttonInfo.render(graphics);
        if (infoTrigger) { // information menu rendering
            graphics.setColor(darkTransparent);
            graphics.fillRect(AppWindow.MARGIN, AppWindow.MARGIN,
                    AppWindow.WIDTH - AppWindow.MARGIN*2, AppWindow.HEIGHT - AppWindow.MARGIN*2);
            graphics.setColor(Color.WHITE);
            graphics.drawRect(AppWindow.MARGIN, AppWindow.MARGIN,
                    AppWindow.WIDTH - AppWindow.MARGIN*2, AppWindow.HEIGHT - AppWindow.MARGIN*2);
            graphics.drawString("PLAYER1:      PLAYER2:", AppWindow.MARGIN*2, AppWindow.MARGIN*2+10);
            graphics.drawString("    W =>      UP      <= ▲ ", AppWindow.MARGIN*2, AppWindow.MARGIN*3+15);
            graphics.drawString("    S =>   DOWN   <= ▼", AppWindow.MARGIN*2, AppWindow.MARGIN*4+20);
            buttonExitInfo.render(graphics);
        }
    }

}
