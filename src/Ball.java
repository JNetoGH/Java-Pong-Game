import java.awt.*;
import java.util.Random;

public class Ball extends Entity {

    // can be 1 or -1 indicates the were the ball is going
    public double dx;
    public double dy;

    public double speed = 1;

    public static int posX;
    public static int posY;
    public static Dimension dimensions;

    private double roundRandoms(double num) {
        if (num > 0) return 1;
        else return  -1;
    }

    @Override
    public void start() {
        dimensions = new Dimension(3,3);
        posX = (int) (PongWindow.WIDTH/2-dimensions.getWidth());
        posY = (int) (PongWindow.HEIGHT/2-dimensions.getHeight());
        this.dx = roundRandoms(new Random().nextGaussian());
        this.dy = roundRandoms(new Random().nextGaussian());
    }

    @Override
    public void update() {

        // COLLISIONS WITH WALLS
        if(posY + dx * speed + dimensions.height >= PongWindow.HEIGHT - movementMargin) {
            dy *= -1;
        }
        else if (posY + dy * speed < super.movementMargin) {
            dy *= -1;
        }

        if (posX >= PongWindow.WIDTH - super.movementMargin) {
            // meu ponto
        }
        else if (posX < super.movementMargin) {
            // ponto do inimigo
        }

        Rectangle ballHitBox = new Rectangle((int)(posX + dx * speed), (int)(posY + dy * speed), dimensions.width, dimensions.height);
        Rectangle playerHitBox = new Rectangle(Player.posX, Player.posY, Player.dimensions.width, Player.dimensions.height);
        Rectangle enemyHitBox = new Rectangle((int) Enemy.posX, (int) Enemy.posY, Enemy.dimensions.width, Enemy.dimensions.height);

        // COLLISIONS WITH ENTITIES
        if (ballHitBox.intersects(playerHitBox)) {
            dx *= -1;
        }
        else if (ballHitBox.intersects(enemyHitBox)) {
            dx *= -1;
        }

        // MOVES THE BALL
        posX += dx * speed;
        posY += dy * speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE); // picking a color or you can set manually g.setColor(new Color(19,19,19));
        graphics.fillRect(posX, posY, (int) dimensions.getWidth(),(int) dimensions.getHeight()); // rendering a rectangle X, Y, WIDTH, HEIGHT
    }
}
