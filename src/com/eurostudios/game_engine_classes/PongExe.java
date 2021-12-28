package com.eurostudios.game_engine_classes;

public class PongExe {

    public static PongWindow pongWindow;
    public static PongGameLoop pongGameLoop;
    public static KeyboardController keyboardController;

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

