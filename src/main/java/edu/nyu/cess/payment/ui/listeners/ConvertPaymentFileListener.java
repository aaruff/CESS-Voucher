package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.io.ZTreePayFileConverter;
import edu.nyu.cess.payment.ui.FileSelectionObserver;
import edu.nyu.cess.payment.ui.StatusType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Convert payment file listener.
 */
public class ConvertPaymentFileListener implements ActionListener
{
    private FileSelectionObserver fileSelectionObserver;

    private ZTreePayFileConverter zTreePayFileConverter = new ZTreePayFileConverter();

    /**
     * Instantiates a new Convert payment file listener.
     *
     * @param fileSelectionObserver the converter panel
     */
    public ConvertPaymentFileListener(FileSelectionObserver fileSelectionObserver)
    {
        this.fileSelectionObserver = fileSelectionObserver;
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        fileSelectionObserver.updateStatus(StatusType.INFO, "Output File: " + zTreePayFileConverter.getPDFName() + ".pdf");
    }
}

