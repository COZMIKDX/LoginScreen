import java.awt.Graphics;

abstract class Sprite
{
    int width, height;
    int x, y;
    int currentX, currentY;
    double destX, destY;

    abstract void update();
    abstract void drawSelf(Graphics g);

    /*static BufferedImage loadImage(String filename)
    {
        BufferedImage temp = null;
        try
        {
             temp = ImageIO.read(new File(filename));
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            System.exit(1);
        }

        return temp;
    }*/
}
