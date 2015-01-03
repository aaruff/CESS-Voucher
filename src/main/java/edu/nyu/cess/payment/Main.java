package edu.nyu.cess.payment;

import edu.nyu.cess.payment.io.ConfigurationFile;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * The type Main.
 */
public class Main
{
    private static final Logger LOG = Logger.getLogger(ConfigurationFile.class);

    /**
     * Main void.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Main main = new Main();

                main.setupLookAndFeel();

                Controller controller = new Controller(main.getFrame());

                controller.displayGui();
            }
        });
	}

    public void setupLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e) {
            LOG.debug("Error setting Java Look and Feel: " + e);
        }
    }

    public JFrame getFrame()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) (screenSize.getHeight() * 2 / 3);
        int width = (int) (screenSize.getWidth() * 2 / 3);

        frame.setPreferredSize(new Dimension(width, height));

        return frame;
    }
}