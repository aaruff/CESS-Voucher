package edu.nyu.cess.payment;

import edu.nyu.cess.payment.io.ZTreePayFileConverter;
import edu.nyu.cess.payment.ui.ZTreePayoffFileConversionPanel;
import edu.nyu.cess.payment.ui.PrinterMenu;

import javax.swing.*;

/**
 * The type Main.
 */
public class Main
{

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
            System.out.println("Error setting Java LAF: " + e);
        }

        //Create and set up the window.
        JFrame frame = new JFrame("Z-Tree Payment Voucher Generator");
        frame.setSize(500, 270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel = new ZTreePayoffFileConversionPanel(payFileConverter);

        PrinterMenu menu = new PrinterMenu(frame, ZTreePayoffFileConversionPanel);
        //paymentPrinterPanel.setSize(500, 270);
        frame.add(ZTreePayoffFileConversionPanel);
        frame.setJMenuBar(menu.getJMenuBar());

        //Display the window.
        frame.setVisible(true);
    }
}