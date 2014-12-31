package edu.nyu.cess.payment;

import edu.nyu.cess.payment.io.ConfigurationFile;
import edu.nyu.cess.payment.io.ZTreePayFileConverter;
import edu.nyu.cess.payment.ui.PrinterMenu;
import edu.nyu.cess.payment.ui.ZTreePayoffFileConversionPanel;
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
		
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                ZTreePayFileConverter payFileConverter = new ZTreePayFileConverter();

                createAndShowGUI(payFileConverter);
            }
        });
	}


    /**
     * Create and show gUI.
     */
    public static void createAndShowGUI(ZTreePayFileConverter payFileConverter)
    {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e) {
            LOG.debug("Error setting Java LAF: " + e);
        }

        //Create and set up the window.
        JFrame frame = new JFrame("Z-Tree Payment Voucher Generator");
        frame.setSize(500, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel = new ZTreePayoffFileConversionPanel(payFileConverter);

        PrinterMenu menu = new PrinterMenu(frame, ZTreePayoffFileConversionPanel);
        frame.add(ZTreePayoffFileConversionPanel);
        frame.setJMenuBar(menu.getJMenuBar());

        //Display the window.
        frame.setVisible(true);
    }
}