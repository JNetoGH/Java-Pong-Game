import java.awt.*;

public abstract class Entity {
    public int movementMargin = 10;
    public Dimension dimensions;
    public boolean goingUp;
    public boolean goingDown;
    public int posX;
    public int posY;
    public abstract void start(); // called at the beginning of the game loop
    public abstract void update(); // updates entity fields like pos, etc
    public abstract void render(Graphics graphics); // draw the entity at screen
}
