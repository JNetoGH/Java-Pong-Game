import java.awt.*;

public class Player extends Entity{

    @Override
    public void start() {
    }

    @Override
    public void update() {
        if(super.right) super.posX++;
        else if(super.left) super.posX--;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN); // picking a color or you can set manually g.setColor(new Color(19,19,19));
        g.fillRect(posX, posY, 50,50); // rendering a rectangle X, Y, WIDHT, HEIGH
    }
}
