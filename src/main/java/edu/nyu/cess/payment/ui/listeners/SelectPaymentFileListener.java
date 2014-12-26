package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.io.ConfigurationFile;
import edu.nyu.cess.payment.io.ZTreeJFileChooser;
import edu.nyu.cess.payment.ui.FileSelectionObserver;
import edu.nyu.cess.payment.ui.StatusType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The payment file selection listener.
 */
public class SelectPaymentFileListener implements ActionListener
{
    private FileSelectionObserver view;
    private ZTreeJFileChooser fileChooser;

    public SelectPaymentFileListener(FileSelectionObserver view)
    {
        this.view = view;

        fileChooser = new ZTreeJFileChooser(configFile.getPayoffPath());
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.showOpenDialog(view.getJPanel());

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            view.updateStatus(StatusType.ERROR, "Error: Invalid format. Please select a Z-Tree payoff file.");
            return;
        }

        view.updateFileSelection(fileChooser.getSelectedFile());
    }
}
