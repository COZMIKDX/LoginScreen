import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageLoader {
    // Get a file from your resource folder. You need to provide a path to
    // your resource as if the resource folder is current directory.
    private InputStream getResourceStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // Make sure the inputStream actually has something.
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public BufferedImage loadImage(String filename)
    {
        BufferedImage temp = null;
        try
        {
            ImageLoader app = new ImageLoader();
            InputStream is = app.getResourceStream(filename);
            temp = ImageIO.read(is);
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
            System.exit(1);
        }

        return temp;
    }
}