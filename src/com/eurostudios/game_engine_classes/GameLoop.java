package com.eurostudios.game_engine_classes;

import java.util.ArrayList;

public class GameLoop implements Runnable {

    private static ArrayList<Entity> entityArrayList; // stores the entities
    private static Render pongRender; // used to render the game content
    private static boolean reset;

    public GameLoop(Phase initialPhase) { // inits the Thread of the game loop
        pongRender = new Render();
        new Thread(this).start();
        entityArrayList = initialPhase.getEntityArrayList();

    }

    public static void resetEntities() {
        reset = true;
    }

    private void initEntities () { // adds the entities to its arraylist and calls start() method od the entities
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
