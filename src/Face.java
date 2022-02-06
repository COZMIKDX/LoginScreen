import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.lang.Math;

class Face extends Sprite
{
    static BufferedImage faces[];
    int faceType = 0;
    //double destX, destY;
    //int currentX, currentY;

    Face(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.destX = x;
        this.destY = y;
        this.currentX = x;
        this.currentY = y;
        this.faceType = (int)getRandomInt(0,2);

        if (faces == null)
        {
            ImageLoader imageLoader = new ImageLoader();
            faces = new BufferedImage[3];
            faces[0] = imageLoader.loadImage("assets/face1.png");
            faces[1] = imageLoader.loadImage("assets/face2.png");
            faces[2] = imageLoader.loadImage("assets/face3.png");
        }
    }

    double getRandomInt(double min, double max)
    {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    void wiggle(double wiggleFactor)
    {
        // calculate some x and y values to set as a destination. The sprites will move towards that destination
        // destX and destY are the distances the travel from the CENTER! So, x and y in this case.
        double angle = Math.toRadians(getRandomInt(0, 360));
        destX = Math.floor(Math.sin(angle) * wiggleFactor);
        destY = Math.floor(Math.sqrt((wiggleFactor * wiggleFactor) - (destX * destX)));
    }

    void drawSelf(Graphics g)
    {
        if (x >= 285)
            g.drawImage(faces[faceType], currentX, currentY, null);
        //System.out.println("Face pos: x="+x + "    y="+y);
    }


    void spriteShake(double wiggleFactor)
    {
        wiggle(wiggleFactor);

        int finalDestX = (int)this.destX + this.x;
        int finalDestY = this.y - (int)this.destY;

        if (this.currentX < finalDestX)
            this.currentX += 3;
        else if (this.currentX > finalDestX)
            this.currentX -= 3;

        if (this.currentY < finalDestY)
            this.currentY += 3;
        else if (this.currentY > finalDestY)
            this.currentY -= 3;
    }


    void update()
    {
        spriteShake(40);
    }
}
