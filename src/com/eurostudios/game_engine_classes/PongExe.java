package com.eurostudios.game_engine_classes;

import com.eurostudios.io_controllers.KeyboardController;
import com.eurostudios.io_controllers.MouseController;

public class PongExe {

    public static PongWindow pongWindow;
    public static PongGameLoop pongGameLoop;
    public static KeyboardController keyboardController;
    public static MouseController mouseController;

    public PongExe() {
        // INITS WINDOW, GAME LOOP AND KEYBOARD CONTROLLER
        pongWindow = new PongWindow();
        pongGameLoop = new PongGameLoop();
        keyboardController = new KeyboardController();
        mouseController = new MouseController();

    }

    public static void main(String[] args) {
        new PongExe();
    }

}

