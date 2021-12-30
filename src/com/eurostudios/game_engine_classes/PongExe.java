package com.eurostudios.game_engine_classes;

import com.eurostudios.IO_controllers.KeyboardController;
import com.eurostudios.IO_controllers.MouseController;
import com.eurostudios.entities.*;

import java.util.ArrayList;

public class PongExe {

    public static AppWindow pongWindow;
    public static GameLoop pongGameLoop;
    public static KeyboardController keyboardController;
    public static MouseController mouseController;


    private ArrayList<Entity> entityArrayList =new ArrayList<>(); // stores the entities

    public PongExe() {
        // INITS WINDOW, GAME LOOP AND CONTROLLERS
        pongWindow = new AppWindow();

        if (!Menu.isInMenu) {
            entityArrayList.add(new Player());
            entityArrayList.add(new Enemy());
            entityArrayList.add(new Ball());
        }
        else {
            entityArrayList.add(new Menu());
        }
        pongGameLoop = new GameLoop(new Phase(entityArrayList));
        keyboardController = new KeyboardController();
        mouseController = new MouseController();
    }

    public static void main(String[] args) {
        new PongExe();
    }
}

