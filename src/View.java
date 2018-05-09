import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

class View extends JPanel
{
    Controller controller;
    Model model;

    static BufferedImage bg;

    View(Controller controller, Model model)
    {
        this.controller = controller;
        this.model = model;
        model.view = this;

        this.setPreferredSize(new Dimension(1920,1080));

        if (bg == null)
        {
            System.out.println("loading bg");
            bg = loadImage("./assets/LOGINSCREEN.png");
        }
    }

    static BufferedImage loadImage(String filename)
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
	}


    public void drawSprites(Graphics g)
    {
        for (int i = 0; i < model.facesList.size(); i++)
        {
            model.facesList.get(i).drawSelf(g);
        }
    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(this.bg, 0, 0, null);
        drawSprites(g);
    }
}
