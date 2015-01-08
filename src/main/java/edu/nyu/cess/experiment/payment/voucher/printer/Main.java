package edu.nyu.cess.experiment.payment.voucher.printer;

import edu.nyu.cess.experiment.payment.voucher.printer.io.ConfigurationFile;
import org.apache.log4j.Logger;

import javax.swing.*;

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
        return frame;
    }
}