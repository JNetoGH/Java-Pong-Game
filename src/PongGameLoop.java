import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

    void initEntities () { // adds the entities to its arraylist and calls start() method od the entities
        entityArrayList.add(player);
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
            System.out.println(player.posX);
            System.out.println(player.posY);
            System.out.println();
            // 60 FPS LOCKER
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
