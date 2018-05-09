import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Game extends JFrame
{
    Model model = new Model();
    Controller controller = new Controller(model);
    View view = new View(controller, model);


    public Game()
    {
        setFocusable(true);
		this.setTitle("LOGIN");
		//this.setSize(this.windowSize_x, this.windowSize_y);
		this.getContentPane().add(view);
		this.pack();
		this.addKeyListener(controller);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Makes it so the application is killed when the window is closed.
		this.setVisible(true);
		this.setResizable(false);
    }

    public void run()
    {
        while (true)
        {
            //update shit here.
            controller.update();
            model.update();
            view.repaint();

            Toolkit.getDefaultToolkit().sync();

            try
			{
				Thread.sleep(17);
			}
			catch(Exception e)
			{
				System.out.println("yo!");
				e.printStackTrace();
				System.exit(1);
			}
        }
    }



    public static void main(String[] args)
    {
        Game g = new Game();
        g.run();
    }
}
