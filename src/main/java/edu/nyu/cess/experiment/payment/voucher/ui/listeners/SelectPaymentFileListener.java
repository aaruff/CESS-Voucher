package edu.nyu.cess.experiment.payment.voucher.ui.listeners;

import edu.nyu.cess.experiment.payment.voucher.exceptions.InvalidFileSelectedException;
import edu.nyu.cess.experiment.payment.voucher.io.ZTreeJFileChooser;
import edu.nyu.cess.experiment.payment.voucher.ui.FileSelectionObserver;
import edu.nyu.cess.experiment.payment.voucher.ui.StatusType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The payment file selection listener.
 */
public class SelectPaymentFileListener implements ActionListener
{
    private FileSelectionObserver view;
    private ZTreeJFileChooser fileChooser = new ZTreeJFileChooser();

    public SelectPaymentFileListener(FileSelectionObserver view)
    {
        this.view = view;
    }

    /**
     * Action performed.
     *
     * @param actionEvent The action event that triggered the action performed call.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        try {
            view.updateFileSelection(fileChooser.openZTreePayoffDialogSelection(view.getJPanel()));
        }
        catch(InvalidFileSelectedException exception) {
            view.updateStatus(StatusType.ERROR, exception.getMessage());
        }
    }
}
