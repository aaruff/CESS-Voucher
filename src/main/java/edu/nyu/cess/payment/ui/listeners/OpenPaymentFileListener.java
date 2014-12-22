package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.io.ConfigurationFile;
import edu.nyu.cess.payment.ui.StatusType;
import edu.nyu.cess.payment.ui.ZTreePayoffFileConversionPanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Open payment file listener.
 */
public class OpenPaymentFileListener implements ActionListener
{
    private ZTreePayoffFileConversionPanel conversionPanel;
    private JFileChooser fileChooser;

    public OpenPaymentFileListener(ZTreePayoffFileConversionPanel conversionPanel)
    {
        this.conversionPanel = conversionPanel;

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
        int returnVal = fileChooser.showOpenDialog(conversionPanel);

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            conversionPanel.updateStatus(StatusType.ERROR, "Error: Invalid format. Please select a Z-Tree payoff file.");
            return;
        }

        conversionPanel.updatePayFileConverter(fileChooser.getSelectedFile());
    }
}

