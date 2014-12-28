package edu.nyu.cess.payment.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrinterMenu
{
	ZTreePayoffFileConversionPanel parentPanel;
	JFrame parentFrame;
	
	public PrinterMenu(JFrame frame, ZTreePayoffFileConversionPanel parentPanel){
		this.parentPanel = parentPanel;
		this.parentFrame = frame;
	}
	
	public JMenuBar getJMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem usageItem = new JMenuItem("Usage");
        usageItem.addActionListener(new HelpActionListener());
        helpMenu.add(usageItem);
        menuBar.add(helpMenu);
        
        JMenu aboutMenu = new JMenu("About");
        JMenuItem cessItem = new JMenuItem("CESS LTK");
        cessItem.addActionListener(new CESSActionListener());
        JMenuItem authorItem = new JMenuItem("Author");
        aboutMenu.add(cessItem);
        authorItem.addActionListener(new AuthorActionListener());
        aboutMenu.add(authorItem);
        menuBar.add(aboutMenu);
        
        return menuBar;
	}

	private class HelpActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "To use this program:\n" +
			 "1. Select the \"Open File\" button to load the selected Z-Tree payment file.\n"+
			 "2. Select \"Convert to Voucher\" to generate the PDF Voucher file, which is automatically opened for you.\n\n"+
			 "Note: The PDF voucher file is placed in the same directory as the payment file.", "Usage", JOptionPane.INFORMATION_MESSAGE); 
		}
		
	}
	private class CESSActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "This program is one of several programs in the Center for Experimental Social Science LTK (Lab Toolkit) Suite.\n"+
					"The purpose of the CESS LTK Suite is to help facilitate the recruitment, managagement, and conduction of experiments in decision making at the\n"+
					"Center for Experimental Social Science -- in addition to the broader reasearch community.", "CESS LTK", JOptionPane.INFORMATION_MESSAGE); 
		}
	}
	
	private class AuthorActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, 
					"This application was authored by Anwar A. Ruff. This application was completed with\n"+
					"design and QC help from Margaret Ford and Caroline Madden. If you have any questions about this application\n"+
					"or any other in the CESS LTK Suite feel free to contact Anwar at anwar.ruff@nyu.edu.\n"+
					"This application", "Author Info", JOptionPane.INFORMATION_MESSAGE); 
		}
	}

}
