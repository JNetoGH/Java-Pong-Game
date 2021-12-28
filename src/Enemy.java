import java.awt.*;

public class Enemy extends Entity {

    public static double posX;
    public static double posY;
    public static Dimension dimensions;



    @Override
    public void start() {
        dimensions = new Dimension(5,15);
        posX = (int) (PongWindow.WIDTH - super.movementMargin - dimensions.getWidth());
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight()/2);
    }

    @Override
    public void update() {
        double newPosiY = posY + (Ball.posY - posY);
        if (!(newPosiY > PongWindow.HEIGHT - super.movementMargin - dimensions.height)) { // ! > bottom
            if (!(newPosiY < super.movementMargin)) { // ! < top
                posY = newPosiY;
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect((int) posX, (int) posY, (int) dimensions.getWidth(),(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
    }
}
