import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.io.InputStream;
import java.net.URL;

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
            // Changed image loading method slightly.
            // Instead of a relative file path, which only works for launching from
            // the same folder as the class file or jar, I use a class loader to load
            // the files as an input stream. Then I give that to Image.IO.
            ImageLoader imageLoader = new ImageLoader();
            bg = imageLoader.loadImage("assets/LOGINSCREEN.png");
        }
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
