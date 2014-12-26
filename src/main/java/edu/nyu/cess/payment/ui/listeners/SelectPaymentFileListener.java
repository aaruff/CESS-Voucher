package edu.nyu.cess.payment.ui.listeners;

import edu.nyu.cess.payment.exceptions.InvalidFileSelectedException;
import edu.nyu.cess.payment.io.ZTreeJFileChooser;
import edu.nyu.cess.payment.ui.FileSelectionObserver;
import edu.nyu.cess.payment.ui.StatusType;

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
     * @param e the e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            view.updateFileSelection(fileChooser.openZTreePayoffDialogSelection(view.getJPanel()));
        }
        catch(InvalidFileSelectedException e) {
            view.updateStatus(StatusType.ERROR, e.getMessage());
        }
    }
}
