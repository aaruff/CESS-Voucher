package edu.nyu.cess.experiment.payment.voucher.printer.ui.listeners;

import edu.nyu.cess.experiment.payment.voucher.printer.ui.FileConversionObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Convert payment file listener.
 */
public class ConvertPaymentFileListener implements ActionListener
{
    private FileConversionObserver fileConversionObserver;

    /**
     * Instantiates a new Convert payment file listener.
     *
     * @param fileConversionObserver the converter panel
     */
    public ConvertPaymentFileListener(FileConversionObserver fileConversionObserver)
    {
        this.fileConversionObserver = fileConversionObserver;
    }

    /**
     * Action performed.
     *
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        fileConversionObserver.updateConversionRequest();
    }
}

