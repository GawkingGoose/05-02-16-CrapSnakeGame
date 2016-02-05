import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
    public DrawPanel()                       // set up graphics window
    {
        super();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)  // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels

        super.paintComponent(g);            // call superclass to make panel display correctly


        // Drawing code goes here
    }

    public JFrame drawItNow()
    {
        DrawPanel panel = new DrawPanel();                            // window for drawing
        JFrame application = new JFrame();                            // the program itself
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
                                                                      // when it is closed
        application.add(panel);           


        application.setSize(500, 400);         // window is 500 pixels wide, 400 high
        application.setVisible(true);     
        return application;
    }

}
