package edu.nyu.cess.PaymentPrinter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.*;

import javax.swing.*;

public class PaymentPrinterPanel extends JPanel {

	private static final long serialVersionUID = 2853708307420292816L;
	
    private JButton openPaymentFileButton, paymentFileToVoucherButton;
    private JLabel statusLabel;
    private JFileChooser fileChooser;
    
    private int verticalShift;
    private int horizontalShift;
    
    protected PaymentFileConverter paymentFileConverter;
    
    public PaymentPrinterPanel(PaymentFileConverter paymentFileConverter) {
    	this.paymentFileConverter = paymentFileConverter;
    	this.verticalShift = 0;
    	this.horizontalShift = 0;
    	init();
    }
    
    public void init(){
    	GridBagConstraints constraint; 

        // find configuration file for the default path
        ConfigurationFile configurationFile = new ConfigurationFile();
        String defaultPath = configurationFile.read();
        
        fileChooser = new JFileChooser(defaultPath);
        
        ImageIcon infoIcon = createImageIcon("/resources/images/info.png", "info");
        this.statusLabel = new JLabel(infoIcon);
		this.statusLabel.setForeground(Color.BLACK);
        this.statusLabel.setText("Select \"Open File\" to set your payment file.");
        this.statusLabel.setHorizontalAlignment(JLabel.LEFT);
        
        ImageIcon fileOpenIcon = createImageIcon("/resources/images/file_open.png", "FileOpen");
        openPaymentFileButton = new JButton("Open File", fileOpenIcon);
        openPaymentFileButton.setPreferredSize(new Dimension(190, 40));
        openPaymentFileButton.addActionListener(new OpenPaymentFileListener());

        ImageIcon pdfIcon = createImageIcon("/resources/images/pdf_ico.png", "PDF");
        paymentFileToVoucherButton = new JButton("Convert to Voucher", pdfIcon);
        paymentFileToVoucherButton.setPreferredSize(new Dimension(190, 40));
        paymentFileToVoucherButton.addActionListener(new ConvertPaymentFileListener());

        //For layout purposes, put the buttons in a separate panel
        JPanel fileSelectionPanel = new JPanel(new GridBagLayout()); 
        
        JPanel cessLogoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        
        JLabel cessIconLabel = new JLabel(createImageIcon("/resources/images/cess.png", "CESS"));
        cessLogoPanel.add(cessIconLabel);
        
		JLabel cessLabel = new JLabel("CESS Lab Toolkit");
		cessLabel.setFont(new Font("Helvetica", Font.BOLD, 28));
		cessLabel.setForeground(new Color(19, 19, 33));
        cessLogoPanel.add(cessLabel);
			
		constraint = new GridBagConstraints();
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.insets = new Insets(20, 20, 20, 20);
        fileSelectionPanel.add(cessLogoPanel, constraint);

		constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 2;
		constraint.insets = new Insets(0, 0, 10, 0);
        fileSelectionPanel.add(openPaymentFileButton, constraint);
        
        JLabel nextIconLabel = new JLabel(createImageIcon("/resources/images/next.png", ""));
		constraint = new GridBagConstraints();
		constraint.gridx = 1;
		constraint.gridy = 2;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(0, 30, 10, 30);
        fileSelectionPanel.add(nextIconLabel, constraint);
        
		constraint = new GridBagConstraints();
		constraint.gridx = 2;
		constraint.gridy = 2;
		constraint.insets = new Insets(0, 0, 10, 0);
        fileSelectionPanel.add(paymentFileToVoucherButton, constraint);
        
		constraint = new GridBagConstraints();
		constraint.gridx = 0;
		constraint.gridy = 3;
		constraint.gridwidth = GridBagConstraints.REMAINDER;
		constraint.insets = new Insets(0, 10, 0, 0);
        fileSelectionPanel.add(statusLabel, constraint);
        
        //Add the buttons and the log to this panel.
        add(fileSelectionPanel, BorderLayout.PAGE_START);
    }
    
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                               String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    public void setHorizontalShift(int horizontalShift){
    	this.horizontalShift = horizontalShift;
    }
    
    public void setVerticalShift(int verticalShift){
    	this.verticalShift = verticalShift;
    }
    
    private class OpenPaymentFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
            int returnVal = fileChooser.showOpenDialog(PaymentPrinterPanel.this);

            if (returnVal != JFileChooser.APPROVE_OPTION) {
		        ImageIcon infoIcon = createImageIcon("/resources/images/info.png", "info");
		        statusLabel.setIcon(infoIcon);
				statusLabel.setForeground(Color.BLACK);
		        statusLabel.setText("Select \"Open File\" to set your payment file.");
            	return;
            }
            
            File file = fileChooser.getSelectedFile();
            String extension = getExtension(file);
            
            if(file.isDirectory() || !extension.equals("pay")){
				statusLabel.setForeground(Color.RED);
		        ImageIcon errorIcon = createImageIcon("/resources/images/error.png", "error");
				statusLabel.setIcon(errorIcon);
                statusLabel.setText("Error: Invalid format. Please select a Z-Tree (file-name.pay) payoff file.");
                return;
            }
            
            paymentFileConverter.setFileInfo(file.getPath());
	        ImageIcon infoIcon = createImageIcon("/resources/images/info.png", "info");
	        statusLabel.setIcon(infoIcon);
			statusLabel.setForeground(Color.BLACK);
			statusLabel.setText("Opened: " + file.getName());
		}
		
	    private String getExtension(File f) {
	        String ext = null;
	        String s = f.getName();
	        int i = s.lastIndexOf('.');
	
	        if (i > 0 &&  i < s.length() - 1) {
	            ext = s.substring(i+1).toLowerCase();
	        }
	       return ext;
	    }
    }
    
    
    private class ConvertPaymentFileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(!paymentFileConverter.isFileInfoSet()){
				statusLabel.setForeground(Color.RED);
		        ImageIcon errorIcon = createImageIcon("/resources/images/error.png", "error");
				statusLabel.setIcon(errorIcon);
                statusLabel.setText("Error: Please select \"Open File\" first.");
                return;
			}
			
			if(!paymentFileConverter.convertPaymentToVoucherPDF(horizontalShift, verticalShift)){
		        ImageIcon errorIcon = createImageIcon("/resources/images/error.png", "error");
				statusLabel.setIcon(errorIcon);
				statusLabel.setForeground(Color.RED);
                statusLabel.setText("Error: Failed to convert payment file, check format.");
                return;
			}
			
			if (Desktop.isDesktopSupported()) {
			    try {
			        File myFile = new File(paymentFileConverter.getPDFLocation());
			        Desktop.getDesktop().open(myFile);
			    } catch (IOException ex) {
			        ImageIcon errorIcon = createImageIcon("/resources/images/error.png", "error");
					statusLabel.setIcon(errorIcon);
					statusLabel.setForeground(Color.RED);
	                statusLabel.setText("Error: Unable to auto open File ("+paymentFileConverter.getPDFName()+".pdf)");
			    }
			}

			
	        ImageIcon infoIcon = createImageIcon("/resources/images/info.png", "info");
	        statusLabel.setIcon(infoIcon);
			statusLabel.setText("");
            statusLabel.setText("Output File: " + paymentFileConverter.getPDFName()+".pdf");
		}
    	
    }
}
	


