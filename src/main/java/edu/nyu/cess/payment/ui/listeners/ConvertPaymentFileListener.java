package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.io.ZTreePayFileConverter;
import edu.nyu.cess.payment.ui.ZTreePayoffFileConversionPanel;
import edu.nyu.cess.payment.ui.StatusType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * The type Convert payment file listener.
 */
public class ConvertPaymentFileListener implements ActionListener
{
    private ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel;

    private ZTreePayFileConverter zTreePayFileConverter = new ZTreePayFileConverter();

    /**
     * Instantiates a new Convert payment file listener.
     *
     * @param ZTreePayoffFileConversionPanel the converter panel
     */
    public ConvertPaymentFileListener(ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel)
    {
        this.ZTreePayoffFileConversionPanel = ZTreePayoffFileConversionPanel;
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Error: File Not Set
        if( ! zTreePayFileConverter.isFileInfoSet()){
            ZTreePayoffFileConversionPanel.updateStatus(StatusType.ERROR, "Error: The file payoff file must be selected first.");
            return;
        }

        // Error: Failed To Covert File
        if( ! zTreePayFileConverter.convertPaymentToVoucherPDF()){
            ZTreePayoffFileConversionPanel.updateStatus(StatusType.ERROR, "Error: Failed to convert payment file. Please check the format.");
            return;
        }

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(zTreePayFileConverter.getPDFLocation());
                Desktop.getDesktop().open(myFile);
            }
            // Error: Unable to Open File
            catch (IOException ex) {
                ZTreePayoffFileConversionPanel.updateStatus(StatusType.ERROR, "Error: Unable to auto open selected file.");
            }
        }

        ZTreePayoffFileConversionPanel.updateStatus(StatusType.INFO, "Output File: " + zTreePayFileConverter.getPDFName() + ".pdf");
    }
}

