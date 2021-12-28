import java.awt.*;

public class Player extends Entity{

    @Override
    public void start() {
        super.posX = 10;
        super.posY = PongWindow.HEIGHT/2;
        super.dimensions = new Dimension(5,15);
    }

    @Override
    public void update() {
        if(super.goingUp) {
            if (!(posY < + movementMargin)) {
                super.posY--;
            }
        }
        else if(super.goingDown) {
            if (!(posY + dimensions.getHeight() > PongWindow.HEIGHT - movementMargin)) {
                super.posY++;
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN); // picking a color or you can set manually g.setColor(new Color(19,19,19));
        g.fillRect(posX, posY, (int) super.dimensions.getWidth(),(int) super.dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
    }
}
