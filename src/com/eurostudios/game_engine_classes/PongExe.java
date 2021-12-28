package com.eurostudios.game_engine_classes;

public class PongExe {

    PongWindow pongWindow;
    PongGameLoop pongGameLoop;
    KeyboardController keyboardController;

    public PongExe() {
        // INITS WINDOW, GAME LOOP AND KEYBOARD CONTROLLER
        pongWindow = new PongWindow();
        pongGameLoop = new PongGameLoop();
        keyboardController = new KeyboardController();
    }

    public static void main(String[] args) {
        new PongExe();
    }

}

