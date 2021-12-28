import java.util.ArrayList;

public class PongGameLoop implements Runnable {

    ArrayList<Entity> entityArrayList = new ArrayList<Entity>(); // stores the entities
    Render pongRender = new Render(); // used to render the game content

    void initEntities () { // adds the entities to its arraylist
        entityArrayList.add(new Player());
        for (Entity e: entityArrayList) {
            e.start();
        }
    }

    private void mainUpdate() { // calls entities' updates
        for (Entity e: entityArrayList) {
            e.update();
        }
    }

    private void mainRender() { // calls entities' render
        pongRender.render(entityArrayList);
    }

    @Override
    public void run() {
        initEntities();
        while (true) {
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
