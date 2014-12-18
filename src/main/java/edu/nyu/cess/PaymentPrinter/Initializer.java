package edu.nyu.cess.PaymentPrinter;

import javax.swing.*;

public class Initializer {
	
	public static void main(String args[]){
		
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
	}
	
	
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Z-Tree Payment Voucher Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Add content to the window.
        PaymentFileConverter paymentFileConverter = new PaymentFileConverter();
        PaymentPrinterPanel paymentPrinterPanel = new PaymentPrinterPanel(paymentFileConverter);
        PaymentPrinterMenu menu = new PaymentPrinterMenu(frame, paymentPrinterPanel);
        //paymentPrinterPanel.setSize(500, 270);
        frame.add(paymentPrinterPanel);
        frame.setJMenuBar(menu.getJMenuBar());

        //Display the window.
        frame.setSize(500, 270);
        frame.setVisible(true);
    }
}