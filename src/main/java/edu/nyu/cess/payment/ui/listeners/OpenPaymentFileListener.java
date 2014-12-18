package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.ui.PrinterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * The type Open payment file listener.
 */
class OpenPaymentFileListener implements ActionListener
{
    private PrinterPanel printerPanel;

    public OpenPaymentFileListener(PrinterPanel printerPanel)
    {
        this.printerPanel = printerPanel;
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(printerPanel);

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

        fileConverter.setFileInfo(file.getPath());
        ImageIcon infoIcon = createImageIcon("/resources/images/info.png", "info");
        statusLabel.setIcon(infoIcon);
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setText("Opened: " + file.getName());
    }

    /**
     * Gets extension.
     *
     * @param f the f
     * @return the extension
     */
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

