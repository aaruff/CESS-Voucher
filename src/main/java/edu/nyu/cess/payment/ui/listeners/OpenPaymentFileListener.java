package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.io.ConfigurationFile;
import edu.nyu.cess.payment.ui.ZTreePayoffFileConversionPanel;
import edu.nyu.cess.payment.ui.labels.ErrorLabelProperty;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Open payment file listener.
 */
public class OpenPaymentFileListener implements ActionListener
{
    private ErrorLabelProperty invalidFormatError;
    private ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel;
    private JFileChooser fileChooser;

    public OpenPaymentFileListener(ZTreePayoffFileConversionPanel ZTreePayoffFileConversionPanel)
    {
        this.ZTreePayoffFileConversionPanel = ZTreePayoffFileConversionPanel;

        invalidFormatError = new ErrorLabelProperty("Error: Invalid format. Please select a Z-Tree payoff file.");

        // File Chooser Setup
        ConfigurationFile configFile = new ConfigurationFile();
        fileChooser = new JFileChooser(configFile.getPayoffPath());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Z-Tree Pay Files", "pay"));
        fileChooser.setAcceptAllFileFilterUsed(true);
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(ZTreePayoffFileConversionPanel);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            ZTreePayoffFileConversionPanel.updateStatus(invalidFormatError);
            return;
        }

        ZTreePayoffFileConversionPanel.updatePayFileConverter(fileChooser.getSelectedFile());
    }
}

