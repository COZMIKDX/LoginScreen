import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

class Controller implements KeyListener
{
    Model model;
    boolean enter;
    boolean backspace;
    boolean anykey;
    boolean keyPressedPrev;
    boolean keyTyped;

    StringBuilder betaString = new StringBuilder();
    String password = new String();
    Scanner scan = new Scanner(System.in);



    Controller(Model m)
    {
        model = m;
    }

    //////////////////// keyboard stuff //////////////////////////
	public void keyPressed(KeyEvent e)
	{
        //anykey = true;

		switch(e.getKeyCode())
		{
            case KeyEvent.VK_BACK_SPACE: backspace = true; break;
            case KeyEvent.VK_ENTER: enter = true; break;
			default: {}
		}
	}

	public void keyReleased(KeyEvent e)
	{
        //anykey = false;

		switch(e.getKeyCode())
		{
            case KeyEvent.VK_BACK_SPACE: backspace = false; break;
            case KeyEvent.VK_ENTER: enter = false; break;
			default: {}
		}
	}

    char nextInputChar;
	public void keyTyped(KeyEvent e) //65 to 122
    {
        // getKeyChar returns a Unicode character. This includes ENTER, BACKSPACE, etc.   https://unicode-table.com/en/#007A
        anykey = true;

        char temp = e.getKeyChar();
        if (temp >= 64 && temp <= 122)
        {
            nextInputChar = temp;
            keyTyped = true;
        }
    }


    void keyInput()
    {
        // Do stuff needed before this keypress is registered as "previously pressed" or keyPressedPrev = true;
        if (anykey && !keyPressedPrev) //when a key is pressed and no key was previously pressed.
        {
            if (backspace && betaString.length() > 0)
                betaString.deleteCharAt(betaString.length() - 1);

            if (keyTyped)
            {
                betaString.append(nextInputChar);
                keyTyped = false;
            }

            if (enter && !keyPressedPrev)
            {
                password = betaString.toString();
                System.out.println(password);
            }

            keyPressedPrev = true;
        }
        else if (!anykey && keyPressedPrev)
            keyPressedPrev = false;
    }


    void update()
    {
        keyInput();

        if (enter && !keyPressedPrev)
            this.anykey = false;
        model.anykey = this.anykey;
        model.backspace = this.backspace;
        this.backspace = false;
        this.anykey = false;
    }
}
