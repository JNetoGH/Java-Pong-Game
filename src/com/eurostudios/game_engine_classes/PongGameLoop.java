package com.eurostudios.game_engine_classes;

import com.eurostudios.entities.*;

import java.util.ArrayList;

public class PongGameLoop implements Runnable {

    private static ArrayList<Entity> entityArrayList; // stores the entities
    private static Render pongRender; // used to render the game content

    private static boolean reset;

    public PongGameLoop () { // inits the Thread of the game loop
        entityArrayList = new ArrayList<>();
        pongRender = new Render();
        new Thread(this).start();
    }

    public static void resetEntities() {
        reset = true;
    }

    private void initEntities () { // adds the entities to its arraylist and calls start() method od the entities
        if (!Menu.isInMenu) {
            entityArrayList.add(new Player());
            entityArrayList.add(new Enemy());
            entityArrayList.add(new Ball());
        }
        else {
            entityArrayList.add(new Menu());
        }

        for (Entity e: entityArrayList) e.start();
    }
    private void mainUpdate() { // calls entities' updates
        for (Entity e: entityArrayList) e.update();
    }
    private void mainRender() {pongRender.render(entityArrayList);}

    @Override
    public void run() {
        initEntities();
        while (true) {
            if (reset) {
                entityArrayList.clear();
                initEntities();
                reset = false;
            }
            mainUpdate();
            mainRender();
            // 60 FPS LOCKER
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
