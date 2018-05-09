import java.util.ArrayList;

class Model
{
    View view;
    ArrayList<Sprite> facesList;
    boolean backspace;
    boolean anykey;
    boolean keyPressedPrev;
    int xPos;

    Model()
    {
        xPos = 285;
        facesList = new ArrayList<Sprite>();
    }

    void keyInput()
    {
        if (anykey && !keyPressedPrev)
        {
            if (!backspace)
            {
                System.out.println("update xPos: " + xPos);
                facesList.add(new Face(xPos,475));
                if (xPos > 1485)
                {
                        for (int i = 0; i < facesList.size(); i++)
                        {
                            facesList.get(i).x -= 120;
                            facesList.get(i).currentX -= 120;
                        }
                }
                else
                    xPos += 120;
            }
            else if (backspace)
            {
                if (facesList.size() > 0)
                {
                    /*if (facesList.size() == 1) //Only one sprite left.
                        xPos = 285;*/

                    if (facesList.get(0).x < 285) // For when sprites are to the left of the text box.
                    {
                        for (int i = 0; i < facesList.size(); i++)
                        {
                            facesList.get(i).x += 120;
                            facesList.get(i).currentX += 120;
                        }
                    }
                    else
                        xPos -= 120; // move next xPos to the previous position.

                    facesList.remove(facesList.size() - 1); // Remove the rightmost sprite.
                }
                else if (facesList.size() == 0)
                {
                    xPos = 285;
                }
                System.out.println("update xPos: " + xPos);
            }

            keyPressedPrev = true;
        }
        else if (!anykey && keyPressedPrev)
        {
            keyPressedPrev = false;
        }
    }




    public void update()
    {
        keyInput();

        for (int i = 0; i < facesList.size(); i ++)
        {
            facesList.get(i).update();
        }
    }
}
