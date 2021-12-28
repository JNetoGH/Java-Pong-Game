import java.util.ArrayList;

public class PongGameLoop implements Runnable {

    private static ArrayList<Entity> entityArrayList; // stores the entities
    private static Render pongRender; // used to render the game content
    public static Player player;

    public PongGameLoop () { // inits the Thread of the game loop
        entityArrayList = new ArrayList<>();
        pongRender = new Render();
        player = new Player();
        new Thread(this).start();
    }

    private void initEntities () { // adds the entities to its arraylist and calls start() method od the entities
        entityArrayList.add(player);
        entityArrayList.add(new Enemy());
        entityArrayList.add(new Ball());
        for (Entity e: entityArrayList) e.start();
    }

    private void mainUpdate() { // calls entities' updates
        for (Entity e: entityArrayList) e.update();
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
